package BTTH;

public class Main {
    public static void main(String[] args) {

        // Khởi tạo đối tượng
        Payable p1 = new CreditCard("Nguyen Van A", "CC01",
                "1234567812345678", "123", 10_000_000);

        Payable p2 = new EWallet("Tran Thi B", "EW01",
                "0987654321", 2_000_000);

        System.out.println("== Thanh toán thông thường ==");
        p1.pay(1_500_000);
        p2.pay(500_000);

        System.out.println("\n== Anonymous Class: Reward Points ==");
        Payable reward = new Payable() {
            private double points = 1000; // demo điểm

            @Override
            public void pay(double amount) {
                if (amount <= 0) {
                    System.out.println("Reward: Số tiền phải > 0");
                    return;
                }

                // Quy đổi: 1,000đ = 1 điểm
                double need = amount / 1000.0;

                if (need > points) {
                    System.out.println("Reward: Thanh toán thất bại (không đủ điểm)!");
                } else {
                    points -= need;
                    System.out.println("Reward: Thanh toán " + amount
                            + " (trừ " + need + " điểm)"
                            + " | Điểm còn: " + points);
                }
            }
        };

        reward.pay(300_000);
    }
}

