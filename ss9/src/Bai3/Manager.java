package Bai3;

public class Manager extends Employee {
    private String department;

    // Constructor dùng super() để gọi constructor lớp cha
    public Manager(String name, double baseSalary, String department) {
        super(name, baseSalary); // super() phải là dòng đầu tiên
        this.department = department;
    }

    // Hiển thị đầy đủ thông tin
    @Override
    public void displayInfo() {
        super.displayInfo(); // dùng super để gọi lại displayInfo của Employee
        System.out.println("Phòng ban: " + department);
    }
}
