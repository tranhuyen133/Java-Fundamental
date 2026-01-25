import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập dữ liệu
        System.out.print("Nhập số ngày chậm trễ: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Nhập số lượng sách mượn: ");
        int m = Integer.parseInt(sc.nextLine().trim());

        // Tiền phạt gốc
        double baseFine = n * m * 5000.0;

        // Điều chỉnh theo điều kiện đặc biệt: n > 7 và m >= 3 thì tăng 20%
        double adjustedFine = baseFine;
        if (n > 7 && m >= 3) {
            adjustedFine = baseFine * 1.2;
        }

        // Yêu cầu khóa thẻ: true nếu tiền phạt > 50,000
        boolean lockCard = adjustedFine > 50000;

        // Xuất kết quả
        System.out.println("Tiền phạt gốc: " + baseFine + " VND");
        System.out.println("Tiền phạt sau điều chỉnh: " + adjustedFine + " VND");
        System.out.println("Yêu cầu khóa thẻ: " + lockCard);

    }
}
