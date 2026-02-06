package BTTH;

public class CreditCard extends PaymentMethod implements Payable {
    private String cardNumber;   // 16 chữ số
    private String cvv;          // 3-4 chữ số
    private double creditLimit;  // hạn mức

    public CreditCard(String accountName, String paymentId,
                      String cardNumber, String cvv, double creditLimit) {
        super(accountName, paymentId);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.creditLimit = creditLimit;
    }

    @Override
    public void validate() {
        if (cardNumber == null || !cardNumber.matches("\\d{16}")) {
            throw new IllegalArgumentException("Số thẻ phải đủ 16 chữ số!");
        }
        if (cvv == null || !cvv.matches("\\d{3,4}")) {
            throw new IllegalArgumentException("CVV phải 3-4 chữ số!");
        }
        if (creditLimit < 0) {
            throw new IllegalArgumentException("Hạn mức không hợp lệ!");
        }
    }

    @Override
    public void pay(double amount) {
        try {
            validate();
        } catch (IllegalArgumentException e) {
            System.out.println("CreditCard: " + e.getMessage());
            return;
        }

        if (amount <= 0) {
            System.out.println("CreditCard: Số tiền phải > 0");
        } else if (amount > creditLimit) {
            System.out.println("CreditCard: Thanh toán thất bại (vượt hạn mức)!");
        } else {
            creditLimit -= amount;
            System.out.println("CreditCard: Thanh toán " + amount
                    + " | Chủ: " + accountName
                    + " | Hạn mức còn: " + creditLimit);
        }
    }
}

