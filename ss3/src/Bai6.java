public class Bai6 {

    public static void displayBooks(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(" ");
        }
        System.out.println(" ]");
    }

    // Gộp 2 mảng đã sort tăng dần, loại trùng, vẫn giữ tăng dần
    public static int[] mergeBooks(int[] a, int[] b) {
        int[] temp = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                temp[k++] = a[i++];
            } else if (a[i] > b[j]) {
                temp[k++] = b[j++];
            } else { // trùng nhau
                temp[k++] = a[i];
                i++;
                j++;
            }
        }

        while (i < a.length) temp[k++] = a[i++];
        while (j < b.length) temp[k++] = b[j++];

        // temp[0..k-1] đã tăng dần, có thể còn trùng do trùng trong cùng 1 mảng
        int[] uniqueTemp = new int[k];
        int u = 0;
        for (int idx = 0; idx < k; idx++) {
            if (u == 0 || temp[idx] != uniqueTemp[u - 1]) {
                uniqueTemp[u++] = temp[idx];
            }
        }

        int[] result = new int[u];
        for (int idx = 0; idx < u; idx++) result[idx] = uniqueTemp[idx];

        return result;
    }

    public static void main(String[] args) {
        int[] arrayFirst  = {101, 102, 105, 110, 120};
        int[] arraySecond = {100, 102, 103, 110, 130};

        System.out.print("Kho A: ");
        displayBooks(arrayFirst);

        System.out.print("Kho B: ");
        displayBooks(arraySecond);

        int[] merged = mergeBooks(arrayFirst, arraySecond);

        System.out.print("Danh sách sau khi gộp (không trùng, tăng dần): ");
        displayBooks(merged);
    }
}
