package Bai4;

import java.util.*;

public class Bai4 {
    public static void main(String[] args) {
        List<String> cases = Arrays.asList(
                "Cúm A", "Sốt xuất huyết", "Cúm A",
                "Covid-19", "Cúm A", "Sốt xuất huyết"
        );

        // TreeMap tự sắp xếp key theo alphabet
        Map<String, Integer> countMap = new TreeMap<>();

        for (String disease : cases) {
            if (countMap.containsKey(disease)) {
                countMap.put(disease, countMap.get(disease) + 1);
            } else {
                countMap.put(disease, 1);
            }
        }

        // In kết quả
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " ca");
        }
    }
}
