package BabyLion_Management;
import java.util.*;

//검색관련 클래스
public class BabyLion_SearchService {
    private Map<String, BabyLion_Info> lions;
    private Scanner scanner;

    public BabyLion_SearchService(Map<String, BabyLion_Info> lions, Scanner scanner) {
        this.lions = lions;
        this.scanner = scanner;
    }

    //학번으로 아기사자 검색, 해당 학번에 맞는 아기사자 객체를 반환
    public BabyLion_Info searchLion() {
        System.out.print("학번을 입력하세요 : ");
        String searchID = scanner.nextLine();
        return lions.get(searchID);
    }
}
