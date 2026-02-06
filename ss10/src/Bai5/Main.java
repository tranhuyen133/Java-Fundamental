package Bai5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        list.add(new OfficeStaff("Nguyễn Văn A", 10_000_000));
        list.add(new Manager("Trần Thị B", 15_000_000, 3_000_000));
        list.add(new OfficeStaff("Lê Văn C", 9_000_000));

        System.out.println("BẢNG LƯƠNG NHÂN VIÊN");
        System.out.println("----------------------------------------");

        for (Employee e : list) {
            double salary = e.calculateSalary();

            // In rõ có thưởng hay không
            if (e instanceof BonusCalculator b) {
                System.out.printf("%s (Manager) - Base: %.0f - Bonus: %.0f - Total: %.0f%n",
                        e.getName(), e.getBaseSalary(), b.getBonus(), salary);
            } else {
                System.out.printf("%s (OfficeStaff) - Base: %.0f - Bonus: 0 - Total: %.0f%n",
                        e.getName(), e.getBaseSalary(), salary);
            }
        }
    }
}

