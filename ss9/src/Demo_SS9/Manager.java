package Demo_SS9;

public class Manager extends Employee{
    private String department;
    private int numberOfEmployee;

    public Manager() {
    }

    public Manager(String name, int age, double baseSalary, String department, int numberOfEmployee) {
        super(name, age, baseSalary);
        this.department = department;
        this.numberOfEmployee = numberOfEmployee;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(int numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }
}
