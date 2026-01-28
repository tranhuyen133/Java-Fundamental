import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Bai3 {
    public static void main(String[] args) {

        // 1) Danh sách giao dịch (Mã sách - Ngày mượn)
        String[] transactions = {"BK001-20/01", "BK005-21/01", "BK099-22/01"};

        // Lấy ngày hệ thống để in lên đầu báo cáo
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String today = LocalDate.now().format(fmt);

        // =======================
        // A) Dùng StringBuilder
        // =======================
        long startSB = System.nanoTime();

        StringBuilder sb = new StringBuilder();
        sb.append("--- BÁO CÁO MƯỢN SÁCH ---\n");
        sb.append("Ngày tạo: ").append(today).append("\n");

        for (int i = 0; i < transactions.length; i++) {
            sb.append("Giao dịch: ").append(transactions[i]).append("\n");
        }

        String reportSB = sb.toString();

        long endSB = System.nanoTime();
        long timeSB = endSB - startSB;

        // =======================
        // B) Dùng cộng chuỗi String (+)
        // =======================
        long startStr = System.nanoTime();

        String reportStr = "--- BÁO CÁO MƯỢN SÁCH ---\n";
        reportStr += "Ngày tạo: " + today + "\n";

        for (int i = 0; i < transactions.length; i++) {
            reportStr += "Giao dịch: " + transactions[i] + "\n";
        }

        long endStr = System.nanoTime();
        long timeStr = endStr - startStr;

        // =======================
        // In kết quả
        // =======================
        System.out.println(reportSB);

        System.out.println("Thời gian thực thi (StringBuilder) ns: " + timeSB);
        System.out.println("Thời gian thực thi (String +) ns: " + timeStr);
    }
}
