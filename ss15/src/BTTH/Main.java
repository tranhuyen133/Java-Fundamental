package BTTH;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HospitalManagement hm = new HospitalManagement();

        while (true) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Đăng ký khám bệnh (Create)");
            System.out.println("2. Gọi khám bệnh (Dequeue + push lịch sử)");
            System.out.println("3. Xem danh sách hàng đợi (Read)");
            System.out.println("4. Tìm kiếm bệnh nhân (Search)");
            System.out.println("5. Sắp xếp hàng đợi (Sort)");
            System.out.println("6. Xem lịch sử điều trị theo ID (Stack - LIFO)");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            String choice = sc.nextLine().trim();

            try {
                switch (choice) {
                    case "1" -> register(sc, hm);
                    case "2" -> hm.callNextAndTreat(sc);
                    case "3" -> hm.display();
                    case "4" -> doSearch(sc, hm);
                    case "5" -> doSort(sc, hm);
                    case "6" -> {
                        System.out.print("Nhập ID bệnh nhân: ");
                        String id = sc.nextLine().trim();
                        hm.viewHistory(id);
                    }
                    case "0" -> {
                        System.out.println("Bye!");
                        return;
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ.");
                }
            } catch (Exception e) {
                System.err.println("❌ Lỗi: " + e.getMessage());
            }
        }
    }

    private static void register(Scanner sc, HospitalManagement hm) {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine().trim();

        System.out.print("Nhập họ tên: ");
        String name = sc.nextLine().trim();

        int age = readInt(sc, "Nhập tuổi: ", 0, 150);

        System.out.print("Nhập tình trạng bệnh: ");
        String cond = sc.nextLine().trim();

        System.out.print("Có phải bệnh nhân cấp cứu không? (y/n): ");
        String yn = sc.nextLine().trim().toLowerCase();

        Patient p;
        if (yn.equals("y") || yn.equals("yes")) {
            int pr = readInt(sc, "Nhập mức độ ưu tiên (1-10): ", 1, 10);
            p = new EmergencyPatient(id, name, age, cond, pr);
        } else {
            p = new Patient(id, name, age, cond);
        }

        hm.add(p);
        System.out.println("✅ Đăng ký thành công!");
    }

    private static void doSearch(Scanner sc, HospitalManagement hm) {
        System.out.print("Nhập ID hoặc tên: ");
        String key = sc.nextLine();

        List<Patient> res = hm.search(key);
        if (res.isEmpty()) {
            System.out.println("(Không tìm thấy trong hàng đợi)");
            return;
        }
        System.out.println("=== KẾT QUẢ TÌM KIẾM ===");
        for (Patient p : res) p.showInfo();
    }

    private static void doSort(Scanner sc, HospitalManagement hm) {
        System.out.println("Chọn kiểu sắp xếp:");
        System.out.println("1. Theo tuổi giảm dần (già ưu tiên), nếu bằng tuổi -> tên A-Z");
        System.out.println("2. Theo ưu tiên cấp cứu (priority giảm dần), rồi tuổi giảm dần, rồi tên A-Z");
        int mode = readInt(sc, "Chọn (1/2): ", 1, 2);
        hm.sort(mode);
    }

    private static int readInt(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v < min || v > max) {
                    System.out.println("Giá trị phải nằm trong [" + min + ", " + max + "].");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên.");
            }
        }
    }
}
