package Bai5;

public class OfficeEmployee extends Employee {
    private long baseSalary;

    public OfficeEmployee(String name, long baseSalary) {
        super(name);
        this.baseSalary = baseSalary;
    }

    @Override
    public long calculateSalary() {
        return baseSalary;
    }

    @Override
    public String getType() {
        return "Office";
    }

    @Override
    public String getSalaryDetail() {
        return ""; // lương văn phòng không cần diễn giải thêm
    }
}

