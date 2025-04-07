package Implementation;
import Entity.babyLion;
import Interface.babyLionRepository;

import java.util.*;

public class babyLionRepositoryImpl implements babyLionRepository {
    Map<String, babyLion> map = new HashMap<>();

    //아기사자 개별 조회
    @Override
    public void findBabyLion(String studentID) { //개별 조회
        if(!map.containsKey(studentID)) {
            System.out.println("존재하지 않는 아기사자입니다.");
        }
        else {
            babyLion baby;
            baby = map.get(studentID);
            System.out.println(baby);
        }
    }

    //아기사자 전체 조회
    @Override
    public void findAll() { //전체 조회
        if(map.isEmpty()) {
            System.out.println("조회할 아기사자가 없습니다!");
        }

        for(babyLion babies : map.values()) {
            System.out.println(babies);
        }
    }

    public Map<String, babyLion> getMap() {
        return map;
    }
}
