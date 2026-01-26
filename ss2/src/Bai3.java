import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        while (true) {
            System.out.print("Nhap so luong sach tra muon: ");
            n = readInt(sc);
            if (n > 0) break;
            System.out.println("So luong sach phai > 0. Vui long nhap lai.");
        }

        long total = 0;
        final int FINE_PER_DAY = 5000;

        for (int i = 1; i <= n; i++) {
            int lateDays;
            while (true) {
                System.out.print("Nhap so ngay tre cua cuon thu " + i + ": ");
                lateDays = readInt(sc);
                if (lateDays >= 0) break;
                System.out.println("So ngay tre khong duoc am. Nhap lai.");
            }

            total += (long) lateDays * FINE_PER_DAY;
        }

        System.out.println("===> Tong tien phat: " + total + " VND");

    }

    private static int readInt(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Nhap sai dinh dang. Vui long nhap so nguyen: ");
            }
        }
    }
}
