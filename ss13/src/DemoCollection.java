import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DemoCollection {
    public static void main(String[] args) {
//        ARRAYLIST
        List<Integer> numbers = new ArrayList<>();
        // thêm
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println("Sau khi thêm");
        System.out.println(numbers);
        // xoá
        numbers.remove(1);
        System.out.println("Sau khi xoá");
        System.out.println(numbers);
        // cập nhật
        numbers.set(1, 2);
        System.out.println("Sau khi cập nhật");
        System.out.println(numbers);

//        LINKEDLIST
        List<String> fullName = new LinkedList<>();
        ((LinkedList<String>) fullName).addLast("Bùi Văn Phương");
        ((LinkedList<String>) fullName).addFirst("Nguyễn Thanh Tùng");
        System.out.println(fullName);

//        danh sách động vật yêu thích theo cân
        List<Animal> myFood = new ArrayList<>();
        Animal fish = new Animal("Cá", "Cá vàng", true);
        myFood.add(fish);
        Animal gozila = new Animal("Vượn","Vượn đít đỏ",false);
        myFood.add(gozila);

        for (int i = 0; i < myFood.size(); i++) {
            System.out.println(myFood.get(i));
        }

        for (Animal e : myFood) {
            System.out.println(e);
        }

    }
}