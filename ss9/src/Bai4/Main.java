package Bai4;

public class Main {
    public static void main(String[] args) {

        // Declared Type: Animal
        // Actual Type: Dog
        Animal animal = new Dog();

        // Gọi phương thức chung (có ở Animal) -> OK
        animal.sound(); // runtime gọi Dog.sound() vì overriding

        // animal.fetch(); // ❌ Lỗi biên dịch (compile-time)
        // Vì kiểu khai báo Animal không có method fetch()

        // Downcasting an toàn bằng instanceof
        if (animal instanceof Dog) {
            Dog d = (Dog) animal; // ép kiểu từ Animal -> Dog
            d.fetch();            // ✅ gọi được phương thức riêng
        }

        // Ví dụ tránh lỗi runtime:
        Animal a2 = new Animal();
        if (a2 instanceof Dog) {
            Dog d2 = (Dog) a2;
            d2.fetch();
        } else {
            System.out.println("a2 không phải Dog nên không thể ép kiểu!");
        }
    }
}
