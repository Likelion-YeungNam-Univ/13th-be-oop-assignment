import Implementation.babyLionStart;

public class Main {
    public static void main(String[] args) {
        try {
            babyLionStart program = new babyLionStart();
            program.run();
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
        }
    }
}