import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập mô tả sách:");
        String desc = sc.nextLine();

        String key = "Kệ:";

        // 1) Kiểm tra có chứa "Kệ:" không
        if (!desc.contains(key)) {
            System.out.println("Không tìm thấy thông tin kệ trong mô tả.");
            System.out.println("Mô tả gốc: " + desc);
            return;
        }

        // 2) Tìm vị trí bắt đầu của "Kệ:"
        int posKey = desc.indexOf(key);

        // Vị trí bắt đầu của mã kệ (ngay sau "Kệ:")
        int start = posKey + key.length();

        // 3) Cắt từ sau "Kệ:" đến dấu phẩy tiếp theo, nếu không có dấu phẩy thì đến hết chuỗi
        int commaPos = desc.indexOf(",", start);

        String shelfCode;
        if (commaPos == -1) {
            // Không có dấu phẩy -> lấy đến hết dòng/chuỗi
            shelfCode = desc.substring(start).trim();
        } else {
            // Có dấu phẩy -> lấy đến trước dấu phẩy
            shelfCode = desc.substring(start, commaPos).trim();
        }

        // 4) Thay "Kệ:" thành "Vị trí lưu trữ:" (làm bằng substring để đúng tinh thần bài)
        String newDesc =
                desc.substring(0, posKey)
                        + "Vị trí lưu trữ:"
                        + desc.substring(posKey + key.length());

        // ===== In kết quả =====
        System.out.println("Mã vị trí kệ trích xuất: " + shelfCode);
        System.out.println("Mô tả mới: " + newDesc);
    }
}
