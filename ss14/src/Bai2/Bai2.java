package Bai2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Map<String, String> drugMap = new HashMap<>();

        // Thêm sẵn 5 thuốc
        drugMap.put("T01", "Paracetamol");
        drugMap.put("T02", "Ibuprofen");
        drugMap.put("T03", "Amoxicillin");
        drugMap.put("T04", "Cetirizine");
        drugMap.put("T05", "Omeprazole");

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã thuốc: ");
        String code = sc.nextLine().trim().toUpperCase();

        if (drugMap.containsKey(code)) {
            System.out.println("Tên thuốc: " + drugMap.get(code));
        } else {
            System.out.println("Thuốc không có trong danh mục BHYT");
        }

        sc.close();
    }
}
