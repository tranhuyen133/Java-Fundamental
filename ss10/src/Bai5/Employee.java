package Bai5;

public abstract class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Mỗi loại nhân viên tự tính lương (đa hình runtime)
    public abstract double calculateSalary();

    // Dùng chung để in thông tin
    public void display() {
        System.out.printf("%s - Lương cơ bản: %.0f - Lương nhận: %.0f%n",
                name, baseSalary, calculateSalary());
    }
}

