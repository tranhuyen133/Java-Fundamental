public class Main {
    public static void main(String[] args) {
        // Khởi tạo 2 tài khoản
        BaiThucHanh acc1 = new BaiThucHanh("0987654321", "Tran Khanh Huyen", 100_000_000);
        BaiThucHanh acc2 = new BaiThucHanh("0123456789", "Nguyễn Văn A", 50_000_000);

        // In thông tin trước khi giao dịch
        System.out.println("=== Thông tin tài khoản trước giao dịch ===");
        acc1.display();
        acc2.display();

        // Thực hiện giao dịch
        acc1.deposit(20_000_000);   // Nạp tiền
        acc1.withdraw(50_000_000);  // Rút tiền

        acc2.withdraw(60_000_000);  // Rút vượt số dư -> thông báo lỗi
        acc2.deposit(10_000_000);   // Nạp tiền

        // In thông tin sau giao dịch
        System.out.println("\n=== Thông tin tài khoản sau giao dịch ===");
        acc1.display();
        acc2.display();
    }
}
