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

    public void searchStudentByName(String name) {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        boolean found = false;

        System.out.println("==== 학생 검색 결과 ====");

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            if (student.getName().equals(name)) {
                student.printInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("해당 이름의 학생을 찾을 수 없습니다.");
        }
    }

    public void deleteStudentByName(String name) {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            if (student.getName().equals(name)) {
                students.remove(i);
                System.out.println("학생이 삭제되었습니다.");
                return;
            }
        }

        System.out.println("해당 이름의 학생을 찾을 수 없습니다.");
    }

    public void updateStudentScore(String name, int newScore) {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            if (student.getName().equals(name)) {
                student.setScore(newScore);
                System.out.println("학생 점수가 수정되었습니다.");
                return;
            }
        }

        System.out.println("해당 이름의 학생을 찾을 수 없습니다.");
    }
}