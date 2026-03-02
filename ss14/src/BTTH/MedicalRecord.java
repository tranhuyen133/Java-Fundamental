package BTTH;

public class MedicalRecord {
    private String recordId;
    private String diagnosis;
    private String date; // dùng String theo đề, ví dụ "2026-03-02"

    public MedicalRecord() {}

    public MedicalRecord(String recordId, String diagnosis, String date) {
        this.recordId = recordId;
        this.diagnosis = diagnosis;
        this.date = date;
    }

    public String getRecordId() { return recordId; }
    public String getDiagnosis() { return diagnosis; }
    public String getDate() { return date; }

    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public void setDate(String date) { this.date = date; }

    @Override
    public String toString() {
        return "RecordID=" + recordId + ", Date=" + date + ", Diagnosis=" + diagnosis;
    }
}
