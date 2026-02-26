package Bai5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PatientManager {
    private List<Patient> patients = new ArrayList<>();

    // 1) Thêm bệnh nhân (ID không trùng)
    public void addPatient(Patient patient) {
        for (Patient p : patients) {
            if (p.getId().equals(patient.getId())) {
                System.out.println("ID đã tồn tại! Không thể thêm.");
                return;
            }
        }
        patients.add(patient);
        System.out.println("Bệnh nhân đã được thêm thành công.");
    }

    // 2) Cập nhật chẩn đoán theo ID
    public void updateDiagnosis(String id, String newDiagnosis) {
        for (Patient p : patients) {
            if (p.getId().equals(id)) {
                p.setDiagnosis(newDiagnosis);
                System.out.println("Chẩn đoán đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân với ID đã cho.");
    }

    // 3) Xuất viện (xóa theo ID) - dùng Iterator cho an toàn
    public void dischargePatient(String id) {
        Iterator<Patient> it = patients.iterator();
        while (it.hasNext()) {
            Patient p = it.next();
            if (p.getId().equals(id)) {
                it.remove();
                System.out.println("Bệnh nhân đã được xuất viện.");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân với ID đã cho.");
    }

    // 4) Sắp xếp: tuổi giảm dần, nếu bằng tuổi thì tên A-Z
    public void sortPatients() {
        Collections.sort(patients, (a, b) -> {
            // tuổi giảm dần
            if (b.getAge() != a.getAge()) {
                return b.getAge() - a.getAge();
            }
            // nếu tuổi bằng nhau -> tên A-Z
            return a.getFullName().compareToIgnoreCase(b.getFullName());
        });
        System.out.println("Danh sách bệnh nhân đã được sắp xếp.");
    }

    // 5) Hiển thị danh sách
    public void displayPatients() {
        if (patients.size() == 0) {
            System.out.println("Danh sách bệnh nhân trống.");
            return;
        }
        System.out.println("===== DANH SÁCH BỆNH NHÂN =====");
        for (Patient p : patients) {
            System.out.println(p);
        }
    }
}