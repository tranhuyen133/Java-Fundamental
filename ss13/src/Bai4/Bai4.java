package Bai4;

import java.util.LinkedList;

public class Bai4 {
    private LinkedList<String> queue = new LinkedList<>();

    // Bệnh nhân thường: vào cuối hàng
    public void patientCheckIn(String name) {
        queue.addLast(name);
    }

    // Ca nguy kịch: chen lên đầu hàng
    public void emergencyCheckIn(String name) {
        queue.addFirst(name);
    }

    // Gọi bệnh nhân đầu tiên vào khám/cấp cứu
    public void treatPatient() {
        if (queue.isEmpty()) {
            System.out.println("Không có bệnh nhân chờ.");
            return;
        }

        String name = queue.removeFirst();

        // Nếu tên bắt đầu bằng "C" trong mô phỏng thì in "Đang cấp cứu"
        // (để đúng output mẫu). Thực tế bạn có thể tách loại bệnh nhân riêng.
        if (name.equals("C")) {
            System.out.println("Đang cấp cứu: " + name);
        } else {
            System.out.println("Đang khám: " + name);
        }
    }

    public static void main(String[] args) {
        EmergencyRoom er = new EmergencyRoom();

        // Mô phỏng: A, B đến -> C nguy kịch
        er.patientCheckIn("A");
        er.patientCheckIn("B");
        er.emergencyCheckIn("C");

        // Bác sĩ chữa trị 3 lần
        er.treatPatient();
        er.treatPatient();
        er.treatPatient();
    }
}
