public class Main {

    public static void main(String[] args) {
        Student[] students = new Student[3];

        students[0] = new Student("김철수", 85);
        students[1] = new Student("이영희", 92);
        students[2] = new Student("박민수", 76);

        System.out.println("==== 학생 점수 목록 ====");

        int totalScore = 0;

        for (int i = 0; i < students.length; i++) {
            students[i].printInfo();
            totalScore += students[i].getScore();
        }

        double average = (double) totalScore / students.length;

        System.out.println("--------------------");
        System.out.println("총점: " + totalScore);
        System.out.println("평균: " + average);
    }
}