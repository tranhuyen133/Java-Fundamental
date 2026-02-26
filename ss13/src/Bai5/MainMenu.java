package Bai5;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientManager manager = new PatientManager();

        while (true) {
            printMenu();
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.print("Nhập ID bệnh nhân: ");
                String id = sc.nextLine();

                System.out.print("Nhập tên bệnh nhân: ");
                String fullName = sc.nextLine();

                System.out.print("Nhập tuổi: ");
                int age = Integer.parseInt(sc.nextLine());

                System.out.print("Nhập chẩn đoán: ");
                String diagnosis = sc.nextLine();

                manager.addPatient(new Patient(id, fullName, age, diagnosis));
            }

            else if (choice == 2) {
                System.out.print("Nhập ID bệnh nhân để cập nhật chẩn đoán: ");
                String id = sc.nextLine();

                System.out.print("Nhập chẩn đoán mới: ");
                String newDiagnosis = sc.nextLine();

                manager.updateDiagnosis(id, newDiagnosis);
            }

            else if (choice == 3) {
                System.out.print("Nhập ID bệnh nhân để xuất viện: ");
                String id = sc.nextLine();

                manager.dischargePatient(id);
            }

            else if (choice == 4) {
                manager.sortPatients();
            }

            else if (choice == 5) {
                manager.displayPatients();
            }

            else if (choice == 6) {
                System.out.println("Thoát chương trình.");
                break;
            }

            else {
                System.out.println("Chức năng không hợp lệ, vui lòng chọn lại!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("||==================== MENU ====================||");
        System.out.println("||  1. Tiếp nhận bệnh nhân                      ||");
        System.out.println("||  2. Cập nhật chẩn đoán                       ||");
        System.out.println("||  3. Xuất viện                                ||");
        System.out.println("||  4. Sắp xếp danh sách bệnh nhân              ||");
        System.out.println("||  5. Hiển thị danh sách bệnh nhân             ||");
        System.out.println("||  6. Thoát                                    ||");
        System.out.println("||==============================================||");
    }
}