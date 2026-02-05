package Bai5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new OfficeEmployee("Nguyen Van A", 10_000_000));
        employees.add(new ProductionEmployee("Tran Thi B", 300, 20_000));
        employees.add(new ProductionEmployee("Le Van C", 150, 30_000));

        System.out.println("Danh sách lương nhân viên:");

        long total = 0;
        int i = 1;

        for (Employee e : employees) {
            long salary = e.calculateSalary(); // gọi đúng theo kiểu thực tế (runtime)
            total += salary;

            System.out.printf(
                    "%d. %s (%s) - Lương: %s%s%n",
                    i,
                    e.getName(),
                    e.getType(),
                    FormatUtils.money(salary),
                    e.getSalaryDetail()
            );

            i++;
        }

        System.out.println();
        System.out.println("=> TỔNG LƯƠNG CÔNG TY: " + FormatUtils.money(total));
    }
}

