package Bai5;

public class Manager extends Employee implements BonusCalculator {
    private double kpiBonus;

    public Manager(String name, double baseSalary, double kpiBonus) {
        super(name, baseSalary);
        this.kpiBonus = kpiBonus;
    }

    @Override
    public double getBonus() {
        return kpiBonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + getBonus(); // có thưởng
    }
}

