import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private final Scanner scanner;
    private final Random random;

    public NumberGuessingGame() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public void start() {
        int answer = random.nextInt(100) + 1;
        int tryCount = 0;

        System.out.println("==== 숫자 맞히기 게임 ====");
        System.out.println("1부터 100 사이의 숫자를 맞혀보세요.");

        while (true) {
            System.out.print("숫자 입력: ");
            int userNumber = scanner.nextInt();
            tryCount++;

            if (userNumber < answer) {
                System.out.println("더 큰 숫자입니다.");
            } else if (userNumber > answer) {
                System.out.println("더 작은 숫자입니다.");
            } else {
                System.out.println("정답입니다!");
                System.out.println("시도 횟수: " + tryCount + "번");
                break;
            }
        }
    }
}