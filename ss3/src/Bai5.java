import java.util.Scanner;

public class Bai5 {

    // In mảng chỉ tới n phần tử
    public static void displayBooks(int[] arr, int n) {
        System.out.print("Kho sách hiện tại (" + n + " cuốn): [ ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) System.out.print(" ");
        }
        System.out.println(" ]");
    }

    // Xóa 1 bookId khỏi mảng bằng cách dồn trái, trả về n mới
    public static int deleteBook(int[] arr, int n, int bookId) {
        int pos = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == bookId) {
                pos = i;
                break;
            }
        }

        if (pos == -1) return n;

        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        return n - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] books = {101, 102, 103, 104, 105};
        int n = 5;

        while (n > 0) {
            displayBooks(books, n);

            System.out.print("Nhập mã sách cần xóa (0 để thoát): ");
            int bookId = Integer.parseInt(sc.nextLine());

            if (bookId == 0) break;

            int oldN = n;
            n = deleteBook(books, n, bookId);

            if (n < oldN) {
                System.out.println("Đã xóa sách mã " + bookId);
            } else {
                System.out.println("Không tìm thấy sách mã " + bookId);
            }

            System.out.println();
        }

        if (n == 0) {
            System.out.println("Kho sách đã rỗng.");
        }
    }
}
