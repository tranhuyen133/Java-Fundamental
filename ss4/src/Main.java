import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str1 = " Ngọc";
        String str2 = " Ngọc";
        System.out.println(str1 == str2); // true vì cùng literal trong String Pool

        String str3 = new String("Linh");
        String str4 = new String("Linh");
        System.out.println(str3 == str4);        // false (2 object khác nhau)
        System.out.println(str3.equals(str4));   // true (so sánh nội dung)

        System.out.println("A".compareTo("a"));  // so sánh theo mã Unicode

        System.out.println("hà Bích Ngọc".endsWith("Ngọc1")); // false

        String str = "Trần Thi Khánh Huyền tập trung vào";
        str = str.substring(0, 20);
        System.out.println(str);

        // split phải gán vào mảng
        String[] arrString = str.split(" ");
        for (int i = 0; i < arrString.length; i++) {
            System.out.println(arrString[i]);
        }

        char[] arrChar = str.toCharArray();
        System.out.println(Arrays.toString(arrChar));
    }
}
