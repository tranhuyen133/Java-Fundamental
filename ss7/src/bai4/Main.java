package bai4;

public class Main {
    public static void main(String[] args) {
        ClassRoom s1 = new ClassRoom("An");
        ClassRoom s2 = new ClassRoom("Bình");
        ClassRoom s3 = new ClassRoom("Chi");

        s1.contribute(100000);
        s2.contribute(150000);
        s3.contribute(200000);

        s1.showStudent();
        s2.showStudent();
        s3.showStudent();

        ClassRoom.showClassFund();
    }
}
