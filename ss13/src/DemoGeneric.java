public class DemoGeneric {

    public static void main(String[] args) {
        MyArrayList<Integer> numbers = new MyArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(4);
        numbers.add(2);
        numbers.add(5);
//        for (int i = 0; i < numbers.size(); i++) {
//            System.out.println(numbers.get(i));
//        }
        System.out.println(numbers);

        MyArrayList<String> fullName = new MyArrayList<>();
        fullName.add("Hà Bích Ngọc");
        fullName.add("PHạm Thái Sơn");
        System.out.println(fullName);
    }

}