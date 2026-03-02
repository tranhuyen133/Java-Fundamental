package Bai5;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Patient {
    private String name;
    private int severity;      // 1-Nguy kịch, 2-Nặng, 3-Nhẹ
    private int arrivalMinutes; // thời gian đến tính theo phút (ví dụ 8:05 -> 485)

    public Patient(String name, int severity, String arrivalTime) {
        this.name = name;
        this.severity = severity;
        this.arrivalMinutes = toMinutes(arrivalTime);
    }

    private int toMinutes(String time) {
        // time dạng "H:MM" hoặc "HH:MM"
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }

    public String getName() { return name; }
    public int getSeverity() { return severity; }
    public int getArrivalMinutes() { return arrivalMinutes; }

    public String severityText() {
        return switch (severity) {
            case 1 -> "Nguy kịch";
            case 2 -> "Nặng";
            default -> "Nhẹ";
        };
    }

    public String arrivalText() {
        int h = arrivalMinutes / 60;
        int m = arrivalMinutes % 60;
        return String.format("%d:%02d", h, m);
    }

    @Override
    public String toString() {
        return name + " (Mức " + severity + " - " + severityText() + ", đến lúc " + arrivalText() + ")";
    }
}

public class Bai5 {
    public static void main(String[] args) {

        Comparator<Patient> triageComparator = (a, b) -> {
            // 1) severity nhỏ hơn ưu tiên trước
            int c1 = Integer.compare(a.getSeverity(), b.getSeverity());
            if (c1 != 0) return c1;

            // 2) nếu severity bằng nhau, đến sớm hơn ưu tiên trước
            int c2 = Integer.compare(a.getArrivalMinutes(), b.getArrivalMinutes());
            if (c2 != 0) return c2;

            // 3) bắt buộc thêm tiêu chí phụ để TreeSet không “nuốt” phần tử khi coi là trùng
            return a.getName().compareToIgnoreCase(b.getName());
        };

        Set<Patient> triageQueue = new TreeSet<>(triageComparator);

        // Input theo đề
        triageQueue.add(new Patient("Bệnh nhân A", 3, "8:00"));
        triageQueue.add(new Patient("Bệnh nhân B", 1, "8:15"));
        triageQueue.add(new Patient("Bệnh nhân C", 1, "8:05"));

        System.out.println("Output (Thứ tự xử lý):");
        for (Patient p : triageQueue) {
            System.out.println(p);
        }
    }
}
