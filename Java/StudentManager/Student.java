public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        setScore(score);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("점수는 0점 이상 100점 이하만 가능합니다.");
        }

        this.score = score;
    }

    public void printInfo() {
        System.out.println("이름: " + name + ", 점수: " + score);
    }
}