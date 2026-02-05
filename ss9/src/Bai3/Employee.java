package Bai3;

public class Employee {
    protected String name;
    protected double baseSalary;

    // Constructor có tham số
    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public void displayInfo() {
        System.out.println("Tên: " + name);
        System.out.println("Lương cơ bản: " + baseSalary);
    }
}
