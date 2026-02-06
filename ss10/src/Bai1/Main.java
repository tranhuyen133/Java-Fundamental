package Bai1;

public class Main {
    public static void main(String[] args) {
        Shape c = new Circle(5);
        Shape r = new Rectangle(3, 4);

        System.out.printf("Hình tròn (r=5)%n");
        System.out.printf("Diện tích: %.2f%n", c.getArea());
        System.out.printf("Chu vi: %.2f%n%n", c.getPerimeter());

        System.out.printf("Hình chữ nhật (3 x 4)%n");
        System.out.printf("Diện tích: %.2f%n", r.getArea());
        System.out.printf("Chu vi: %.2f%n", r.getPerimeter());
    }
}


