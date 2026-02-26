package BTTH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PatientManager {
    private List<Patient> patients = new ArrayList<>();

    // thêm
    public void addPatient(Patient patient) {
        // kiểm tra trùng ID
        for (Patient p : patients) {
            if (p.getId() == patient.getId()) {
                System.out.println("ID đã tồn tại! Không thể thêm.");
                return;
            }
        }
        patients.add(patient);
        System.out.println("Thêm bệnh nhân thành công!");
    }

    // xoá theo ID (dùng Iterator cho giống demo)
    public void removePatient(int patientId) {
        Iterator<Patient> it = patients.iterator();
        while (it.hasNext()) {
            Patient p = it.next();
            if (p.getId() == patientId) {
                it.remove();
                System.out.println("Xóa thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân có ID: " + patientId);
    }

    // cập nhật theo ID
    public void updatePatient(int patientId, Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == patientId) {
                // set giống demo (cập nhật tại vị trí i)
                patients.set(i, updatedPatient);
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân có ID: " + patientId);
    }

    // tìm kiếm theo tên
    public void searchPatientByName(String name) {
        boolean found = false;
        for (Patient p : patients) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy bệnh nhân phù hợp!");
    }

    // sắp xếp theo tuổi (tăng/giảm) - dùng Collections.sort cho đơn giản
    public void sortPatientsByAge(boolean asc) {
        Collections.sort(patients, (a, b) -> {
            if (asc) return a.getAge() - b.getAge();
            return b.getAge() - a.getAge();
        });
        System.out.println("Đã sắp xếp theo tuổi.");
    }

    // sắp xếp theo tên (A-Z / Z-A)
    public void sortPatientsByName(boolean asc) {
        Collections.sort(patients, (a, b) -> {
            if (asc) return a.getName().compareToIgnoreCase(b.getName());
            return b.getName().compareToIgnoreCase(a.getName());
        });
        System.out.println("Đã sắp xếp theo tên.");
    }

    // hiển thị
    public void displayPatients() {
        if (patients.size() == 0) {
            System.out.println("Danh sách trống!");
            return;
        }
        for (Patient p : patients) {
            System.out.println(p);
        }
    }
}
