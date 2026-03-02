package Bai2;

import java.util.LinkedList;
import java.util.Queue;

public class PatientQueue {
    private Queue<Patient> queue = new LinkedList<>(); // FIFO

    // enqueue
    public void addPatient(Patient p) {
        queue.offer(p);
    }

    // dequeue
    public Patient callNextPatient() {
        if (queue.isEmpty()) {
            System.err.println(" Hàng đợi rỗng - không có bệnh nhân để gọi.");
            return null;
        }
        return queue.poll();
    }

    // peek
    public Patient peekNextPatient() {
        if (queue.isEmpty()) {
            System.err.println(" Hàng đợi rỗng - không có bệnh nhân tiếp theo.");
            return null;
        }
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("(Không có bệnh nhân đang chờ)");
            return;
        }
        System.out.println("=== DANH SÁCH BỆNH NHÂN ĐANG CHỜ (FIFO) ===");
        int i = 1;
        for (Patient p : queue) {
            System.out.println(i++ + ". " + p);
        }
    }

    public void displayQueueState() {
        System.out.println("Queue (front -> back) = " + queue);
    }
}
