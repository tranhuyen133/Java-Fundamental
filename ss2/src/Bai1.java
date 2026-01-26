import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int age = readNonNegativeInt(sc, "Nhap tuoi cua ban: ");
        int borrowing = readNonNegativeInt(sc, "Nhap so sach dang muon: ");

        boolean okAge = age >= 18;
        boolean okBorrowing = borrowing < 3;

        if (okAge && okBorrowing) {
            System.out.println("Ket qua: Ban DU DIEU KIEN muon sach quy hiem.");
            // Hoac theo de: System.out.println("Ket qua: Cho phep muon sach");
        } else {
            System.out.println("Ket qua: Khong du dieu kien.");

            if (!okAge) {
                System.out.println("- Ly do: Ban phai tu 18 tuoi tro len.");
            }
            if (!okBorrowing) {
                System.out.println("- Ly do: Ban da muon toi da 3 cuon.");
            }
        }

        sc.close();
    }

    // Validation: bat nguoi dung nhap so nguyen >= 0
    private static int readNonNegativeInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                int value = Integer.parseInt(s);
                if (value >= 0) return value;
                System.out.println("Gia tri khong duoc am. Vui long nhap lai.");
            } catch (NumberFormatException e) {
                System.out.println("Nhap sai dinh dang. Vui long nhap so nguyen.");
            }
        }
    }
}
