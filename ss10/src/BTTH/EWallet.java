package BTTH;

public class EWallet extends PaymentMethod implements Payable {
    private String phoneNumber;
    private double balance;

    public EWallet(String accountName, String paymentId,
                   String phoneNumber, double balance) {
        super(accountName, paymentId);
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    @Override
    public void validate() {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10,11}")) {
            throw new IllegalArgumentException("SĐT phải 10-11 chữ số!");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Số dư không hợp lệ!");
        }
    }

    @Override
    public void pay(double amount) {
        try {
            validate();
        } catch (IllegalArgumentException e) {
            System.out.println("EWallet: " + e.getMessage());
            return;
        }

        if (amount <= 0) {
            System.out.println("EWallet: Số tiền phải > 0");
        } else if (amount > balance) {
            System.out.println("EWallet: Thanh toán thất bại (không đủ số dư)!");
        } else {
            balance -= amount;
            System.out.println("EWallet: Thanh toán " + amount
                    + " | Ví: " + phoneNumber
                    + " | Số dư còn: " + balance);
        }
    }
}
