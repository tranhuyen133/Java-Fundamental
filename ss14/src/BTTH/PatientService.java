package BTTH;

import java.util.*;
import java.util.stream.Collectors;

public class PatientService implements Manageable<Patient> {

    // Set lưu bệnh nhân
    private Set<Patient> patients = new HashSet<>();

    // Map lưu hồ sơ khám: key = patientId, value = list record
    private Map<String, List<MedicalRecord>> recordMap = new HashMap<>();

    private Scanner sc;

    public PatientService(Scanner sc) {
        this.sc = sc;
    }

    // ====== Helpers ======
    private Patient findById(String id) {
        for (Patient p : patients) {
            if (p.getId().equalsIgnoreCase(id)) return p;
        }
        return null;
    }

    private String inputNonEmpty(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Không được để trống!");
        }
    }

    private int inputInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n < min || n > max) {
                    System.out.println("Giá trị phải trong [" + min + ", " + max + "]");
                } else return n;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
    }

    // ====== CRUD Patient ======
    @Override
    public void add(Patient p) {
        // HashSet sẽ dựa equals/hashCode => trùng id là không add
        boolean ok = patients.add(p);
        if (!ok) {
            System.out.println("❌ ID đã tồn tại. Không thể thêm.");
        } else {
            System.out.println("✅ Thêm bệnh nhân thành công.");
        }
    }

    public void addPatientFromInput() {
        String id = inputNonEmpty("Nhập ID: ");
        if (findById(id) != null) {
            System.out.println("❌ ID đã tồn tại.");
            return;
        }
        String name = inputNonEmpty("Nhập tên: ");
        int age = inputInt("Nhập tuổi: ", 0, 150);
        String phone = inputNonEmpty("Nhập SĐT: ");

        add(new Patient(id, name, age, phone));
    }

    @Override
    public void update(String id) {
        Patient p = findById(id);
        if (p == null) {
            System.out.println("❌ Không tìm thấy bệnh nhân ID: " + id);
            return;
        }
        System.out.println("Thông tin hiện tại:");
        p.displayInfo();

        String name = inputNonEmpty("Nhập tên mới: ");
        int age = inputInt("Nhập tuổi mới: ", 0, 150);
        String phone = inputNonEmpty("Nhập SĐT mới: ");

        p.setName(name);
        p.setAge(age);
        p.setPhone(phone);

        System.out.println("✅ Cập nhật thành công.");
    }

    @Override
    public void delete(String id) {
        Patient p = findById(id);
        if (p == null) {
            System.out.println("❌ Không tìm thấy bệnh nhân ID: " + id);
            return;
        }
        patients.remove(p);

        // tuỳ chọn: xóa luôn record của bệnh nhân
        recordMap.remove(p.getId());

        System.out.println("✅ Đã xóa bệnh nhân và hồ sơ liên quan (nếu có).");
    }

    @Override
    public void displayAll() {
        if (patients.isEmpty()) {
            System.out.println("(Danh sách trống)");
            return;
        }
        System.out.println("----- DANH SÁCH BỆNH NHÂN -----");
        for (Patient p : patients) p.displayInfo();
    }

    // ====== Medical Records (Map) ======
    public void addMedicalRecord() {
        String patientId = inputNonEmpty("Nhập patientId: ");
        Patient p = findById(patientId);
        if (p == null) {
            System.out.println("❌ Không tồn tại bệnh nhân ID: " + patientId);
            return;
        }

        String recordId = inputNonEmpty("Nhập recordId: ");
        // kiểm tra recordId trùng trong list của bệnh nhân
        List<MedicalRecord> list = recordMap.getOrDefault(patientId, new ArrayList<>());
        for (MedicalRecord r : list) {
            if (r.getRecordId().equalsIgnoreCase(recordId)) {
                System.out.println("❌ recordId đã tồn tại cho bệnh nhân này.");
                return;
            }
        }

        String date = inputNonEmpty("Nhập ngày khám (VD: 2026-03-02): ");
        String diagnosis = inputNonEmpty("Nhập chẩn đoán: ");

        list.add(new MedicalRecord(recordId, diagnosis, date));
        recordMap.put(patientId, list);

        System.out.println("✅ Thêm hồ sơ khám thành công.");
    }

    public void viewRecordsByPatient() {
        String patientId = inputNonEmpty("Nhập patientId: ");
        Patient p = findById(patientId);
        if (p == null) {
            System.out.println("❌ Không tồn tại bệnh nhân ID: " + patientId);
            return;
        }

        List<MedicalRecord> list = recordMap.get(patientId);
        System.out.println("Bệnh nhân:");
        p.displayInfo();

        if (list == null || list.isEmpty()) {
            System.out.println("(Chưa có hồ sơ khám)");
            return;
        }

        System.out.println("----- HỒ SƠ KHÁM -----");
        for (MedicalRecord r : list) System.out.println(r);
    }

    public void deleteMedicalRecord() {
        String patientId = inputNonEmpty("Nhập patientId: ");
        List<MedicalRecord> list = recordMap.get(patientId);
        if (list == null || list.isEmpty()) {
            System.out.println("❌ Bệnh nhân này chưa có hồ sơ hoặc patientId không đúng.");
            return;
        }

        String recordId = inputNonEmpty("Nhập recordId cần xóa: ");
        boolean removed = list.removeIf(r -> r.getRecordId().equalsIgnoreCase(recordId));

        if (!removed) {
            System.out.println("❌ Không tìm thấy recordId: " + recordId);
            return;
        }

        if (list.isEmpty()) recordMap.remove(patientId);
        else recordMap.put(patientId, list);

        System.out.println("✅ Đã xóa hồ sơ.");
    }

    // ====== Search ======
    public void searchPatient() {
        System.out.println("1. Tìm theo ID");
        System.out.println("2. Tìm theo tên (gần đúng)");
        int choice = inputInt("Chọn: ", 1, 2);

        if (choice == 1) {
            String id = inputNonEmpty("Nhập ID: ");
            Patient p = findById(id);
            if (p == null) System.out.println("❌ Không tìm thấy.");
            else p.displayInfo();
        } else {
            String keyword = inputNonEmpty("Nhập từ khóa tên: ").toLowerCase();
            List<Patient> result = patients.stream()
                    .filter(p -> p.getName().toLowerCase().contains(keyword))
                    .collect(Collectors.toList());

            if (result.isEmpty()) {
                System.out.println("❌ Không tìm thấy.");
            } else {
                System.out.println("Kết quả:");
                result.forEach(Patient::displayInfo);
            }
        }
    }

    public void searchMedicalRecord() {
        System.out.println("1. Tìm theo ngày khám");
        System.out.println("2. Tìm theo chẩn đoán");
        int choice = inputInt("Chọn: ", 1, 2);

        String keyword = inputNonEmpty("Nhập từ khóa: ").toLowerCase();

        boolean found = false;
        for (Map.Entry<String, List<MedicalRecord>> e : recordMap.entrySet()) {
            String patientId = e.getKey();
            for (MedicalRecord r : e.getValue()) {
                boolean match = (choice == 1)
                        ? r.getDate().toLowerCase().contains(keyword)
                        : r.getDiagnosis().toLowerCase().contains(keyword);

                if (match) {
                    if (!found) System.out.println("----- KẾT QUẢ HỒ SƠ -----");
                    found = true;
                    System.out.println("patientId=" + patientId + " | " + r);
                }
            }
        }
        if (!found) System.out.println("❌ Không tìm thấy hồ sơ phù hợp.");
    }

    // ====== Sort Patients ======
    public void sortPatientsMenu() {
        if (patients.isEmpty()) {
            System.out.println("(Danh sách trống)");
            return;
        }

        System.out.println("1. Mặc định theo tên (Comparable)");
        System.out.println("2. Theo tuổi (Comparator)");
        System.out.println("3. Theo ID (Comparator)");
        int choice = inputInt("Chọn: ", 1, 3);

        List<Patient> list = new ArrayList<>(patients);

        if (choice == 1) {
            Collections.sort(list); // compareTo
        } else if (choice == 2) {
            Comparator<Patient> byAge = (a, b) -> Integer.compare(a.getAge(), b.getAge());
            list.sort(byAge);
        } else {
            Comparator<Patient> byId = (a, b) -> a.getId().compareToIgnoreCase(b.getId());
            list.sort(byId);
        }

        System.out.println("----- DANH SÁCH SAU SẮP XẾP -----");
        for (Patient p : list) p.displayInfo();
    }
}