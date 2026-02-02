package BTTH;

import BTTH.Student;

public class Main {
    public static void main(String[] args) {

        // Tạo các đối tượng Student
        Student s1 = new Student("1", "Hà Bích Ngọc");
        Student s2 = new Student("2", "Nguyễn Văn A");
        Student s3 = new Student("3", "Trần Thị B");

        // Gọi phương thức instance
        s1.displayInfo();
        s2.displayInfo();
        s3.displayInfo();

        // Gọi phương thức static
        Student.showTotalStudent();
    }
}
