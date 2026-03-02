package BTTH;

public class EmergencyPatient extends Patient {
    private int priorityLevel; // càng cao càng ưu tiên

    public EmergencyPatient(String id, String fullName, int age, String medicalCondition, int priorityLevel) {
        super(id, fullName, age, medicalCondition);
        this.priorityLevel = priorityLevel;
    }

    @Override
    public boolean isEmergency() { return true; }

    @Override
    public int getPriorityLevel() { return priorityLevel; }

    public void setPriorityLevel(int priorityLevel) { this.priorityLevel = priorityLevel; }

    @Override
    public void showInfo() {
        System.out.printf("EmergencyPatient{id='%s', name='%s', age=%d, condition='%s', priority=%d}%n",
                id, fullName, age, medicalCondition, priorityLevel);
    }
}
