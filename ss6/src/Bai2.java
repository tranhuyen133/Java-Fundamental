public class Bai2 {

    // Định nghĩa class Account
    static class Account {
        // Thuộc tính private
        private String username;
        private String password;
        private String email;

        // Constructor khởi tạo thông tin
        public Account(String username, String password, String email) {
            this.username = username;
            this.password = password;
            this.email = email;
        }

        // Phương thức đổi mật khẩu
        public void changePassword(String newPassword) {
            if(newPassword != null && newPassword.length() >= 6) { // điều kiện đơn giản
                password = newPassword;
                System.out.println("Đổi mật khẩu thành công!");
            } else {
                System.out.println("Mật khẩu mới không hợp lệ (ít nhất 6 ký tự).");
            }
        }

        // Phương thức hiển thị thông tin tài khoản (ẩn mật khẩu)
        public void displayInfo() {
            System.out.println("-----------------------------");
            System.out.println("Username : " + username);
            System.out.println("Password : " + "*".repeat(password.length())); // ẩn mật khẩu
            System.out.println("Email    : " + email);
            System.out.println("-----------------------------");
        }

        // Getter và Setter nếu cần (ở đây không bắt buộc)
    }

    // Lớp Main kiểm thử
    public static void main(String[] args) {
        // Tạo 2 tài khoản
        Account acc1 = new Account("user01", "pass123", "user01@gmail.com");
        Account acc2 = new Account("user02", "abcdef", "user02@gmail.com");

        // Hiển thị thông tin trước khi đổi mật khẩu
        System.out.println("=== Thông tin tài khoản trước khi đổi mật khẩu ===");
        acc1.displayInfo();
        acc2.displayInfo();

        // Thực hiện đổi mật khẩu
        acc1.changePassword("newpass456"); // hợp lệ
        acc2.changePassword("123");        // không hợp lệ

        // Hiển thị thông tin sau khi đổi mật khẩu
        System.out.println("\n=== Thông tin tài khoản sau khi đổi mật khẩu ===");
        acc1.displayInfo();
        acc2.displayInfo();
    }
}
