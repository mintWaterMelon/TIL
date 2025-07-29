import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentManager {

    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, int score) {
        if (existsByName(name)) {
            System.out.println("이미 등록된 학생 이름입니다.");
            return;
        }

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

    public void printStudentCount() {
        System.out.println("전체 학생 수: " + students.size() + "명");
    }

    public void deleteAllStudents() {
        if (students.isEmpty()) {
            System.out.println("삭제할 학생이 없습니다.");
            return;
        }

        students.clear();

        System.out.println("모든 학생이 삭제되었습니다.");
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

    public void searchStudentsByNameKeyword(String keyword) {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        boolean found = false;
        String lowerKeyword = keyword.toLowerCase();

        System.out.println("==== 이름 일부 검색 결과 ====");

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            String lowerName = student.getName().toLowerCase();

            if (lowerName.contains(lowerKeyword)) {
                student.printInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("이름에 '" + keyword + "'이 포함된 학생을 찾을 수 없습니다.");
        }
    }

    public void updateStudentName(String currentName, String newName) {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        if (existsByName(newName)) {
            System.out.println("이미 등록된 학생 이름입니다.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            if (student.getName().equals(currentName)) {
                student.setName(newName);
                System.out.println("학생 이름이 변경되었습니다.");
                return;
            }
        }

        System.out.println("해당 이름의 학생을 찾을 수 없습니다.");
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

    public void printLowestScoreStudent() {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        Student lowestScoreStudent = students.get(0);

        for (int i = 1; i < students.size(); i++) {
            Student student = students.get(i);

            if (student.getScore() < lowestScoreStudent.getScore()) {
                lowestScoreStudent = student;
            }
        }

        System.out.println("==== 최저 점수 학생 ====");
        lowestScoreStudent.printInfo();
    }

    public void printStudentsSortedByScoreDesc() {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        List<Student> sortedStudents = new ArrayList<>(students);

        sortedStudents.sort(Comparator.comparing(Student::getScore).reversed());

        System.out.println("==== 점수 높은 순 학생 목록 ====");

        for (int i = 0; i < sortedStudents.size(); i++) {
            Student student = sortedStudents.get(i);
            student.printInfo();
        }
    }

    public void printStudentsSortedByScoreAsc() {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        List<Student> sortedStudents = new ArrayList<>(students);

        sortedStudents.sort(Comparator.comparing(Student::getScore));

        System.out.println("==== 점수 낮은 순 학생 목록 ====");

        for (int i = 0; i < sortedStudents.size(); i++) {
            Student student = sortedStudents.get(i);
            student.printInfo();
        }
    }

    public void printStudentsSortedByNameAsc() {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        List<Student> sortedStudents = new ArrayList<>(students);

        sortedStudents.sort(Comparator.comparing(Student::getName));

        System.out.println("==== 이름순 학생 목록 ====");

        for (int i = 0; i < sortedStudents.size(); i++) {
            Student student = sortedStudents.get(i);
            student.printInfo();
        }
    }

    public void printGradeStatistics() {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        Map<String, Integer> gradeCountMap = new LinkedHashMap<>();

        gradeCountMap.put("A", 0);
        gradeCountMap.put("B", 0);
        gradeCountMap.put("C", 0);
        gradeCountMap.put("D", 0);
        gradeCountMap.put("F", 0);

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            String grade = student.getGrade();

            int count = gradeCountMap.getOrDefault(grade, 0);
            gradeCountMap.put(grade, count + 1);
        }

        System.out.println("==== 등급별 학생 수 ====");

        for (String grade : gradeCountMap.keySet()) {
            int count = gradeCountMap.get(grade);
            System.out.println(grade + "등급: " + count + "명");
        }
    }

    public void printStudentsByGrade(String grade) {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        String targetGrade = grade.toUpperCase();

        if (!isValidGrade(targetGrade)) {
            System.out.println("등급은 A, B, C, D, F 중 하나만 입력할 수 있습니다.");
            return;
        }

        boolean found = false;

        System.out.println("==== " + targetGrade + "등급 학생 목록 ====");

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            if (student.getGrade().equals(targetGrade)) {
                student.printInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println(targetGrade + "등급 학생이 없습니다.");
        }
    }

    public void searchStudentsByScoreRange(int minScore, int maxScore) {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        if (!isValidScore(minScore) || !isValidScore(maxScore)) {
            System.out.println("점수는 0점 이상 100점 이하만 입력할 수 있습니다.");
            return;
        }

        if (minScore > maxScore) {
            System.out.println("최소 점수는 최대 점수보다 클 수 없습니다.");
            return;
        }

        boolean found = false;

        System.out.println("==== " + minScore + "점 이상 " + maxScore + "점 이하 학생 목록 ====");

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            int score = student.getScore();

            if (score >= minScore && score <= maxScore) {
                student.printInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("해당 점수 범위에 포함되는 학생이 없습니다.");
        }
    }

    public void printAverageScoreByGrade(String grade) {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        String targetGrade = grade.toUpperCase();

        if (!isValidGrade(targetGrade)) {
            System.out.println("등급은 A, B, C, D, F 중 하나만 입력할 수 있습니다.");
            return;
        }

        int totalScore = 0;
        int count = 0;

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            if (student.getGrade().equals(targetGrade)) {
                totalScore += student.getScore();
                count++;
            }
        }

        if (count == 0) {
            System.out.println(targetGrade + "등급 학생이 없습니다.");
            return;
        }

        double average = (double) totalScore / count;

        System.out.println(targetGrade + "등급 평균 점수: " + average);
    }

    public void printPassFailStatistics() {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        int passCount = 0;
        int failCount = 0;

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            if (student.getScore() >= 60) {
                passCount++;
            } else {
                failCount++;
            }
        }

        System.out.println("==== 합격 / 불합격 학생 수 ====");
        System.out.println("합격: " + passCount + "명");
        System.out.println("불합격: " + failCount + "명");
    }

    public void printStudentsByPassFail(String status) {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        String targetStatus = status.toLowerCase();

        if (!targetStatus.equals("pass") && !targetStatus.equals("fail")) {
            System.out.println("pass 또는 fail만 입력할 수 있습니다.");
            return;
        }

        boolean found = false;

        if (targetStatus.equals("pass")) {
            System.out.println("==== 합격 학생 목록 ====");
        } else {
            System.out.println("==== 불합격 학생 목록 ====");
        }

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            if (targetStatus.equals("pass") && student.getScore() >= 60) {
                student.printInfo();
                found = true;
            } else if (targetStatus.equals("fail") && student.getScore() < 60) {
                student.printInfo();
                found = true;
            }
        }

        if (!found) {
            if (targetStatus.equals("pass")) {
                System.out.println("합격 학생이 없습니다.");
            } else {
                System.out.println("불합격 학생이 없습니다.");
            }
        }
    }

    private boolean isValidScore(int score) {
        return score >= 0 && score <= 100;
    }

    private boolean isValidGrade(String grade) {
        return grade.equals("A")
                || grade.equals("B")
                || grade.equals("C")
                || grade.equals("D")
                || grade.equals("F");
    }

    private boolean existsByName(String name) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            if (student.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}