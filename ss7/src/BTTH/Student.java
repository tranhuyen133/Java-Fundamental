package BTTH;

public class Student {

    // ===== Instance variables (dữ liệu riêng) =====
    private String id;
    private String name;

    // ===== Static variables (dữ liệu dùng chung) =====
    public static final String SCHOOL_NAME = "PTIT";
    public static int studentCount = 0;

    // ===== Constructors =====
    public Student() {
        studentCount++;
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        studentCount++;
    }

    // ===== Getter / Setter =====
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ===== Instance method =====
    public void displayInfo() {
        System.out.println("-----------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("School Name: " + SCHOOL_NAME);
        System.out.println("-----------------------------------");
    }

    // ===== Static method =====
    public static void showTotalStudent() {
        System.out.println("Tổng số sinh viên: " + studentCount);
    }
}
