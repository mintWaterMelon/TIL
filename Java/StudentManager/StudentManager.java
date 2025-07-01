public class StudentManager {

    private Student[] students;
    private int count;

    public StudentManager(int size) {
        this.students = new Student[size];
        this.count = 0;
    }

    public void addStudent(String name, int score) {
        if (count >= students.length) {
            System.out.println("더 이상 학생을 추가할 수 없습니다.");
            return;
        }

        students[count] = new Student(name, score);
        count++;

        System.out.println("학생이 추가되었습니다.");
    }

    public void printStudents() {
        if (count == 0) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        System.out.println("==== 학생 목록 ====");

        for (int i = 0; i < count; i++) {
            students[i].printInfo();
        }
    }

    public void printAverageScore() {
        if (count == 0) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        int totalScore = 0;

        for (int i = 0; i < count; i++) {
            totalScore += students[i].getScore();
        }

        double average = (double) totalScore / count;

        System.out.println("평균 점수: " + average);
    }
}