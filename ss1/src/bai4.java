import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập giá sách USD (double)
        System.out.print("Nhập giá sách (USD - kiểu double): ");
        double usdPrice = Double.parseDouble(sc.nextLine().trim());

        // Nhập tỷ giá (float)
        System.out.print("Nhập tỷ giá (VND/USD - kiểu float): ");
        float rate = Float.parseFloat(sc.nextLine().trim());

        // Tính tiền VNĐ (double)
        double vndExact = usdPrice * rate;

        // Ép kiểu sang long để có số tiền chẵn (cắt phần thập phân)
        long vndRounded = (long) vndExact;

        // In kết quả
        System.out.println("Giá chính xác (số thực): " + vndExact);
        System.out.println("Giá làm tròn để thanh toán (long): " + vndRounded);


    }
}
