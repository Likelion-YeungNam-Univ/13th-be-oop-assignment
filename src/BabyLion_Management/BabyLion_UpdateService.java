package BabyLion_Management;
import java.util.*;

//아기사자 정보 수정 클래스, 자기소개 & 성실도 업데이트
public class BabyLion_UpdateService {
    private BabyLion_SearchService searchService;
    private Scanner scanner;

    public BabyLion_UpdateService(BabyLion_SearchService searchService, Scanner scanner) {
        this.searchService = searchService;
        this.scanner = scanner;
    }

    //아기사자 자기소개 수정
    public void updateIntroduction() {
        BabyLion_Info lion = searchService.searchLion();
        if (lion != null) {
            System.out.println("<<기존 자기소개>>");
            System.out.println(lion.getSelf_introduction());

            System.out.println("수정할 자기소개 정볼를 입력하세요");
            System.out.print(">> ");
            String updateIntro = scanner.nextLine();
            lion.setSelf_introduction(updateIntro);
            System.out.println();

            System.out.println("<<수정된 정보>>");
            System.out.println(lion.getSelf_introduction());
        } else {
            System.out.println("해당 아기사자는 없습니다.");
        }
    }

    //아기사자의 성실도 변경
    public void changeSincerity() {
        BabyLion_Info lion = searchService.searchLion();
        if (lion != null) {
            while(true){
                System.out.println("<<선택한 아기사자 정보>>");
                System.out.println(lion);

                System.out.println("성실도 변경 ( + / - ) (종료:exit)");
                System.out.print(">> ");
                String op = scanner.nextLine();
                if(op.equals("+")) {
                    int score = lion.getSincerity_score() + 1;
                    if (score > 5) {
                        lion.setSincerity_score(5);
                        System.out.println("5보다 더 클수는 없습니다.");
                        continue;
                    }
                    lion.setSincerity_score(score);
                }
                else if(op.equals("-")) {
                    int score = lion.getSincerity_score() - 1;
                    if (score < 0) {
                        lion.setSincerity_score(0);
                        System.out.println("0보다 더 작을 수는 없습니다.");
                        continue;
                    }
                    lion.setSincerity_score(score);
                }
                else if(op.equals("exit")) break;
                else
                    System.out.println("잘못된 입력입니다.");
            }
        } else {
            System.out.println("해당 아기사자는 없습니다.");
        }
    }
}
