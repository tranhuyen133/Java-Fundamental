import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập dữ liệu thô
        System.out.print("Nhập tên sách: ");
        String titleRaw = sc.nextLine();

        System.out.print("Nhập tác giả: ");
        String authorRaw = sc.nextLine();

        System.out.print("Nhập thể loại: ");
        String categoryRaw = sc.nextLine();

        // 1) Xoá khoảng trắng thừa 2 đầu + giữa các từ (dùng trim + split("\\s+"))
        String[] titleWords = titleRaw.trim().split("\\s+");
        String titleClean = "";
        for (int i = 0; i < titleWords.length; i++) {
            titleClean += titleWords[i];
            if (i < titleWords.length - 1) titleClean += " ";
        }

        String[] authorWords = authorRaw.trim().split("\\s+");
        String authorClean = "";
        for (int i = 0; i < authorWords.length; i++) {
            authorClean += authorWords[i];
            if (i < authorWords.length - 1) authorClean += " ";
        }

        String[] cateWords = categoryRaw.trim().split("\\s+");
        String categoryClean = "";
        for (int i = 0; i < cateWords.length; i++) {
            categoryClean += cateWords[i];
            if (i < cateWords.length - 1) categoryClean += " ";
        }

        // 2) Định dạng lại
        // - Tên sách: viết hoa toàn bộ
        String titleFormatted = titleClean.toUpperCase();

        // - Tên tác giả: viết hoa chữ cái đầu mỗi từ
        String authorFormatted = "";
        String[] aw = authorClean.toLowerCase().split("\\s+"); // đưa về thường trước cho dễ chuẩn hoá
        for (int i = 0; i < aw.length; i++) {
            String w = aw[i];
            String cap = w.substring(0, 1).toUpperCase() + w.substring(1);
            authorFormatted += cap;
            if (i < aw.length - 1) authorFormatted += " ";
        }

        // (Thể loại) cũng có thể chuẩn hoá nhẹ: viết thường hết (tuỳ bạn)
        String categoryFormatted = categoryClean.trim();

        // 3) Xuất chuỗi tổng hợp theo yêu cầu
        System.out.println("\n--- KẾT QUẢ ---");
        System.out.println("Thể loại: " + categoryFormatted);
        System.out.println("Chuỗi tổng hợp: [" + titleFormatted + "] - Tác giả: " + authorFormatted);
    }
}
