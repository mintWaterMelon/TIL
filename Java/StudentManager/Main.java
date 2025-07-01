import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager(5);

        while (true) {
            System.out.println();
            System.out.println("==== 학생 관리 프로그램 ====");
            System.out.println("1. 학생 추가");
            System.out.println("2. 학생 목록 조회");
            System.out.println("3. 평균 점수 조회");
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
            } else {
                System.out.println("잘못된 메뉴입니다.");
            }
        }

        scanner.close();
    }
}