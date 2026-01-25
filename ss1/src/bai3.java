public class bai3 {
    public static void main(String[] args) {

        // 1) Khai báo 2 biến String
        String book1 = "Java Basic";
        String book2 = "Python Intro";

        System.out.println("Trước khi hoán đổi: Book1 = " + book1 + ", Book2 = " + book2);

        // 2) Hoán đổi bằng biến tạm
        String temp = book1;
        book1 = book2;
        book2 = temp;

        System.out.println("Sau khi hoán đổi:  Book1 = " + book1 + ", Book2 = " + book2);

        /*
         * 3) Giải thích Stack/Heap (tham chiếu)
         *
         * - Trong Java, biến book1, book2, temp là biến tham chiếu (reference) nằm trên STACK.
         *   Chúng không "chứa" nội dung chuỗi trực tiếp, mà chứa "địa chỉ/tham chiếu" trỏ tới đối tượng String.
         *
         * - Các đối tượng String (ví dụ: "Java Basic", "Python Intro") nằm trên HEAP (hoặc String Pool).
         *
         * Minh họa trước khi hoán đổi:
         *   STACK:
         *     book1  --->  "Java Basic"
         *     book2  --->  "Python Intro"
         *     temp   (chưa dùng)
         *
         * Khi gán: temp = book1;
         *   STACK:
         *     temp   --->  "Java Basic"   (temp trỏ cùng vùng nhớ chuỗi với book1)
         *
         * Khi gán: book1 = book2;
         *   STACK:
         *     book1  --->  "Python Intro" (book1 đổi tham chiếu sang đối tượng book2 đang trỏ)
         *
         * Khi gán: book2 = temp;
         *   STACK:
         *     book2  --->  "Java Basic"   (book2 đổi tham chiếu sang đối tượng temp đang trỏ)
         *
         * Lưu ý quan trọng:
         * - Không có đối tượng String nào bị sửa nội dung (String là immutable).
         * - HEAP (đối tượng chuỗi) không thay đổi nội dung; chỉ có các biến tham chiếu trên STACK đổi "hướng trỏ".
         * - Đối tượng String nào không còn biến nào trỏ tới thì sẽ trở thành "rác" và có thể bị GC thu hồi.
         */
    }
}
