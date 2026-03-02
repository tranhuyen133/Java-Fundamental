package Bai3;

import java.util.*;

public class Bai3 {
    public static void main(String[] args) {
        // Set A: thành phần thuốc mới
        Set<String> drugIngredients = new HashSet<>(Arrays.asList(
                "Aspirin", "Caffeine", "Paracetamol"
        ));

        // Set B: chất bệnh nhân bị dị ứng
        Set<String> allergies = new HashSet<>(Arrays.asList(
                "Penicillin", "Aspirin"
        ));

        // 1) GIAO: các chất trùng nhau => cảnh báo dị ứng
        Set<String> warning = new HashSet<>(drugIngredients); // copy A
        warning.retainAll(allergies);

        // 2) HIỆU: thành phần an toàn = A - B
        Set<String> safe = new HashSet<>(drugIngredients); // copy A
        safe.removeAll(allergies);

        System.out.println("Thuốc: " + drugIngredients);
        System.out.println("Dị ứng: " + allergies);

        if (warning.isEmpty()) {
            System.out.println("Cảnh báo dị ứng: [] (An toàn, không trùng chất dị ứng)");
        } else {
            System.out.println("Cảnh báo dị ứng: " + warning);
        }

        System.out.println("Thành phần an toàn: " + safe);
    }
}
