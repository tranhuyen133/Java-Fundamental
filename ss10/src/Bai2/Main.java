package Bai2;

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Car("Toyota");
        Vehicle v2 = new Bicycle("Giant");

        v1.move();
        v2.move();
    }
}

