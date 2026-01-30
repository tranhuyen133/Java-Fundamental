// Bước 1: Định nghĩa Class BankAccount
public class BaiThucHanh {
    // Thuộc tính private
    private String accountNumber;
    private String ownerName;
    private double balance;

    // Constructor không tham số (mặc định)
    public BaiThucHanh() {  // tên constructor phải trùng class
        this.accountNumber = "0000000000";
        this.ownerName = "Unknown";
        this.balance = 0.0;
    }

    // Constructor có tham số
    public BaiThucHanh(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if(balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
            System.out.println("Số dư không hợp lệ, đặt mặc định = 0");
        }
    }

    // Getter và Setter
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Số dư không thể âm!");
        }
    }

    // Phương thức nạp tiền
    public void deposit(double money) {
        if(money > 0) {
            balance += money;
            System.out.println("Nạp thành công: " + money + " VNĐ");
        } else {
            System.out.println("Số tiền nạp không hợp lệ!");
        }
    }

    // Phương thức rút tiền
    public void withdraw(double money) {
        if(money <= 0) {
            System.out.println("Số tiền rút không hợp lệ!");
        } else if(balance - money < 0) {
            System.out.println("Số dư không đủ để rút!");
        } else {
            balance -= money;
            System.out.println("Rút thành công: " + money + " VNĐ");
        }
    }

    // Phương thức hiển thị thông tin
    public void display() {
        System.out.println("-----------------------------------");
        System.out.println("Số TK: " + accountNumber);
        System.out.println("Name: " + ownerName);
        System.out.printf("Balance: %.0f VNĐ\n", balance);
        System.out.println("-----------------------------------");
    }
}
