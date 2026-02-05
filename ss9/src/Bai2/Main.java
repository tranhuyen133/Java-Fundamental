package Bai2;

public class Main {
    public static void main(String[] args) {

        Animal a1 = new Dog(); // kiểu khai báo Animal, đối tượng thật Dog
        Animal a2 = new Cat(); // kiểu khai báo Animal, đối tượng thật Cat
        Animal a3 = new Animal();

        a1.sound(); // gọi Dog.sound()
        a2.sound(); // gọi Cat.sound()
        a3.sound(); // gọi Animal.sound()

        // Có thể tạo trực tiếp cũng được:
        Dog d = new Dog();
        Cat c = new Cat();
        d.sound();
        c.sound();
    }
}
