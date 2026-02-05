package BTTH;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        // Theo đề bài
        shapes.add(new Circle(5));        // r=5
        shapes.add(new Rectangle(3, 4));  // 3x4
        shapes.add(new Rectangle(6));     // vuông cạnh 6 (Rectangle 1 tham số)

        System.out.println("Kết quả tính toán hình học:\n");

        double total = 0;
        int i = 1;

        for (Shape s : shapes) {
            double area = s.calculateArea(); // Overriding -> runtime
            total += area;

            if (s instanceof Circle c) {
                System.out.printf("%d. Hình tròn (r=%.0f) - Diện tích: %.2f%n%n",
                        i, c.getRadius(), area);
            } else if (s instanceof Rectangle r) {
                if (r.isSquare()) {
                    System.out.printf("%d. Hình vuông (cạnh %.1f) - Diện tích: %.1f  <-- (Class Rectangle xử lý)%n%n",
                            i, r.getWidth(), area);
                } else {
                    System.out.printf("%d. Hình chữ nhật (%.1f x %.1f) - Diện tích: %.1f%n%n",
                            i, r.getWidth(), r.getHeight(), area);
                }
            }

            i++;
        }

        System.out.printf("=> Tổng diện tích các hình: %.2f%n", total);
    }
}
