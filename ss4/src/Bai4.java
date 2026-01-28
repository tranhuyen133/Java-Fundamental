import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã thẻ thư viện: ");
        String cardID = sc.nextLine().trim();

        // Regex: 2 chữ hoa + (4 số năm) + (5 số ngẫu nhiên)
        String regex = "^[A-Z]{2}(\\d{4})(\\d{5})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardID);

        if (matcher.matches()) {
            // Lấy năm từ group(1) (vì ta đặt ngoặc (\\d{4}))
            int year = Integer.parseInt(matcher.group(1));

            // Kiểm tra năm hợp lệ (tuỳ bạn đặt điều kiện; ví dụ: 2000..2026)
            if (year < 2000 || year > 2026) {
                System.out.println("Năm không hợp lệ!");
            } else {
                System.out.println("Mã thẻ hợp lệ!");
            }

        } else {
            // ===== Thông báo lỗi cụ thể (cơ bản) =====
            if (cardID.length() != 11) {
                System.out.println(" Sai độ dài! Mã thẻ phải có đúng 11 ký tự (2 chữ + 9 số).");
                return;
            }

            // 1) Kiểm tra tiền tố 2 chữ cái viết hoa
            if (cardID.length() >= 2) {
                String prefix = cardID.substring(0, 2);
                if (!prefix.matches("[A-Z]{2}")) {
                    System.out.println(" Thiếu tiền tố 2 chữ cái viết hoa (ví dụ: TV)!");
                    return;
                }
            }

            // 2) Kiểm tra phần năm (4 chữ số)
            if (cardID.length() >= 6) {
                String yearPart = cardID.substring(2, 6);
                if (!yearPart.matches("\\d{4}")) {
                    System.out.println(" Năm không hợp lệ (phải là 4 chữ số)!");
                    return;
                }
            }

            // 3) Kiểm tra 5 số cuối
            if (cardID.length() >= 11) {
                String lastPart = cardID.substring(6, 11);
                if (!lastPart.matches("\\d{5}")) {
                    System.out.println(" 5 ký tự cuối không hợp lệ (phải là 5 chữ số)!");
                    return;
                }
            }

            // Nếu rơi vào trường hợp ký tự lạ (không phải chữ/ số đúng chỗ)
            System.out.println(" Sai định dạng chung!");
        }
    }
}
