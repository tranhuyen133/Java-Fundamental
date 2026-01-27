public class Bai4 {

    // In mảng, mỗi phần tử cách nhau dấu phẩy
    public static void displayBooks(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    // Bubble Sort (sắp xếp nổi bọt) tăng dần
    public static void sortBooks(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] books = {987654, 123456, 456789, 654321, 98765};

        System.out.print("Mảng trước khi sắp xếp: ");
        displayBooks(books);

        sortBooks(books);

        System.out.print("Mảng sau khi sắp xếp: ");
        displayBooks(books);
    }
}
