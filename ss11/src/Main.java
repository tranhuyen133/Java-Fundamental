public class Main {
    public static void main(String[] args) {

        Drink[] drinks = new Drink[3];

        // Khởi tạo dữ liệu
        drinks[0] = new Coffee("CF01", "Bạc sỉu", 30000, true);
        drinks[1] = new FruitJuice("FJ01", "Nước cam", 40000, 10);
        drinks[2] = null;

        for (Drink d : drinks) {
            if (d != null) {
                System.out.println("===== HÓA ĐƠN =====");

                d.displayInfo();

                System.out.println("Thành tiền: " + d.calculatePrice());

                if (d instanceof IMixable) {
                    ((IMixable) d).mix();
                }

                System.out.println("-------------------");
            }
        }
    }
}