public class Bai1{
    // Thuộc tính của sinh viên
    private String studentId;
    private String fullName;
    private int birthYear;
    private double gpa;

    // Constructor có tham số
    public Bai1(String studentId, String fullName, int birthYear, double gpa) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.birthYear = birthYear;
        this.gpa = gpa;
    }

    // Phương thức hiển thị thông tin sinh viên
    public void displayInfo() {
        System.out.println("------------------------------");
        System.out.println("Mã sinh viên: " + studentId);
        System.out.println("Họ và tên   : " + fullName);
        System.out.println("Năm sinh    : " + birthYear);
        System.out.println("Điểm TB     : " + gpa);
        System.out.println("------------------------------");
    }

    // Getter và Setter nếu cần (ở đây không bắt buộc)
}
