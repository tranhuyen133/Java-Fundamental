import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1) Nhập dữ liệu
        System.out.print("Nhập mã sách: ");
        String bookID = sc.nextLine().trim();

        System.out.print("Nhập tên sách: ");
        String bookName = sc.nextLine().trim();

        System.out.print("Nhập năm xuất bản: ");
        int publishYear = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Nhập giá bìa: ");
        double price = Double.parseDouble(sc.nextLine().trim());

        System.out.print("Sách còn trong kho (true/false): ");
        boolean isAvailable = Boolean.parseBoolean(sc.nextLine().trim());

        // 2) Tính tuổi thọ sách
        int age = 2026 - publishYear;

        // 3) Chuẩn hóa hiển thị
        String upperName = bookName.toUpperCase();
        String status = isAvailable ? "Còn sách" : "Đã mượn";

        // 4) In phiếu thông tin
        System.out.println();
        System.out.println("--- PHIẾU THÔNG TIN SÁCH ---");
        System.out.println("Tên sách: " + upperName);
        System.out.println("Mã số: " + bookID + " | Tuổi thọ: " + age + " năm");
        System.out.printf("Giá bán: %.2f VND%n", price);
        System.out.println("Tình trạng: " + status);

        sc.close();
    }
}
