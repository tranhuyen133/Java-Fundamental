import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        //khởi tạo 1 biến chứa ten
        // đối tượng nào tỏng java cũng tuân theo quy tắc tên Pascal
        String name = "Hà Bích Ngọc";
        int age = 19;
        float core = 7.5F;
        double money = 100000.0;

        //đặt tên biến :
        // camelCase ngày sinh --> date of birth
        String dateOfBirth = " ";
        // snake_case: họ tên --> full name
        String full_name = "";
        // pascalCase

        // bài toán tuôi khi nhâp ngày sinh
        // wrapper class
        // cú pháp khai báo biến
        // <DataType> <VariableName> = <giá trị>
        int birthYear = 2006;
        int nowYear = 2026;
        int ageOfDuc = nowYear - birthYear;
        System.out.println(ageOfDuc);

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tuổi:");
        int myAge = Integer.parseInt(sc.nextLine());
        System.out.println(myAge);
        System.out.println("Nhập tên:");
        String myName = sc.nextLine();
        System.out.println(myName);

        // => giải quyết tình huống nuốt odfng java:
        /**
         * Cái nào khác chuỗi thì  => nhập chuỗi ép kiểu về số
         **/
        boolean result = Boolean.parseBoolean("true");
        System.out.println(result);

        /**
         * ===============================
         * |Ngọc | Đại | Linh | Sơn | Tùng|
         * ===============================
         */
        System.out.println("=========================================");
        System.out.println("| Ngọc   | Đại    | Linh   | Sơn    | Tùng |");
        System.out.println("=========================================");

        System.out.println("=========================================");
        System.out.println("| -10%   | -10%   | -10%   | -10%   | -10% |");
        System.out.println("| Ngọc   | Đại    | Linh   | Sơn    | Tùng |");
        System.out.println("=========================================");

        /**
         * 1.cách thức lưu trữ (vùng nhớ)
         * 2.kiểu dữ liệu
         * 3. biến
         * 4 toán tử
         * 5. nhập xuất
         */

    }
}
