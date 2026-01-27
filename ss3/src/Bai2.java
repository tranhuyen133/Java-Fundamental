import java.util.Scanner;

public class Bai2 {

    // Tìm kiếm tuyến tính: trả về index nếu thấy, -1 nếu không thấy
    public static int searchBooks(String[] arr, String search) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase(search)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] books = {
                "Doraemon",
                "Conan",
                "Harry Potter",
                "Toan 12",
                "Tuoi Tre Dang Gia Bao Nhieu"
        };

        System.out.print("Nhập tên sách cần tìm: ");
        String search = sc.nextLine();

        int pos = searchBooks(books, search);

        if (pos != -1) {
            System.out.println("Tìm thấy sách '" + search + "' tại vị trí số: " + pos);
        } else {
            System.out.println("Sách không tồn tại trong thư viện.");
        }
    }
}
