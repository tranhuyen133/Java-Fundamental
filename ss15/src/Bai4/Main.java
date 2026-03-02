package Bai4;

public class Main {
    public static void main(String[] args) {
        EmergencyQueue q = new EmergencyQueue();

        // Thử nhập xen kẽ
        q.addPatient(new EmergencyPatient("P01", "An", 2));
        q.addPatient(new EmergencyPatient("P02", "Bình", 1));
        q.addPatient(new EmergencyPatient("P03", "Chi", 2));
        q.addPatient(new EmergencyPatient("P04", "Dũng", 1));
        q.addPatient(new EmergencyPatient("P05", "Hà", 1));

        q.displayQueue();

        System.out.println("\n=== THỨ TỰ ĐƯỢC KHÁM ===");
        while (!q.isEmpty()) {
            System.out.println("Gọi khám: " + q.callNextPatient());
        }
    }
}