import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số thứ tự của sách trong hệ thống: ");
        int stt = Integer.parseInt(sc.nextLine().trim());

        // Mỗi kệ chứa 25 cuốn
        int shelf = (stt - 1) / 25 + 1;          // kệ số mấy
        int position = (stt - 1) % 25 + 1;       // vị trí trên kệ (1..25)

        // Khu vực theo kệ
        String area = (shelf >= 1 && shelf <= 10) ? "Khu Cận (Gần cửa)" : "Khu Viễn (Cuối kho)";

        System.out.println();
        System.out.println("--- THÔNG TIN ĐỊNH VỊ ---");
        System.out.println("Sách số: " + stt);
        System.out.println("Địa chỉ: Kệ " + shelf + " - Vị trí " + stt);
        System.out.println("Phân khu: " + area);

    }
}
