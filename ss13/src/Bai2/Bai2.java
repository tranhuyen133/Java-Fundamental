package Bai2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bai2 {

    // Tạo danh sách thuốc không trùng + sắp xếp A-Z
    public static List<String> uniqueAndSortDrugs(List<String> input) {
        List<String> unique = new ArrayList<>();

        // lọc trùng (dùng contains)
        for (String drug : input) {
            if (!unique.contains(drug)) {
                unique.add(drug);
            }
        }

        // sắp xếp A-Z
        Collections.sort(unique);
        return unique;
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("Paracetamol");
        input.add("Ibuprofen");
        input.add("Panadol");
        input.add("Paracetamol");
        input.add("Aspirin");
        input.add("Ibuprofen");

        System.out.println("Input: " + input);

        List<String> output = uniqueAndSortDrugs(input);
        System.out.println("Output: " + output);
    }
}
