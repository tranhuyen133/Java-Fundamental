public class Bai4 {

    // Định nghĩa class Employee
    static class Employee {
        private String empId;
        private String empName;
        private double salary;

        // Constructor không tham số
        public Employee() {
            this.empId = "0000";
            this.empName = "Unknown";
            this.salary = 0.0;
        }

        // Constructor có mã và tên
        public Employee(String empId, String empName) {
            this.empId = empId;
            this.empName = empName;
            this.salary = 0.0; // mặc định
        }

        // Constructor đầy đủ: mã, tên, lương
        public Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
        }

        // Phương thức hiển thị thông tin
        public void displayInfo() {
            System.out.println("------------------------------");
            System.out.println("Mã NV   : " + empId);
            System.out.println("Tên NV  : " + empName);
            System.out.printf("Lương   : %.0f VNĐ\n", salary);
            System.out.println("------------------------------");
        }
    }

    // Lớp Main kiểm thử
    public static void main(String[] args) {
        // Khởi tạo bằng constructor không tham số
        Employee e1 = new Employee();

        // Khởi tạo bằng constructor có mã và tên
        Employee e2 = new Employee("E001", "Nguyễn Văn A");

        // Khởi tạo bằng constructor đầy đủ
        Employee e3 = new Employee("E002", "Trần Thị B", 12000000);

        // Hiển thị thông tin từng nhân viên
        System.out.println("=== Thông tin nhân viên ===");
        e1.displayInfo();
        e2.displayInfo();
        e3.displayInfo();
    }
}
