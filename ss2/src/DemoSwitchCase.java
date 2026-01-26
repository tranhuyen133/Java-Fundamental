import java.util.Scanner;

public class DemoSwitchCase {
    public static void main(String[] args) {
       /** sử dụng tính tiền xe tùưng loại
            căng hải :free,
            xe đạp 5000
            xe máy 10000,
            xe oto 50000,
            khong phải xe phương tiện -> thong báo lỗi
        * Mục đích :
        *       phân loại xe với tính tiền gửi xe
        * Yêu cầu
        *       nhập loại phương tiện
        *       kiểm tra tính tiền gủi xe
        *       in ra số tiền phải trả
        *Giải pháp
        *       Switch Case / if case
        * Thực thi :
        *       b1: nhâp loại phương tiện
        *       b2: sử dụng switch case sseer phân loại
        *       b3: in ra cái giá phải trả
        */
       Scanner sc = new Scanner (System.in);

       System.out.println("Nhập loại xe");
       String vehicle = sc.nextLine();
       int price = 0;
       switch(vehicle){
           case "căng hải":
               price = 0;
               break;
           case "xe đạp":
               price = 5000;
               break;
           case "xe máy":
               price = 10000;
               break;
           case "ô tô":
               price = 50000;
               break;
           default:
               System.out.println("Phương tiện không thể gửi ");

       }

    }
}
