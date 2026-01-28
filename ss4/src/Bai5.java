import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Regex có Capturing Groups
        // Ví dụ dòng log: 2024-05-20 | User: NguyenVanA | Action: BORROW | BookID: BK12345
        String regex = "^(\\d{4}-\\d{2}-\\d{2})\\s*\\|\\s*User:\\s*([A-Za-z0-9_]+)\\s*\\|\\s*Action:\\s*(BORROW|RETURN)\\s*\\|\\s*BookID:\\s*([A-Za-z0-9]+)\\s*$";
        Pattern pattern = Pattern.compile(regex);

        System.out.print("Nhập số dòng log: ");
        int n = Integer.parseInt(sc.nextLine());

        int countBorrow = 0;
        int countReturn = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Nhập log dòng " + i + ": ");
            String line = sc.nextLine();

            Matcher matcher = pattern.matcher(line);

            if (matcher.matches()) {
                // Lấy dữ liệu từ các group
                String date = matcher.group(1);
                String user = matcher.group(2);
                String action = matcher.group(3);
                String bookId = matcher.group(4);

                // Đếm BORROW/RETURN
                if (action.equals("BORROW")) countBorrow++;
                else if (action.equals("RETURN")) countReturn++;

                // In thông tin đã bóc tách
                System.out.println("  Ngày: " + date);
                System.out.println("  Người dùng: " + user);
                System.out.println("  Hành động: " + action);
                System.out.println("  Mã sách: " + bookId);
            } else {
                System.out.println("  Dòng log sai định dạng!");
            }

            System.out.println();
        }

        // Thống kê cuối cùng
        System.out.println("=== THỐNG KÊ ===");
        System.out.println("BORROW: " + countBorrow);
        System.out.println("RETURN: " + countReturn);
    }
}
