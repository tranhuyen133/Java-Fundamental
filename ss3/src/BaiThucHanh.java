import java.util.Scanner;

public class BaiThucHanh {

    static final int MAX = 100;

    static int[] ids = new int[MAX];
    static String[] titles = new String[MAX];
    static int[] quantities = new int[MAX];
    static int n = 0;

    static Scanner sc = new Scanner(System.in);

    // ===== Helpers =====
    static int findIndexById(int bookId) {
        for (int i = 0; i < n; i++) {
            if (ids[i] == bookId) return i;
        }
        return -1;
    }

    static void printTableHeader() {
        System.out.println("\nMã\t|\tTên\t\t\t|\tSố lượng");
        System.out.println("--------------------------------------------------------");
    }

    static void viewList() {
        if (n == 0) {
            System.out.println("\nDanh sách rỗng.");
            return;
        }
        printTableHeader();
        for (int i = 0; i < n; i++) {
            System.out.println(ids[i] + "\t|\t" + titles[i] + "\t\t\t|\t" + quantities[i]);
        }
    }

    static void addBook() {
        if (n >= MAX) {
            System.out.println("\nMảng đầy, không thể thêm.");
            return;
        }

        System.out.print("\nNhập mã sách: ");
        int id = Integer.parseInt(sc.nextLine());

        if (findIndexById(id) != -1) {
            System.out.println("Mã sách đã tồn tại. Thêm thất bại.");
            return;
        }

        System.out.print("Nhập tên sách: ");
        String title = sc.nextLine();

        System.out.print("Nhập số lượng: ");
        int qty = Integer.parseInt(sc.nextLine());

        if (qty < 0) {
            System.out.println("Số lượng không hợp lệ.");
            return;
        }

        ids[n] = id;
        titles[n] = title;
        quantities[n] = qty;
        n++;

        System.out.println("Đã thêm sách mới.");
    }

    static void updateQuantity() {
        if (n == 0) {
            System.out.println("\nKho rỗng.");
            return;
        }

        System.out.print("\nNhập mã sách cần cập nhật: ");
        int id = Integer.parseInt(sc.nextLine());

        int pos = findIndexById(id);
        if (pos == -1) {
            System.out.println("Không tìm thấy mã sách.");
            return;
        }

        System.out.println("Sách: " + titles[pos] + " | Số lượng hiện tại: " + quantities[pos]);
        System.out.print("Nhập số lượng mới: ");
        int newQty = Integer.parseInt(sc.nextLine());

        if (newQty < 0) {
            System.out.println("Số lượng không hợp lệ.");
            return;
        }

        quantities[pos] = newQty;
        System.out.println("Cập nhật thành công.");
    }

    static void deleteBook() {
        if (n == 0) {
            System.out.println("\nKho rỗng.");
            return;
        }

        System.out.print("\nNhập mã sách cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());

        int pos = findIndexById(id);
        if (pos == -1) {
            System.out.println("Không tìm thấy mã sách.");
            return;
        }

        for (int i = pos; i < n - 1; i++) {
            ids[i] = ids[i + 1];
            titles[i] = titles[i + 1];
            quantities[i] = quantities[i + 1];
        }
        n--;

        System.out.println("Đã xóa sách mã " + id);
    }

    static void searchBooks() {
        if (n == 0) {
            System.out.println("\nKho rỗng.");
            return;
        }

        System.out.print("\nNhập từ khóa cần tìm: ");
        String key = sc.nextLine().toLowerCase();

        boolean found = false;
        printTableHeader();
        for (int i = 0; i < n; i++) {
            if (titles[i].toLowerCase().contains(key)) {
                System.out.println(ids[i] + "\t|\t" + titles[i] + "\t\t\t|\t" + quantities[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có sách nào phù hợp từ khóa.");
        }
    }

    static void sortByQuantityDesc() {
        if (n <= 1) {
            System.out.println("\nKhông cần sắp xếp.");
            return;
        }

        // Bubble sort giảm dần theo quantities, đổi chỗ đồng bộ 3 mảng
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (quantities[j] < quantities[j + 1]) {
                    // swap quantities
                    int tq = quantities[j];
                    quantities[j] = quantities[j + 1];
                    quantities[j + 1] = tq;

                    // swap ids
                    int tid = ids[j];
                    ids[j] = ids[j + 1];
                    ids[j + 1] = tid;

                    // swap titles
                    String tt = titles[j];
                    titles[j] = titles[j + 1];
                    titles[j + 1] = tt;
                }
            }
        }

        System.out.println("Đã sắp xếp giảm dần theo số lượng.");
    }

    static void menu() {
        System.out.println("\n========= QUẢN LÝ THƯ VIỆN =========");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm sách mới");
        System.out.println("3. Cập nhật số lượng");
        System.out.println("4. Xóa sách");
        System.out.println("5. Tìm kiếm (theo từ khóa)");
        System.out.println("6. Sắp xếp theo số lượng (giảm dần)");
        System.out.println("0. Thoát");
        System.out.print("Chọn: ");
    }

    public static void main(String[] args) {

        while (true) {
            menu();
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 0) {
                System.out.println("Thoát chương trình.");
                break;
            }

            switch (choice) {
                case 1:
                    viewList();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    updateQuantity();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    searchBooks();
                    break;
                case 6:
                    sortByQuantityDesc();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }
    }
}
