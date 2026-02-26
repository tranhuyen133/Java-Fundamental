package Bai3;

import java.util.ArrayList;
import java.util.List;

public class Bai3 {

    // Generic method: tìm phần tử xuất hiện ở cả 2 danh sách
    public static <T> List<T> findCommonPatients(List<T> a, List<T> b) {
        List<T> common = new ArrayList<>();

        for (T x : a) {
            if (b.contains(x) && !common.contains(x)) { // tránh trùng trong kết quả
                common.add(x);
            }
        }
        return common;
    }

    public static void main(String[] args) {
        // Test case 1: Integer
        List<Integer> a1 = new ArrayList<>();
        a1.add(101); a1.add(102); a1.add(105);

        List<Integer> b1 = new ArrayList<>();
        b1.add(102); b1.add(105); b1.add(108);

        System.out.println("Test Case 1 Output: " + findCommonPatients(a1, b1));

        // Test case 2: String
        List<String> a2 = new ArrayList<>();
        a2.add("DN01"); a2.add("DN02"); a2.add("DN03");

        List<String> b2 = new ArrayList<>();
        b2.add("DN02"); b2.add("DN04");

        System.out.println("Test Case 2 Output: " + findCommonPatients(a2, b2));
    }
}