import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /**
         * Yêu cầu người dùng vào chơi công viên nước : giá mặc tđịnh :50000đ
         * <7 -->70%
         * 7-18 --> 50%
         * 18-60 --> 0%
         * 60 --> free
         * in ra giá trị
         */
        /**
         * Mục đích : tính giảm giá dựa vào tuổi
         * Yêu cầu nhâoj vào tuổi và so sánh tính giá tiền
         * Giải pháp : sử dụng if else if
         * Thực thi :
         *          b1: nhập tuổi
         *          b2:kiểm tra
         *          b3: ỉn ra
         */
        Scanner sc = new Scanner(System.in);
        double defaultPrice = 50000;
        System.out.println("Nhập vào số tuổi");
        int age = sc.nextInt();
        if (age < 7) {
            defaultPrice = defaultPrice - (defaultPrice - 0.7);
        } else if (age < 18) {
            defaultPrice = defaultPrice * 0.5;
        } else if (age < 60){
            defaultPrice = defaultPrice;
        } else {
            defaultPrice = 0;
    }
    System.out.printf("Bạn %d tuổi và giá vé :%f",age, defaultPrice);
    }
}