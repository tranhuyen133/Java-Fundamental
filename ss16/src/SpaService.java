// SpaService.java
import java.util.LinkedList;
import java.util.Queue;

public class SpaService {
    private final Queue<SpaTicket> queue = new LinkedList<>();

    public void checkIn(SpaTicket ticket) {
        queue.offer(ticket);
    }

    public SpaTicket serveNext() {
        return queue.poll(); // FIFO
    }

    public void viewQueue() {
        if (queue.isEmpty()) {
            System.out.println("Spa queue is empty.");
            return;
        }
        System.out.println("Spa waiting list:");
        for (SpaTicket t : queue) System.out.println("- " + t);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}