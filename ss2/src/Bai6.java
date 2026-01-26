import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        long sum = 0;          // tổng lượt mượn các ngày mở cửa
        int openDays = 0;      // số ngày mở cửa (lượt mượn > 0)

        for (int i = 1; i <= 7; i++) {
            String dayName = dayOfWeekName(i); // Thu 2 ... Chu nhat
            int borrowCount = readNonNegativeInt(sc, "Nhap so luot muon sach cua " + dayName + ": ");

            if (borrowCount == 0) {
                // Ngày đóng cửa -> bỏ qua thống kê trung bình và cũng không update min/max
                continue;
            }

            // Tính tổng + đếm ngày mở cửa
            sum += borrowCount;
            openDays++;

            // Cập nhật max/min (biến tạm)
            if (borrowCount > max) max = borrowCount;
            if (borrowCount < min) min = borrowCount;
        }

        System.out.println("\n--- KET QUA THONG KE ---");

        if (openDays == 0) {
            System.out.println("Tuan nay khong co ngay mo cua (tat ca bang 0).");
        } else {
            double avg = (double) sum / openDays;
            System.out.println("Luot muon cao nhat: " + max);
            System.out.println("Luot muon thap nhat: " + min);
            System.out.printf("Trung binh (chi tinh ngay mo cua): %.2f%n", avg);
            System.out.println("So ngay mo cua: " + openDays);
        }

        sc.close();
    }

    private static String dayOfWeekName(int i) {
        // i = 1..7 tương ứng Thứ 2..Chủ nhật
        switch (i) {
            case 1: return "Thu 2";
            case 2: return "Thu 3";
            case 3: return "Thu 4";
            case 4: return "Thu 5";
            case 5: return "Thu 6";
            case 6: return "Thu 7";
            default: return "Chu nhat";
        }
    }

    private static int readNonNegativeInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v >= 0) return v;
                System.out.println("Gia tri khong duoc am. Vui long nhap lai.");
            } catch (NumberFormatException e) {
                System.out.println("Nhap sai dinh dang. Vui long nhap so nguyen.");
            }
        }
    }
}
