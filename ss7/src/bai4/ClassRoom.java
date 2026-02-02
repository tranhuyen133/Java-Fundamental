package bai4;

public class ClassRoom {
    private String studentName;
    private static double classFund = 0;

    public ClassRoom(String studentName) {
        this.studentName = studentName;
    }

    public void contribute(double amount) {
        classFund += amount;
    }

    public void showStudent() {
        System.out.println("Sinh viên: " + studentName);
    }

    public static void showClassFund() {
        System.out.println("Tổng quỹ lớp: " + classFund);
    }
}
