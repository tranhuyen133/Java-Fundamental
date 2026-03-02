package BTTH;

import java.util.Stack;

import java.util.Stack;

public class Patient extends Person {
    protected String medicalCondition;
    protected Stack<String> history; // lưu lịch sử (LIFO)

    public Patient(String id, String fullName, int age, String medicalCondition) {
        super(id, fullName, age);
        this.medicalCondition = medicalCondition;
        this.history = new Stack<>();
    }

    public String getMedicalCondition() { return medicalCondition; }
    public void setMedicalCondition(String medicalCondition) { this.medicalCondition = medicalCondition; }

    public Stack<String> getHistory() { return history; }

    public boolean isEmergency() { return false; }
    public int getPriorityLevel() { return 0; } // thường = 0

    @Override
    public void showInfo() {
        System.out.printf("Patient{id='%s', name='%s', age=%d, condition='%s'}%n",
                id, fullName, age, medicalCondition);
    }
}
