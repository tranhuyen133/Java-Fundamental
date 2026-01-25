import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã sách (4 chữ số): ");
        int code = Integer.parseInt(sc.nextLine().trim());

        // Tách 4 chữ số bằng toán tử số học (không dùng String)
        int thousands = code / 1000;            // hàng nghìn
        int hundreds  = (code / 100) % 10;      // hàng trăm
        int dozens    = (code / 10) % 10;       // hàng chục
        int units     = code % 10;              // hàng đơn vị (check-digit)

        int sumOfFirstThreeNumber = thousands + hundreds + dozens;
        int expectedCheckDigit = sumOfFirstThreeNumber % 10;

        System.out.println("Chữ số kiểm tra kỳ vọng: " + expectedCheckDigit);

        boolean isValid = (expectedCheckDigit == units);

        System.out.print("Kết quả kiểm tra mã sách: ");
        System.out.println(isValid ? "HỢP LỆ" : "SAI MÃ");

    }
}
