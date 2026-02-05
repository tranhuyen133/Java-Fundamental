package Demo_SS9;

public class Employee {
    private String name;
    private int age;
    private double baseSalary;

    // phương thức
    public Employee() {

    }

    public Employee(String name, int age, double baseSalary) {
        this.name = name;
        this.age = age;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

}
