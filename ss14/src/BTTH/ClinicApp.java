package BTTH;

import java.util.Scanner;

public class ClinicApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientService service = new PatientService(sc);

        while (true) {
            System.out.println("\n========= QUẢN LÝ PHÒNG KHÁM =========");
            System.out.println("1. Thêm bệnh nhân");
            System.out.println("2. Cập nhật bệnh nhân");
            System.out.println("3. Xóa bệnh nhân");
            System.out.println("4. Hiển thị danh sách bệnh nhân");
            System.out.println("------------------------------------");
            System.out.println("5. Thêm hồ sơ khám bệnh");
            System.out.println("6. Xem hồ sơ theo bệnh nhân");
            System.out.println("7. Xóa hồ sơ khám");
            System.out.println("------------------------------------");
            System.out.println("8. Tìm kiếm");
            System.out.println("9. Sắp xếp bệnh nhân");
            System.out.println("------------------------------------");
            System.out.println("0. Thoát chương trình");
            System.out.println("====================================");
            System.out.print("Chọn chức năng: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    service.addPatientFromInput();
                    break;
                case "2": {
                    System.out.print("Nhập ID cần cập nhật: ");
                    String id = sc.nextLine().trim();
                    service.update(id);
                    break;
                }
                case "3": {
                    System.out.print("Nhập ID cần xóa: ");
                    String id = sc.nextLine().trim();
                    service.delete(id);
                    break;
                }
                case "4":
                    service.displayAll();
                    break;
                case "5":
                    service.addMedicalRecord();
                    break;
                case "6":
                    service.viewRecordsByPatient();
                    break;
                case "7":
                    service.deleteMedicalRecord();
                    break;
                case "8":
                    System.out.println("1. Tìm bệnh nhân");
                    System.out.println("2. Tìm hồ sơ");
                    System.out.print("Chọn: ");
                    String sub = sc.nextLine().trim();
                    if ("1".equals(sub)) service.searchPatient();
                    else if ("2".equals(sub)) service.searchMedicalRecord();
                    else System.out.println("Lựa chọn không hợp lệ!");
                    break;
                case "9":
                    service.sortPatientsMenu();
                    break;
                case "0":
                    System.out.println("Tạm biệt!");
                    sc.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}