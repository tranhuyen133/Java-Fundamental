package Bai1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static final DateTimeFormatter F =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static String now() {
        return LocalDateTime.now().format(F);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MedicalRecordHistory mrh = new MedicalRecordHistory();

        while (true) {
            System.out.println("\n====== MENU STACK (LỊCH SỬ BỆNH ÁN) ======");
            System.out.println("1. Thêm chỉnh sửa (push)");
            System.out.println("2. Undo chỉnh sửa gần nhất (pop)");
            System.out.println("3. Xem chỉnh sửa gần nhất (peek)");
            System.out.println("4. Hiển thị toàn bộ lịch sử");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.print("Nhập mô tả chỉnh sửa: ");
                    String desc = sc.nextLine().trim();
                    if (desc.isEmpty()) desc = "(Không nhập mô tả)";

                    EditAction action = new EditAction(desc, now());
                    mrh.addEdit(action);

                    System.out.println(" Đã push 1 chỉnh sửa vào Stack.");
                    mrh.displayStackState();
                }
                case "2" -> {
                    EditAction undone = mrh.undoEdit();
                    if (undone != null) {
                        System.out.println(" Undo thành công: " + undone);
                    }
                    mrh.displayStackState();
                }
                case "3" -> {
                    EditAction latest = mrh.getLatestEdit();
                    if (latest != null) {
                        System.out.println(" Chỉnh sửa gần nhất: " + latest);
                    }
                    mrh.displayStackState();
                }
                case "4" -> {
                    mrh.displayHistory();
                    mrh.displayStackState();
                }
                case "0" -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
