package BTTH;

import java.util.*;

public class HospitalManagement implements IManagement<Patient> {

    // YÊU CẦU: Queue + LinkedList
    private final Queue<Patient> waitingQueue = new LinkedList<>();

    // Lưu mọi bệnh nhân đã đăng ký để xem lịch sử theo ID (kể cả đã khám xong)
    private final Map<String, Patient> registry = new HashMap<>();

    @Override
    public void add(Patient p) {
        if (registry.containsKey(p.getId())) {
            throw new IllegalArgumentException("ID đã tồn tại: " + p.getId());
        }
        registry.put(p.getId(), p);

        // Nếu cấp cứu: ưu tiên đẩy lên đầu hàng đợi
        if (p.isEmergency()) {
            // LinkedList implement Queue và có addFirst -> ép kiểu để dùng
            ((LinkedList<Patient>) waitingQueue).addFirst(p);
        } else {
            waitingQueue.offer(p);
        }
    }

    @Override
    public void display() {
        if (waitingQueue.isEmpty()) {
            System.out.println("(Hàng đợi rỗng)");
            return;
        }
        System.out.println("=== DANH SÁCH BỆNH NHÂN ĐANG CHỜ ===");
        int i = 1;
        for (Patient p : waitingQueue) {
            System.out.print(i++ + ". ");
            p.showInfo();
        }
    }

    @Override
    public List<Patient> search(String keyword) {
        String key = keyword.trim().toLowerCase();
        List<Patient> res = new ArrayList<>();
        for (Patient p : waitingQueue) {
            if (p.getId().toLowerCase().contains(key) ||
                    p.getFullName().toLowerCase().contains(key)) {
                res.add(p);
            }
        }
        return res;
    }

    /**
     * mode:
     * 1 = sắp xếp theo tuổi giảm dần, nếu bằng tuổi -> tên A-Z
     * 2 = sắp xếp theo ưu tiên (cấp cứu trước, priority giảm dần), sau đó tuổi giảm dần, rồi tên A-Z
     */
    @Override
    public void sort(int mode) {
        if (waitingQueue.isEmpty()) {
            System.out.println("(Không có dữ liệu để sắp xếp - hàng đợi rỗng)");
            return;
        }

        List<Patient> list = new ArrayList<>(waitingQueue);

        Comparator<Patient> nameAZ = Comparator.comparing(p -> normalizeName(p.getFullName()));

        if (mode == 1) {
            list.sort(
                    Comparator.comparingInt(Patient::getAge).reversed()
                            .thenComparing(nameAZ)
            );
        } else if (mode == 2) {
            list.sort(
                    Comparator.comparingInt((Patient p) -> p.isEmergency() ? 1 : 0).reversed()
                            .thenComparingInt(Patient::getPriorityLevel).reversed()
                            .thenComparingInt(Patient::getAge).reversed()
                            .thenComparing(nameAZ)
            );
        } else {
            System.out.println("Mode sắp xếp không hợp lệ.");
            return;
        }

        waitingQueue.clear();
        waitingQueue.addAll(list);
        System.out.println("✅ Đã sắp xếp xong.");
    }

    private String normalizeName(String fullName) {
        // Lấy tên cuối để sort cho “đẹp”: Nguyễn Văn A -> "a nguyễn văn a"
        String s = fullName.trim().replaceAll("\\s+", " ");
        String[] parts = s.split(" ");
        String last = parts[parts.length - 1].toLowerCase();
        return last + " " + s.toLowerCase();
    }

    /**
     * Gọi khám bệnh (dequeue):
     * - Lấy bệnh nhân đầu tiên ra khỏi Queue
     * - Nhập thông tin chẩn đoán/đơn thuốc
     * - Push vào Stack history của bệnh nhân đó
     */
    public void callNextAndTreat(Scanner sc) {
        if (waitingQueue.isEmpty()) {
            // xử lý ngoại lệ logic: queue rỗng
            System.err.println("❌ Không có bệnh nhân trong hàng đợi (Queue rỗng).");
            return;
        }

        Patient p = waitingQueue.poll(); // dequeue
        System.out.println("=== ĐANG KHÁM BỆNH ===");
        p.showInfo();

        System.out.print("Nhập chẩn đoán/đơn thuốc/lần khám: ");
        String record = sc.nextLine().trim();
        if (record.isEmpty()) record = "(Không nhập mô tả)";

        String entry = String.format("[%s] %s", new Date(), record);
        p.getHistory().push(entry); // push vào stack

        System.out.println("✅ Đã lưu lịch sử điều trị (Stack push).");
    }

    /**
     * Xem lịch sử theo ID (LIFO: gần nhất trước)
     */
    public void viewHistory(String id) {
        Patient p = registry.get(id);
        if (p == null) {
            System.err.println("❌ Không tìm thấy bệnh nhân có ID: " + id);
            return;
        }

        Stack<String> h = p.getHistory();
        if (h.isEmpty()) {
            // xử lý ngoại lệ logic: stack rỗng
            System.err.println("❌ Bệnh nhân chưa có lịch sử điều trị (Stack rỗng).");
            return;
        }

        System.out.println("=== LỊCH SỬ ĐIỀU TRỊ (LIFO) ===");
        System.out.println("Bệnh nhân: " + p.getFullName() + " | ID: " + p.getId());

        // In từ gần nhất -> cũ hơn (đúng LIFO)
        for (int i = h.size() - 1; i >= 0; i--) {
            System.out.println("- " + h.get(i));
        }

        // Nếu bạn muốn “pop” để xem và xoá dần (LIFO đúng nghĩa), dùng:
        // while (!h.isEmpty()) System.out.println(h.pop());
    }
}
