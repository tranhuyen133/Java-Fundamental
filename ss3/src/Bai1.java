import java.util.Scanner;

public class Bai1 {
    // Cho phép nhập n mã sách và trả về mảng int
    public static int[] addBookToLibraries(int n) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[n];

        System.out.println("Nhập mã số cho " + n + " cuốn sách:");
        for (int i = 0; i < n; i++) {
            System.out.print("Sách thứ " + (i + 1) + ": ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        return arr;
    }

    // In danh sách mã sách, mỗi mã cách nhau dấu phẩy
    public static void displayLibraries(int[] arr) {
        System.out.println("\n--- KẾT QUẢ ---");
        System.out.print("Danh sách mã sách: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng sách cần quản lý: ");
        int n = Integer.parseInt(sc.nextLine());

        int[] books = addBookToLibraries(n);
        displayLibraries(books);
    }
}
