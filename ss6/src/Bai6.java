public class Bai6 {

    // Định nghĩa class User
    static class User {
        // Thuộc tính private
        private int id;
        private String username;
        private String password;
        private String email;

        // Constructor khởi tạo đầy đủ
        public User(int id, String username, String password, String email) {
            this.id = id;
            this.username = username;
            setPassword(password); // dùng setter để kiểm tra rỗng
            setEmail(email);       // dùng setter để kiểm tra hợp lệ
        }

        // Getter & Setter
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            if(password != null && !password.isEmpty()) {
                this.password = password;
            } else {
                System.out.println("Password không được để trống! Giữ nguyên giá trị cũ.");
            }
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            if(email != null && email.contains("@") && email.contains(".")) {
                this.email = email;
            } else {
                System.out.println("Email không hợp lệ! Giữ nguyên giá trị cũ.");
            }
        }

        // Phương thức hiển thị thông tin người dùng (ẩn password)
        public void displayInfo() {
            System.out.println("------------------------------");
            System.out.println("ID       : " + id);
            System.out.println("Username : " + username);
            System.out.println("Password : " + "*".repeat(password.length()));
            System.out.println("Email    : " + email);
            System.out.println("------------------------------");
        }
    }

    // Lớp Main kiểm thử
    public static void main(String[] args) {
        // Tạo các đối tượng User
        User u1 = new User(1, "user01", "pass123", "user01@gmail.com");
        User u2 = new User(2, "user02", "", "user02@gmail"); // password rỗng, email sai
        User u3 = new User(3, "user03", "abc123", "user03@example.com");

        // Hiển thị thông tin ban đầu
        System.out.println("=== Thông tin người dùng ban đầu ===");
        u1.displayInfo();
        u2.displayInfo();
        u3.displayInfo();

        // Thử cập nhật dữ liệu sai
        System.out.println("\n=== Thử cập nhật dữ liệu sai ===");
        u2.setPassword("");             // password rỗng
        u2.setEmail("invalid-email");   // email không hợp lệ
        u2.displayInfo();

        // Thay đổi dữ liệu hợp lệ
        u2.setPassword("newpass456");
        u2.setEmail("user02@domain.com");
        System.out.println("\n=== Thông tin người dùng sau khi sửa ===");
        u2.displayInfo();
    }
}
