import java.util.Scanner;
import java.util.Stack;

public class DemoStack {


    public DemoStack() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Game xếp bài
        Stack<Integer> stack = new Stack<>();
        // phương thức:
        /**
         * push() - thêm
         * pop() - xoá
         * peek() - xem
         * */

        // đầu tiên có con K giá trị là 13
        stack.push(13);

        // mô phỏng nếu như người dùng thêm con Q = 12 thì hợp lệ
        // nếu thêm con J = 11 thì sẽ ko hợp lệ
        // --> phải thêm những con liên tiếp
//        System.out.println("Vui lòng nhập: ");
//        int element = sc.nextInt();
//
//        if (element == stack.peek() - 1) {
//            stack.push(element);
//        } else {
//            System.err.println("Thêm không hợp lệ");
//        }

        MyStack<String> bestStudent = new MyStack<>(5);
        bestStudent.push("Hà Bích Ngọc");
        bestStudent.push("Nguyễn Hữu Đại");
        bestStudent.push("Hồ Khánh Linh");
        bestStudent.push("Phạm Thái Sơn");
        bestStudent.push("Lê Thanh Tùng");
        System.out.println(bestStudent);

        bestStudent.push("Đỗ Hồng Kỳ");



    }
}