package bai3;

public class Main {
    public static void main(String[] args) {

        double[] scores = {6.5, 8.0, 4.5};

        System.out.print("Danh sách điểm: ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i]);
            if (i < scores.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("\n\n>> Kết quả xử lý:");

        double avg = ScoreUtils.calculateAverage(scores);
        System.out.printf("- Điểm trung bình cả lớp: %.2f%n", avg);

        for (double score : scores) {
            String result = ScoreUtils.checkPass(score) ? "Đạt" : "Trượt";
            System.out.println("- Điểm " + score + ": " + result);
        }
    }
}
