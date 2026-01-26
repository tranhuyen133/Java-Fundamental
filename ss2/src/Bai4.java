import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int id;

        do {
            System.out.print("Nhap ma ID sach moi (phai > 0): ");
            id = readInt(sc);

            if (id <= 0) {
                System.out.println("Loi: ID phai la so duong. Moi nhap lai!");
            }
        } while (id <= 0);

        System.out.println("Luu ma sach thanh cong!");
        // Neu muon giong anh hon:
        // System.out.println("Ghi nhan: Ma sach " + id + " da duoc ghi nhan.");

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
