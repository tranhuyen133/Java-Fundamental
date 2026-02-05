package Bai1;

public class Student extends Person {
    private String studentId;
    private double gpa;

    public Student(String fullName, int age, String studentId, double gpa) {
        super(fullName, age); // dùng constructor lớp cha
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // dùng lại hiển thị của Person (không lặp code)
        System.out.println("Mã sinh viên: " + studentId);
        System.out.println("Điểm trung bình: " + gpa);
    }
}