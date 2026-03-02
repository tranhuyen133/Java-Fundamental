package Bai5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static final DateTimeFormatter F = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static String now() {
        return LocalDateTime.now().format(F);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmergencyCaseQueue queue = new EmergencyCaseQueue();

        EmergencyCase currentCase = null; // ca đang được xử lý

        while (true) {
            System.out.println("\n========== MENU CẤP CỨU ==========");
            System.out.println("1. Thêm bệnh nhân vào hàng đợi (enqueue case)");
            System.out.println("2. Lấy ca tiếp theo để xử lý (dequeue case)");
            System.out.println("3. Thêm bước xử lý cho ca hiện tại (push step)");
            System.out.println("4. Undo bước xử lý gần nhất (pop step)");
            System.out.println("5. Xem các bước xử lý của ca hiện tại");
            System.out.println("6. Xem danh sách ca đang chờ");
            System.out.println("7. Xem ca tiếp theo sẽ xử lý (peek)");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    Patient p = inputPatient(sc);
                    EmergencyCase c = new EmergencyCase(p);
                    queue.addCase(c);
                    System.out.println(" Đã thêm ca vào Queue: " + c);
                }
                case "2" -> {
                    currentCase = queue.getNextCase();
                    if (currentCase != null) {
                        System.out.println("👨‍️ Đang xử lý ca: " + currentCase.getPatient());
                    }
                }
                case "3" -> {
                    if (currentCase == null) {
                        System.err.println(" Chưa có ca nào đang xử lý. Hãy chọn (2) trước.");
                        break;
                    }
                    System.out.print("Nhập mô tả bước xử lý (tiếp nhận/chẩn đoán/điều trị...): ");
                    String desc = sc.nextLine().trim();
                    if (desc.isEmpty()) desc = "(Không nhập mô tả)";
                    currentCase.addStep(new TreatmentStep(desc, now()));
                    System.out.println(" Đã push bước xử lý. Tổng steps = " + currentCase.getSteps().size());
                }
                case "4" -> {
                    if (currentCase == null) {
                        System.err.println(" Chưa có ca nào đang xử lý.");
                        break;
                    }
                    TreatmentStep undone = currentCase.undoStep();
                    if (undone != null) {
                        System.out.println(" Đã Undo: " + undone);
                    }
                }
                case "5" -> {
                    if (currentCase == null) {
                        System.err.println(" Chưa có ca nào đang xử lý.");
                        break;
                    }
                    System.out.println("Ca hiện tại: " + currentCase.getPatient());
                    currentCase.displaySteps();
                }
                case "6" -> queue.displayQueue();
                case "7" -> {
                    EmergencyCase next = queue.peekNextCase();
                    if (next == null) System.out.println("(Queue trống)");
                    else System.out.println("Ca tiếp theo sẽ xử lý: " + next.getPatient());
                }
                case "0" -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static Patient inputPatient(Scanner sc) {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine().trim();

        System.out.print("Nhập tên: ");
        String name = sc.nextLine().trim();

        int age = readInt(sc, "Nhập tuổi: ", 0, 150);

        return new Patient(id, name, age);
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
