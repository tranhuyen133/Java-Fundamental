package Bai4;

public class Dog extends Animal {

    @Override
    public void sound() {
        System.out.println("Gâu gâu!");
    }

    // Phương thức riêng của Dog
    public void fetch() {
        System.out.println("Chó đang nhặt bóng!");
    }
}
