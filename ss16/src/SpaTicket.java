// SpaTicket.java
import java.time.LocalDateTime;

public class SpaTicket {
    private String ticketId;
    private String petId;
    private String customerId;
    private String serviceType;
    private LocalDateTime createdAt;

    public SpaTicket(String ticketId, String petId, String customerId, String serviceType) {
        this.ticketId = ticketId;
        this.petId = petId;
        this.customerId = customerId;
        this.serviceType = serviceType;
        this.createdAt = LocalDateTime.now();
    }

    public String getTicketId() { return ticketId; }
    public String getPetId() { return petId; }
    public String getCustomerId() { return customerId; }
    public String getServiceType() { return serviceType; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return "SpaTicket{" +
                "ticketId='" + ticketId + '\'' +
                ", petId='" + petId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}