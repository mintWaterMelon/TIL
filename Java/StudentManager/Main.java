import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();

        while (true) {
            System.out.println();
            System.out.println("==== 학생 관리 프로그램 ====");
            System.out.println("1. 학생 추가");
            System.out.println("2. 학생 목록 조회");
            System.out.println("3. 평균 점수 조회");
            System.out.println("4. 학생 이름 검색");
            System.out.println("5. 학생 삭제");
            System.out.println("6. 학생 점수 수정");
            System.out.println("7. 최고 점수 학생 조회");
            System.out.println("8. 점수 높은 순 정렬 조회");
            System.out.println("9. 이름순 정렬 조회");
            System.out.println("10. 등급별 학생 수 조회");
            System.out.println("11. 특정 등급 학생 목록 조회");
            System.out.println("12. 점수 범위로 학생 검색");
            System.out.println("13. 최저 점수 학생 조회");
            System.out.println("14. 점수 낮은 순 정렬 조회");
            System.out.println("15. 특정 등급 평균 점수 조회");
            System.out.println("16. 합격 / 불합격 학생 수 조회");
            System.out.println("17. 합격 / 불합격 학생 목록 조회");
            System.out.println("18. 전체 학생 수 조회");
            System.out.println("0. 종료");
            System.out.print("메뉴를 선택하세요: ");

            int menu = scanner.nextInt();

            if (menu == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (menu == 1) {
                System.out.print("학생 이름: ");
                String name = scanner.next();

                System.out.print("학생 점수: ");
                int score = scanner.nextInt();

                studentManager.addStudent(name, score);
            } else if (menu == 2) {
                studentManager.printStudents();
            } else if (menu == 3) {
                studentManager.printAverageScore();
            } else if (menu == 4) {
                System.out.print("검색할 학생 이름: ");
                String name = scanner.next();

                studentManager.searchStudentByName(name);
            } else if (menu == 5) {
                System.out.print("삭제할 학생 이름: ");
                String name = scanner.next();

                studentManager.deleteStudentByName(name);
            } else if (menu == 6) {
                System.out.print("수정할 학생 이름: ");
                String name = scanner.next();

                System.out.print("새 점수: ");
                int newScore = scanner.nextInt();

                studentManager.updateStudentScore(name, newScore);
            } else if (menu == 7) {
                studentManager.printTopStudent();
            } else if (menu == 8) {
                studentManager.printStudentsSortedByScoreDesc();
            } else if (menu == 9) {
                studentManager.printStudentsSortedByNameAsc();
            } else if (menu == 10) {
                studentManager.printGradeStatistics();
            } else if (menu == 11) {
                System.out.print("조회할 등급을 입력하세요(A, B, C, D, F): ");
                String grade = scanner.next();

                studentManager.printStudentsByGrade(grade);
            } else if (menu == 12) {
                System.out.print("최소 점수: ");
                int minScore = scanner.nextInt();

                System.out.print("최대 점수: ");
                int maxScore = scanner.nextInt();

                studentManager.searchStudentsByScoreRange(minScore, maxScore);
            } else if (menu == 13) {
                studentManager.printLowestScoreStudent();
            } else if (menu == 14) {
                studentManager.printStudentsSortedByScoreAsc();
            } else if (menu == 15) {
                System.out.print("평균 점수를 조회할 등급을 입력하세요(A, B, C, D, F): ");
                String grade = scanner.next();

                studentManager.printAverageScoreByGrade(grade);
            } else if (menu == 16) {
                studentManager.printPassFailStatistics();
            } else if (menu == 17) {
                System.out.print("조회할 목록을 입력하세요(pass/fail): ");
                String status = scanner.next();

                studentManager.printStudentsByPassFail(status);
            } else if (menu == 18) {
                studentManager.printStudentCount();
            } else {
                System.out.println("잘못된 메뉴입니다.");
            }
        }

        scanner.close();
    }
}