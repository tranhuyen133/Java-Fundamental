package BTTH;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientManager manager = new PatientManager();

        while (true) {
            System.out.println("\n===== MENU QUẢN LÝ BỆNH NHÂN =====");
            System.out.println("1. Thêm bệnh nhân");
            System.out.println("2. Xóa bệnh nhân theo ID");
            System.out.println("3. Cập nhật bệnh nhân theo ID");
            System.out.println("4. Tìm kiếm bệnh nhân theo tên");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Hiển thị danh sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 0) {
                System.out.println("Kết thúc chương trình.");
                break;
            }

            if (choice == 1) {
                System.out.print("ID: ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.print("Tên: ");
                String name = sc.nextLine();
                System.out.print("Tuổi: ");
                int age = Integer.parseInt(sc.nextLine());
                System.out.print("Giới tính: ");
                String gender = sc.nextLine();
                System.out.print("Bệnh lý: ");
                String disease = sc.nextLine();

                Patient p = new Patient(id, name, age, gender, disease);
                manager.addPatient(p);
            }

            if (choice == 2) {
                System.out.print("Nhập ID cần xóa: ");
                int id = Integer.parseInt(sc.nextLine());
                manager.removePatient(id);
            }

            if (choice == 3) {
                System.out.print("Nhập ID cần cập nhật: ");
                int id = Integer.parseInt(sc.nextLine());

                System.out.print("Tên mới: ");
                String name = sc.nextLine();
                System.out.print("Tuổi mới: ");
                int age = Integer.parseInt(sc.nextLine());
                System.out.print("Giới tính mới: ");
                String gender = sc.nextLine();
                System.out.print("Bệnh lý mới: ");
                String disease = sc.nextLine();

                Patient updated = new Patient(id, name, age, gender, disease);
                manager.updatePatient(id, updated);
            }

            if (choice == 4) {
                System.out.print("Nhập tên cần tìm: ");
                String name = sc.nextLine();
                manager.searchPatientByName(name);
            }

            if (choice == 5) {
                System.out.println("1. Tuổi tăng dần");
                System.out.println("2. Tuổi giảm dần");
                System.out.println("3. Tên A-Z");
                System.out.println("4. Tên Z-A");
                System.out.print("Chọn: ");
                int opt = Integer.parseInt(sc.nextLine());

                if (opt == 1) manager.sortPatientsByAge(true);
                if (opt == 2) manager.sortPatientsByAge(false);
                if (opt == 3) manager.sortPatientsByName(true);
                if (opt == 4) manager.sortPatientsByName(false);
            }

            if (choice == 6) {
                manager.displayPatients();
            }
        }
    }
}
