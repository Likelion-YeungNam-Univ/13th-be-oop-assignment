package BabyLion_Management;
import java.util.*;

//모든 기능을 하나의 클래스로 모으는 클래스, 조회기능을 구현하고 있음
public class BabyLion_Service {
    private Map<String, BabyLion_Info> lions = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    private BabyLion_SearchService searchService = new BabyLion_SearchService(lions, scanner);
    private BabyLion_UpdateService updateService = new BabyLion_UpdateService(searchService, scanner);
    private BabyLion_DeleteService deleteService = new BabyLion_DeleteService(searchService, lions);

    //신규 아기사자 등록
    public void registerInfo() {
        System.out.print("학번 : ");
        String StudentID = scanner.nextLine().trim();
        //학번 공백 허가x
        if (StudentID.isEmpty()){
            System.out.println("학번은 공백일 수 없습니다.");
            return;
        }
        //학번 존재 여부 확인
        if (lions.containsKey(StudentID)) {
            System.out.println("이미 존재하는 학번입니다. 등록 실패.");
            return;
        }

        System.out.print("이름 : ");
        String name = scanner.nextLine().trim();
        //이름 공백 허가x
        if (name.isEmpty()){
            System.out.println("이름은 공백일 수 없습니다.");
        }
        System.out.print("자기소개 : ");
        String selfIntroduction = scanner.nextLine();

        BabyLion_Info newLion = new BabyLion_Info(StudentID, name, selfIntroduction);
        lions.put(StudentID, newLion);

        System.out.println("신규 아기사자 등록 완료!");
        viewAll();
        System.out.println();
    }

    //등록된 아기사자 전부 조회
    public void viewAll() {
        print_info_bar();
        for(BabyLion_Info lion : lions.values()) {
            System.out.println(lion);
        }
    }

    //아기사자 개별 조회. 학번 조회
    public void viewSingle() {
        BabyLion_Info lion = searchService.searchLion();
        if (lion != null) {
            print_info_bar();
            System.out.println(lion);
            System.out.println();
        } else {
            System.out.println("해당 아기사자는 없습니다.");
        }
    }

    public void updateIntroduction() {
        updateService.updateIntroduction();
    }

    public void changeSincerity() {
        updateService.changeSincerity();
    }

    public void deleteInfo() {
        deleteService.deleteInfo();
    }

    //아기사자 출력시 보이는 상단 바를 출력하는 함수
    private void print_info_bar() {
        System.out.printf("%-15s %-10s %-10s %-30s\n", "\uD83D\uDCDA학번", "\uD83D\uDC64이름", "\uD83D\uDCAF성실도", "\uD83D\uDCDD자기소개");
        System.out.println("--------------------------------------------------------------------------------");
    }
}
