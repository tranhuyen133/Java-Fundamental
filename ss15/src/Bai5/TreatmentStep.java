package Bai5;

public class TreatmentStep {
    private String description;
    private String time;

    public TreatmentStep(String description, String time) {
        this.description = description;
        this.time = time;
    }

    public String getDescription() { return description; }
    public String getTime() { return time; }

    public void setDescription(String description) { this.description = description; }
    public void setTime(String time) { this.time = time; }

    @Override
    public String toString() {
        return "TreatmentStep{time='" + time + "', description='" + description + "'}";
    }
}
