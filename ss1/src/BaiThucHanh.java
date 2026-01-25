import java.util.Scanner;

public class BaiThucHanh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Khai báo biến
        int bookID;
        String title;
        double price;
        int quantity;
        boolean isAvailable;

        // Nhập dữ liệu
        System.out.print("Nhập mã sách: ");
        bookID = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Nhập tên sách: ");
        title = sc.nextLine();

        System.out.print("Nhập giá nhập: ");
        price = Double.parseDouble(sc.nextLine().trim());

        System.out.print("Nhập số lượng: ");
        quantity = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Sách còn trong kho? (true/false): ");
        isAvailable = Boolean.parseBoolean(sc.nextLine().trim());

        // Xử lý logic & tính toán
        double totalValue = price * quantity;               // tổng giá trị kho (chưa VAT nếu đề không bắt buộc in VAT)
        boolean isLargeStock = quantity > 100;              // kho lớn?
        boolean canBorrow = isAvailable && quantity > 0;    // có thể mượn?

        // Trạng thái kho hiển thị chữ thay vì true/false
        String statusText = (isAvailable && quantity > 0) ? "Còn hàng" : "Hết hàng";

        // In báo cáo
        System.out.println("===== BÁO CÁO TÌNH TRẠNG SÁCH =====");
        System.out.println("Mã sách: " + bookID);
        System.out.println("Tên sách: " + title);
        System.out.printf("Giá nhập: %.2f%n", price);
        System.out.println("Số lượng: " + quantity);
        System.out.printf("Tổng giá trị kho: %.2f%n", totalValue);
        System.out.println("Kho lớn (>100 sách): " + isLargeStock);
        System.out.println("Trạng thái: " + statusText);
        System.out.println("Có thể mượn: " + canBorrow);
    }
}
