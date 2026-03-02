package Bai2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientQueue pq = new PatientQueue();

        while (true) {
            System.out.println("\n====== MENU QUEUE (KHÁM THƯỜNG) ======");
            System.out.println("1. Thêm bệnh nhân vào hàng đợi (enqueue)");
            System.out.println("2. Gọi bệnh nhân tiếp theo (dequeue)");
            System.out.println("3. Xem bệnh nhân tiếp theo (peek)");
            System.out.println("4. Hiển thị danh sách chờ");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.print("Nhập ID: ");
                    String id = sc.nextLine().trim();

                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine().trim();

                    int age = readInt(sc, "Nhập tuổi: ", 0, 150);

                    pq.addPatient(new Patient(id, name, age));
                    System.out.println(" Đã enqueue bệnh nhân.");
                    pq.displayQueueState();
                }
                case "2" -> {
                    Patient next = pq.callNextPatient();
                    if (next != null) {
                        System.out.println(" Đang gọi khám: " + next);
                    }
                    pq.displayQueueState();
                }
                case "3" -> {
                    Patient next = pq.peekNextPatient();
                    if (next != null) {
                        System.out.println(" Bệnh nhân tiếp theo sẽ được khám: " + next);
                    }
                    pq.displayQueueState();
                }
                case "4" -> {
                    pq.displayQueue();
                    pq.displayQueueState();
                }
                case "0" -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
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

