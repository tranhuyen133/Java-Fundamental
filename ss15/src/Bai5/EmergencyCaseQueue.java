package Bai5;

import java.util.LinkedList;
import java.util.Queue;

public class EmergencyCaseQueue {
    private Queue<EmergencyCase> cases = new LinkedList<>(); // FIFO

    public void addCase(EmergencyCase c) {
        cases.offer(c); // enqueue
    }

    public EmergencyCase getNextCase() {
        if (cases.isEmpty()) {
            System.err.println(" Không có ca cấp cứu nào đang chờ (Queue rỗng).");
            return null;
        }
        return cases.poll(); // dequeue
    }

    public EmergencyCase peekNextCase() {
        if (cases.isEmpty()) return null;
        return cases.peek();
    }

    public boolean isEmpty() {
        return cases.isEmpty();
    }

    public void displayQueue() {
        System.out.println("=== DANH SÁCH CA CẤP CỨU ĐANG CHỜ (FIFO) ===");
        if (cases.isEmpty()) {
            System.out.println("(Trống)");
            return;
        }
        int i = 1;
        for (EmergencyCase c : cases) {
            System.out.println(i++ + ". " + c);
        }
    }
}
