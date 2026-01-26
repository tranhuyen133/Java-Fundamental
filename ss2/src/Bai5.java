import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int score = 100;
        int days;

        System.out.println("--- HE THONG DANH GIA DOC GIA ---");
        System.out.println("(Nhap so ngay tre. Nhap 999 de ket thuc)");

        while (true) {
            System.out.print("So ngay tre cua lan nay: ");
            days = readInt(sc);

            if (days == 999) {
                break;
            }

            if (days <= 0) {
                score += 5;
                System.out.println("-> Tra dung han: +5 diem.");
            } else {
                int minus = days * 2;
                score -= minus;
                System.out.println("-> Tra tre " + days + " ngay: -" + minus + " diem.");
            }

            System.out.println();
        }

        System.out.println("Tong diem uy tin: " + score);
        System.out.println("Xep loai: " + classify(score));

    }

    private static String classify(int score) {
        if (score > 120) return "DOC GIA THAN THIET";
        if (score >= 80) return "DOC GIA TIEU CHUAN";
        return "DOC GIA CAN LUU Y";
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
