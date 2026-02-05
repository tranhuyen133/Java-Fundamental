package BTTH;

public class Rectangle extends Shape {
    private double width;
    private double height;

    // Constructor 1: hình chữ nhật
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Constructor 2 (Overloading): 1 tham số -> hình vuông
    public Rectangle(double side) {
        this.width = side;
        this.height = side;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public boolean isSquare() {
        return width == height;
    }
}
