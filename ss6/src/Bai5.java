public class Bai5 {

    // Định nghĩa class Book
    static class Book {
        private String title;
        private String author;
        private double price;

        // Constructor với tham số trùng tên với thuộc tính
        public Book(String title, String author, double price) {
            // Sử dụng 'this' để phân biệt thuộc tính instance và tham số
            this.title = title;
            this.author = author;
            this.price = price;
        }

        // Phương thức hiển thị thông tin sách
        public void displayInfo() {
            System.out.println("------------------------------");
            System.out.println("Tiêu đề  : " + this.title);
            System.out.println("Tác giả  : " + this.author);
            System.out.printf("Giá bán  : %.0f VNĐ\n", this.price);
            System.out.println("------------------------------");
        }
    }

    // Lớp Main kiểm thử
    public static void main(String[] args) {
        // Tạo đối tượng sách
        Book b1 = new Book("Java cơ bản", "Nguyễn Văn A", 500000);
        Book b2 = new Book("Python nâng cao", "Trần Thị B", 650000);

        // Hiển thị thông tin sách
        System.out.println("=== Danh sách sách ===");
        b1.displayInfo();
        b2.displayInfo();
    }
}
