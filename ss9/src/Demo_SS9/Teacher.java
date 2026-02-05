package Demo_SS9;

public class Teacher extends Employee {
    private String expertise;
    private int hours;

    public Teacher() {
    }

    public Teacher(String name, int age, double baseSalary, String expertise, int hours) {
        super(name, age, baseSalary);
        this.expertise = expertise;
        this.hours = hours;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name=" + super.getName() +
                "age=" + super.getAge() +
                "baseSalary=" + super.getBaseSalary() +
                "class=" + super.getClass() +
                "hours=" + hours +
                "expertise='" + expertise + '\'' +
                ", hours=" + hours +
                '}';
    }
}
