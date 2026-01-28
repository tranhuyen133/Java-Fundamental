import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai6 {
    public static void main(String[] args) {

        // Ví dụ review
        String review = "Cuốn sách này rất tệ, nội dung thật là ngu ngốc và không đáng đọc.";

        // 1) Blacklist
        String[] blacklist = {"tệ", "ngu ngốc", "đáng ghét", "dở"};

        // 2) Lọc từ nhạy cảm bằng Regex
        String filtered = censorByBlacklist(review, blacklist);

        // 3) Nếu quá dài > 200 ký tự: cắt không cắt ngang từ + thêm "..."
        String finalText = shortenIfTooLong(filtered, 200);

        System.out.println("Review sau khi xử lý: " + finalText);
    }

    // Thay từ nhạy cảm bằng dấu * theo độ dài từ
    static String censorByBlacklist(String text, String[] blacklist) {
        String result = text;

        for (int i = 0; i < blacklist.length; i++) {
            String badWord = blacklist[i];

            // Tạo regex match theo "cụm từ" và không phân biệt hoa thường
            // Pattern.quote để escape các ký tự đặc biệt (nếu có)
            Pattern p = Pattern.compile(Pattern.quote(badWord), Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher m = p.matcher(result);

            StringBuilder sb = new StringBuilder();
            int lastEnd = 0;

            while (m.find()) {
                // Giữ phần trước match
                sb.append(result, lastEnd, m.start());

                // Lấy đúng đoạn match thực tế trong text để tính độ dài (bao gồm khoảng trắng nếu blacklist có)
                String matched = result.substring(m.start(), m.end());

                // Tạo chuỗi sao theo độ dài (bỏ khoảng trắng để số sao đẹp hơn)
                int starCount = matched.replace(" ", "").length();
                sb.append(makeStars(starCount));

                lastEnd = m.end();
            }

            // Nối phần còn lại sau match cuối
            sb.append(result.substring(lastEnd));

            result = sb.toString();
        }

        return result;
    }

    // Tạo chuỗi "*****" với n ký tự
    static String makeStars(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append('*');
        return sb.toString();
    }

    // Cắt chuỗi nếu vượt maxLen, nhưng KHÔNG cắt ngang giữa 1 từ
    // Yêu cầu: dùng substring + StringBuilder + thêm "..."
    static String shortenIfTooLong(String text, int maxLen) {
        if (text.length() <= maxLen) return text;

        // Lấy trước maxLen ký tự
        String cut = text.substring(0, maxLen);

        // Tìm vị trí khoảng trắng cuối cùng để không cắt ngang từ
        int lastSpace = cut.lastIndexOf(' ');
        if (lastSpace == -1) {
            // Trường hợp cực đoan: không có dấu cách, cắt thẳng
            lastSpace = maxLen;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(text.substring(0, lastSpace).trim());
        sb.append("...");

        return sb.toString();
    }
}
