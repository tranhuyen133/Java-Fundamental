import java.util.*;

public class DemoQueue {
    public static void main(String[] args) {
        Queue<String> ngocByLife = new PriorityQueue<>();
        // phương thức:
        /**
         * 1. thêm:
         *      - add() - thêm nhưng ko an toàn khi mà nó đầy
         *      - offer() - an toàn hơn
         * 2. xoá
         *      - remove() - không an toàn
         *      - poll() - an toàn hơn
         * 3. xem
         *      - element()
         *      - peek()
         * 4. kiểm tra
         *      - isEmpty()
         * */

//        ngocByLife.offer("Nguyễn Văn A");
//        ngocByLife.offer("Trần Thị B");
//
//        System.out.println(ngocByLife);
//        ngocByLife.poll();
//        System.out.println(ngocByLife);
//
//        System.out.println("Love = " + ngocByLife.peek());

//        Queue<BestStudent> queue = new PriorityQueue<>();
//        queue.offer(new BestStudent("Nguyễn Văn A",5));
//        queue.offer(new BestStudent("Trần Thị B",2));
//        queue.offer(new BestStudent("Mai Xuân C",3));
//        queue.offer(new BestStudent("Hoàng Trung D",1));
//        for (BestStudent s : queue) {
//            System.out.println(s);
//        }

        // Deque -> ArrayDeque

        Deque<String> deque = new ArrayDeque<>();
        /**
         * phương thức:
         * 1. thêm:
         *      - push
         * 2. xoá:
         *      - pop
         * 3. xem:
         *      - peek
         * */
        // bởi vì triển khai giống linkedList
        deque.addFirst("A");
        deque.addLast("B");
        deque.removeLast();
        deque.removeFirst();
    }
}