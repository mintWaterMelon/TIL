import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, int score) {
        Student student = new Student(name, score);
        students.add(student);

        System.out.println("학생이 추가되었습니다.");
    }

    public void printStudents() {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        System.out.println("==== 학생 목록 ====");

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            student.printInfo();
        }
    }

    public void printAverageScore() {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        int totalScore = 0;

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            totalScore += student.getScore();
        }

        double average = (double) totalScore / students.size();

        System.out.println("평균 점수: " + average);
    }
}