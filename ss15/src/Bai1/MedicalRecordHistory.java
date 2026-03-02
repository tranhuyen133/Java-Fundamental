package Bai1;

import java.util.Stack;

public class MedicalRecordHistory {
    private Stack<EditAction> history = new Stack<>();

    public void addEdit(EditAction action) {
        history.push(action); // push
    }

    public EditAction undoEdit() {
        if (history.isEmpty()) {
            System.err.println(" Không thể Undo: Stack rỗng");
            return null;
        }
        return history.pop(); // pop
    }

    public EditAction getLatestEdit() {
        if (history.isEmpty()) {
            System.err.println(" Không có chỉnh sửa gần nhất: Stack rỗng");
            return null;
        }
        return history.peek(); // peek
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public void displayHistory() {
        if (history.isEmpty()) {
            System.out.println("(Chưa có chỉnh sửa nào)");
            return;
        }

        System.out.println("=== LỊCH SỬ CHỈNH SỬA (LIFO: gần nhất trước) ===");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println("- " + history.get(i));
        }
    }

    public void displayStackState() {
        // hiển thị dạng stack từ đáy -> đỉnh
        System.out.println("Stack (bottom -> top) = " + history);
    }
}
