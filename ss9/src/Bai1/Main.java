package Bai1;

public class Main {
    public static void main(String[] args) {
        Student st = new Student("Nguyễn Văn A", 20, "SV001", 8.5);
        st.displayInfo();

        // Student IS-A Person (kế thừa)
        Person p = st;          // đa hình cơ bản: kiểu Person, đối tượng Student
        p.displayInfo();        // vẫn gọi Student.displayInfo() vì overriding
    }
}
