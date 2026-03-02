package Bai3;

public class Main {
    public static void main(String[] args) {
        MedicationProcessChecker checker = new MedicationProcessChecker();

        String[][] tests = {
                {"PUSH", "PUSH", "POP", "POP"},
                {"POP", "PUSH"},
                {"PUSH", "PUSH", "POP"},
                {"PUSH", "DONE", "POP"}
        };

        for (int t = 0; t < tests.length; t++) {
            boolean ok = checker.checkProcess(tests[t]);
            System.out.println("Test " + (t + 1) + ": " + String.join(", ", tests[t]));
            if (ok) {
                System.out.println(" Hợp lệ\n");
            } else {
                System.out.println(" Không hợp lệ: " + checker.getLastError() + "\n");
            }
        }
    }
}
