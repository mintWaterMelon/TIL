import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, int score) {
        try {
            Student student = new Student(name, score);
            students.add(student);

            System.out.println("학생이 추가되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
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
                try {
                    student.setScore(newScore);
                    System.out.println("학생 점수가 수정되었습니다.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

                return;
            }
        }

        System.out.println("해당 이름의 학생을 찾을 수 없습니다.");
    }

    public void printTopStudent() {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        Student topStudent = students.get(0);

        for (int i = 1; i < students.size(); i++) {
            Student student = students.get(i);

            if (student.getScore() > topStudent.getScore()) {
                topStudent = student;
            }
        }

        System.out.println("==== 최고 점수 학생 ====");
        topStudent.printInfo();
    }

    public void printStudentsSortedByScoreDesc() {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        List<Student> sortedStudents = new ArrayList<>(students);

        sortedStudents.sort((student1, student2) -> student2.getScore() - student1.getScore());

        System.out.println("==== 점수 높은 순 학생 목록 ====");

        for (int i = 0; i < sortedStudents.size(); i++) {
            Student student = sortedStudents.get(i);
            student.printInfo();
        }
    }
}