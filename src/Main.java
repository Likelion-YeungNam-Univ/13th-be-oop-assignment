import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager();
        boolean run = true;

        System.out.println("--------------------------\n" +
                "*** 아기사자 관리 프로그램 *** \n" +
                "--------------------------");
        System.out.println("1: 아기사자 등록");
        System.out.println("2: 아기사자 삭제");
        System.out.println("3: 아기사자 전체 조회");
        System.out.println("4: 아기사자 개별 조회");
        System.out.println("5: 아기사자 자기소개 수정");
        System.out.println("6: 아기사자 성실도 변경");
        System.out.println("1~6제외한 키: 종료");

        while (run) {
            System.out.print("원하는 작동 번호를 입력하세요: ");
            int option = sc.nextInt();

            switch (option) {
                case 1: manager.register();break;
                case 2: manager.delete();break;
                case 3: manager.allView();break;
                case 4: manager.personView();break;
                case 5: manager.editIntro();break;
                case 6: manager.editScore();break;
                default: System.out.print("종료 !");
                    run = false;
                    break;
            }
            System.out.print("\n계속하시겠습니까?(y/n)");
            String answer = sc.next();
            if (answer.equals("n")) {
                run = false;
            }
        }

    }
}

