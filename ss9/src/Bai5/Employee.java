package Bai5;

public abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Runtime polymorphism: lớp con bắt buộc override
    public abstract long calculateSalary();

    // Không dùng if/instanceof trong Main:
    // Mỗi lớp con tự mô tả loại + chi tiết lương của mình
    public abstract String getType();
    public abstract String getSalaryDetail();
}
