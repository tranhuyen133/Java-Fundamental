package Bai5;

import java.util.Stack;

public class EmergencyCase {
    private Patient patient;
    private Stack<TreatmentStep> steps = new Stack<>();

    public EmergencyCase(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() { return patient; }
    public Stack<TreatmentStep> getSteps() { return steps; }

    public void addStep(TreatmentStep step) {
        steps.push(step); // push
    }

    public TreatmentStep undoStep() {
        if (steps.isEmpty()) {
            System.err.println(" Không thể Undo: chưa có bước xử lý nào (Stack rỗng).");
            return null;
        }
        return steps.pop(); // pop
    }

    public void displaySteps() {
        System.out.println("=== CÁC BƯỚC XỬ LÝ (LIFO: gần nhất trước) ===");
        if (steps.isEmpty()) {
            System.out.println("(Chưa có bước xử lý)");
            return;
        }
        for (int i = steps.size() - 1; i >= 0; i--) {
            System.out.println("- " + steps.get(i));
        }
    }

    @Override
    public String toString() {
        return "EmergencyCase{patient=" + patient + ", stepsCount=" + steps.size() + "}";
    }
}