package Bai1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bai1 {
    public static void main(String[] args) {
        List<Double> temps = new ArrayList<>();
        temps.add(36.5);
        temps.add(40.2);
        temps.add(37.0);
        temps.add(12.5);
        temps.add(39.8);
        temps.add(99.9);
        temps.add(36.8);

        System.out.println("Danh sách ban đầu: " + temps);

        // Lọc bằng Iterator (hợp lệ: 34.0 đến 42.0)
        Iterator<Double> it = temps.iterator();
        while (it.hasNext()) {
            double t = it.next();
            if (t < 34.0 || t > 42.0) {
                it.remove(); // xóa an toàn khi đang duyệt
            }
        }

        System.out.println("Danh sách sau khi lọc: " + temps);

        // Tính trung bình
        double sum = 0;
        for (double t : temps) {
            sum += t;
        }

        double avg = sum / temps.size();
        System.out.printf("Nhiệt độ trung bình: %.2f\n", avg);
    }
}