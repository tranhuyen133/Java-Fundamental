package Bai1;

import java.util.*;

public class Bai1 {
    public static void main(String[] args) {
        List<String> input = Arrays.asList(
                "Nguyễn Văn A – Yên Bái",
                "Trần Thị B – Thái Bình",
                "Nguyễn Văn A – Yên Bái",
                "Lê Văn C – Hưng Yên"
        );

        // Giữ thứ tự + không trùng
        Set<String> waitingSet = new LinkedHashSet<>(input);

        System.out.println("Danh sách gọi khám:");
        int i = 1;
        for (String name : waitingSet) {
            System.out.println(i++ + ". " + name);
        }
    }
}