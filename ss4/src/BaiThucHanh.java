import java.util.Scanner;

public class BaiThucHanh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Regex cơ bản
        String bookIdRegex = "^LIB-\\d{4}-S$"; // LIB-xxxx-S
        String isbnRegex   = "^\\d{10}$";      // 10 chữ số
        String yearRegex   = "^\\d{4}$";       // 4 chữ số
        int currentYear = 2026;

        // ===== Nhập =====
        System.out.print("Nhập mã sách (LIB-xxxx-S): ");
        String bookId = sc.nextLine().trim();

        System.out.print("Nhập ISBN-10 (10 chữ số): ");
        String isbn = sc.nextLine().trim();

        System.out.print("Nhập tên sách: ");
        String titleRaw = sc.nextLine();

        System.out.print("Nhập tác giả: ");
        String authorRaw = sc.nextLine();

        System.out.print("Nhập năm xuất bản: ");
        String yearStr = sc.nextLine().trim();

        // ===== Validate (cơ bản: if + matches) =====
        if (!bookId.matches(bookIdRegex)) {
            System.out.println(" Sai mã sách. Ví dụ đúng: LIB-2024-S");
            return;
        }

        if (!isbn.matches(isbnRegex)) {
            System.out.println(" Sai ISBN-10. Phải đúng 10 chữ số.");
            return;
        }

        if (!yearStr.matches(yearRegex)) {
            System.out.println(" Sai năm xuất bản. Phải là 4 chữ số.");
            return;
        }

        int year = Integer.parseInt(yearStr);
        if (year > currentYear) {
            System.out.println("Năm xuất bản không được lớn hơn " + currentYear);
            return;
        }

        // ===== Chuẩn hoá tên sách / tác giả (cơ bản) =====
        // 1) trim
        // 2) split("\\s+")
        // 3) viết hoa chữ cái đầu mỗi từ
        String title = "";
        String[] tWords = titleRaw.trim().split("\\s+");
        for (int i = 0; i < tWords.length; i++) {
            String w = tWords[i].toLowerCase();
            String cap = w.substring(0, 1).toUpperCase() + w.substring(1);
            title += cap;
            if (i < tWords.length - 1) title += " ";
        }

        String author = "";
        String[] aWords = authorRaw.trim().split("\\s+");
        for (int i = 0; i < aWords.length; i++) {
            String w = aWords[i].toLowerCase();
            String cap = w.substring(0, 1).toUpperCase() + w.substring(1);
            author += cap;
            if (i < aWords.length - 1) author += " ";
        }

        // ===== Trích dẫn bằng StringBuilder =====
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bookId).append("] - ")
                .append(title).append(" - ")
                .append(author).append(" (")
                .append(year).append(")");
        String citation = sb.toString();

        // ===== In kết quả =====
        System.out.println("\n----- KẾT QUẢ BIÊN MỤC -----");
        System.out.println("Mã sách chuẩn: " + bookId);
        System.out.println("ISBN-10: " + isbn);
        System.out.println("Tên sách: " + title);
        System.out.println("Tác giả: " + author);
        System.out.println("Năm XB: " + year);
        System.out.println("Trích dẫn: " + citation);
        System.out.println("----------------------------");

        // Giải thích ngắn gọn (theo đề)
        System.out.println("\nGhi chú: StringBuilder tối ưu hơn '+' khi nối nhiều phần vì String là immutable.");
    }
}
