package BabyLion_Management;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BabyLion_Manager {
    private BabyLion_Service service = new BabyLion_Service();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("<< 아기사자 관리 프로그램 >>");
            System.out.println("1. 아기사자 등록");
            System.out.println("2. 아기사자 전체 조회");
            System.out.println("3. 아기사자 개별 조회");
            System.out.println("4. 아기사자 자기소개 수정");
            System.out.println("5. 아기사자 성실도 변경(-/+)");
            System.out.println("6. 아기사자 삭제");
            System.out.println("7. 종료");
            System.out.print(">> ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("잘못된 입력입니다.");
                scanner.nextLine();
                continue;
            }
            switch (choice) {
                case 1 -> service.registerInfo();
                case 2 -> service.viewAll();
                case 3 -> service.viewSingle();
                case 4 -> service.updateIntroduction();
                case 5 -> service.changeSincerity();
                case 6 -> service.deleteInfo();
                case 7 -> {
                    System.out.println("프로그램 종료");
                    scanner.close();
                    return;
                }
                default -> System.out.println("1~7사이의 정수만 입력해주세요");
            }
        }
    }
}
