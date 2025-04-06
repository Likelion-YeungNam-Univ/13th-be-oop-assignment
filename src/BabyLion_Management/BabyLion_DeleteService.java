package BabyLion_Management;
import java.util.*;

public class BabyLion_DeleteService {
    private BabyLion_SearchService searchService;
    private Map<String, BabyLion_Info> lions;

    public BabyLion_DeleteService(BabyLion_SearchService searchService, Map<String, BabyLion_Info> lions) {
        this.searchService = searchService;
        this.lions = lions;
    }

    //아기사자 정보 삭제
    public void deleteInfo() {
        BabyLion_Info lion = searchService.searchLion();
        if (lion != null) {
            lions.remove(lion.getStudent_id());
            System.out.println("삭제가 완료되었습니다.");
        } else {
            System.out.println("해당 아기사자는 없습니다.");
        }
    }
}
