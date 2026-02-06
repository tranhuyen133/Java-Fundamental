package Bai6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Iphone", 2000));
        products.add(new Product("Samsung", 1500));
        products.add(new Product("AirPods", 300));
        products.add(new Product("Macbook", 2500));

        // 1) Anonymous Class: sắp xếp theo giá tăng dần
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });

        System.out.println("== Sắp xếp theo giá tăng dần (Anonymous Class) ==");
        for (Product p : products) {
            System.out.println(p);
        }

        // 2) Lambda: sắp xếp theo tên A-Z
        products.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));

        System.out.println("\n== Sắp xếp theo tên A-Z (Lambda) ==");
        for (Product p : products) {
            System.out.println(p);
        }

        /*
          Khi nào bắt buộc/ưu tiên dùng Anonymous Class thay vì Lambda?
          - Khi cần thêm "trạng thái/thuộc tính nội bộ" hoặc nhiều method phụ.
            Ví dụ: cần đếm số lần compare, lưu cấu hình sort, cache dữ liệu...
          - Lambda chỉ phù hợp với Functional Interface (1 abstract method) và không khai báo field riêng được.
         */
    }
}

