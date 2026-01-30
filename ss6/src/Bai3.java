public class Bai3 {

    // Định nghĩa class Product
    static class Product {
        // Thuộc tính private
        private String productId;
        private String productName;
        private double price;

        // Constructor có tham số
        public Product(String productId, String productName, double price) {
            this.productId = productId;
            this.productName = productName;
            setPrice(price); // dùng setter để kiểm tra giá
        }

        // Getter
        public String getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public double getPrice() {
            return price;
        }

        // Setter với kiểm tra dữ liệu
        public void setPrice(double price) {
            if(price > 0) {
                this.price = price;
            } else {
                System.out.println("Giá sản phẩm không hợp lệ. Không thay đổi giá.");
            }
        }

        // Phương thức hiển thị thông tin sản phẩm
        public void displayInfo() {
            System.out.println("------------------------------");
            System.out.println("Mã SP   : " + productId);
            System.out.println("Tên SP  : " + productName);
            System.out.printf("Giá bán : %.0f VNĐ\n", price);
            System.out.println("------------------------------");
        }
    }

    // Lớp Main kiểm thử
    public static void main(String[] args) {
        // Tạo sản phẩm hợp lệ
        Product p1 = new Product("P001", "Laptop Dell", 15000000);
        Product p2 = new Product("P002", "Điện thoại Samsung", 7000000);

        // Hiển thị thông tin
        System.out.println("=== Thông tin sản phẩm ban đầu ===");
        p1.displayInfo();
        p2.displayInfo();

        // Thử set giá không hợp lệ
        System.out.println("\n=== Thử đặt giá không hợp lệ ===");
        p1.setPrice(-5000000); // sẽ không thay đổi giá
        p1.displayInfo();

        // Thay đổi giá hợp lệ
        p2.setPrice(7500000);
        p2.displayInfo();
    }
}
