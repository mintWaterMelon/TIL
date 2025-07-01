import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("==== Java 계산기 ====");
            System.out.println("1. 더하기");
            System.out.println("2. 빼기");
            System.out.println("3. 곱하기");
            System.out.println("4. 나누기");
            System.out.println("0. 종료");
            System.out.print("메뉴를 선택하세요: ");

            int menu = scanner.nextInt();

            if (menu == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            System.out.print("첫 번째 숫자: ");
            int num1 = scanner.nextInt();

            System.out.print("두 번째 숫자: ");
            int num2 = scanner.nextInt();

            try {
                if (menu == 1) {
                    int result = calculator.add(num1, num2);
                    System.out.println("결과: " + result);
                } else if (menu == 2) {
                    int result = calculator.subtract(num1, num2);
                    System.out.println("결과: " + result);
                } else if (menu == 3) {
                    int result = calculator.multiply(num1, num2);
                    System.out.println("결과: " + result);
                } else if (menu == 4) {
                    double result = calculator.divide(num1, num2);
                    System.out.println("결과: " + result);
                } else {
                    System.out.println("잘못된 메뉴입니다.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println();
        }

        scanner.close();
    }
}