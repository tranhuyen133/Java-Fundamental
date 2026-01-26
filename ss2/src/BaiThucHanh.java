import java.util.Scanner;

public class BaiThucHanh {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========== MENU QUAN LY THU VIEN ==========");
            System.out.println("1. Tinh tien phat tra sach (For)");
            System.out.println("2. Dang ky the muon sach VIP (If-Else & toan tu dieu kien)");
            System.out.println("3. Thong ke sach nhap kho (Do-While & Break/Continue)");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            int choice = readInt(sc);

            switch (choice) {
                case 1:
                    function1_CalcFine(sc);
                    break;
                case 2:
                    function2_CheckVIP(sc);
                    break;
                case 3:
                    function3_StockIn(sc);
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh.");
                    sc.close();
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon 0-3.");
            }
        }
    }

    // =========================
    // Chuc nang 1: Tinh tien phat (For)
    // =========================
    private static void function1_CalcFine(Scanner sc) {
        System.out.println("\n--- CHUC NANG 1: TINH TIEN PHAT TRA SACH ---");
        int bookCount;

        while (true) {
            System.out.print("Nhap so luong sach doc gia tra: ");
            bookCount = readInt(sc);
            if (bookCount > 0) break;
            System.out.println("So luong sach phai > 0. Nhap lai.");
        }

        long totalFine = 0;

        for (int i = 1; i <= bookCount; i++) {
            int overdueDays;
            while (true) {
                System.out.print("Nhap so ngay qua han cua cuon sach thu " + i + ": ");
                overdueDays = readInt(sc);
                if (overdueDays >= 0) break;
                System.out.println("So ngay qua han khong duoc am. Nhap lai.");
            }

            long fineForThisBook = calcFineByDays(overdueDays);
            totalFine += fineForThisBook;
        }

        System.out.println("Tong tien phat: " + totalFine + " VND");
    }

    private static long calcFineByDays(int overdueDays) {
        // 1-5 ngay: 2000/ngay
        // >5 ngay: 2000*5 + 5000*(overdueDays-5)
        if (overdueDays <= 0) return 0;

        if (overdueDays <= 5) {
            return (long) overdueDays * 2000;
        }
        return 5L * 2000 + (long) (overdueDays - 5) * 5000;
    }

    // =========================
    // Chuc nang 2: VIP (If-Else & toan tu dieu kien)
    // =========================
    private static void function2_CheckVIP(Scanner sc) {
        System.out.println("\n--- CHUC NANG 2: DANG KY THE VIP ---");

        int age;
        while (true) {
            System.out.print("Nhap tuoi: ");
            age = readInt(sc);
            if (age >= 0) break;
            System.out.println("Tuoi khong hop le. Nhap lai.");
        }

        int borrowed;
        while (true) {
            System.out.print("Nhap so sach da muon trong thang qua: ");
            borrowed = readInt(sc);
            if (borrowed >= 0) break;
            System.out.println("So sach khong duoc am. Nhap lai.");
        }

        int priority;
        while (true) {
            System.out.print("La sinh vien co the uu tien? (1: Co, 0: Khong): ");
            priority = readInt(sc);
            if (priority == 0 || priority == 1) break;
            System.out.println("Chi duoc nhap 0 hoac 1. Nhap lai.");
        }

        boolean isVip = (age >= 18 && borrowed >= 10) || (priority == 1);

        System.out.println(isVip
                ? "Du tieu chuan nang cap VIP"
                : "Chua du tieu chuan");
    }

    // =========================
    // Chuc nang 3: Nhap kho (Do-While & Break/Continue)
    // =========================
    private static void function3_StockIn(Scanner sc) {
        System.out.println("\n--- CHUC NANG 3: THONG KE SACH NHAP KHO ---");
        System.out.println("Nhap ma sach moi:");
        System.out.println("- Neu ma < 0: bat nhap lai (continue)");
        System.out.println("- Neu ma = 0: dung nhap kho (break)");

        int validCount = 0;

        do {
            System.out.print("Nhap ma sach: ");
            int code = readInt(sc);

            if (code < 0) {
                System.out.println("Ma sach am. Vui long nhap lai.");
                continue;
            }

            if (code == 0) {
                System.out.println("Dung nhap kho.");
                break;
            }

            // code > 0 hop le
            validCount++;

        } while (true);

        System.out.println("Tong so luong sach hop le da nhap: " + validCount);
    }

    // =========================
    // Ham doc so nguyen an toan (Validation input)
    // =========================
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
