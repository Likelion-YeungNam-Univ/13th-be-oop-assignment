package Implementation;
import Interface.babyLionService;
import Entity.babyLion;

import java.util.*;

//아기사자 등록, 삭제, 수정
public class babyLionServiceImpl implements babyLionService{
    Map<String, babyLion> map;

    public babyLionServiceImpl(babyLionRepositoryImpl repository) {
        map = repository.getMap();
    }

    /*
        아기사자 등록
    */
    @Override
    public void register(String studentID, String name, String selfIntro, int sincerity) {
        //이미 등록된 아기사자를 조회할 경우
        if(map.containsKey(studentID)) {
            System.out.println("이미 저장된 아기사자입니다!");
        }
        else if(sincerity < 0 || sincerity > 5) {
            System.out.println("성실도는 0~5 사이의 값만 가능합니다!");
        }
        else {
            babyLion baby = new babyLion(name, studentID, selfIntro, sincerity);
            map.put(studentID, baby);
            System.out.println(name + " 🦁아기사자🦁가 정상적으로 등록되었습니다.");
        }
    }
    /*
        아기사자 삭제
    */
    @Override
    public void delete(String studentID) {
        if(!map.containsKey(studentID)) {
            System.out.println("존재하지 않는 아기사자입니다!");
        }
        else {
            map.remove(studentID);
            System.out.println("🦁아기사자🦁가 정상적으로 삭제되었습니다.");
        }
    }

    /*
        아기사자 자기소개 수정
    */
    @Override
    public void updateSelfIntro(String studentID, String selfIntro) {
        if(!map.containsKey(studentID)) {
            System.out.println("존재하지 않는 아기사자입니다!");
        }
        else {
            babyLion baby = map.get(studentID);
            baby.setSelfIntro(selfIntro);
            System.out.println("🦁아기사자🦁의 자기소개가 정상적으로 수정되었습니다.");
        }
    }
    /*
        아기사자 성실도 수정
        - 성실도 증가
        - 성실도 감소
    */
    @Override
    public void increaseSincerity(String studentID) {
        babyLion baby = map.get(studentID);
        int babySincerity = baby.getSincerity();

        if(babySincerity >= 5) {
            System.out.println("아기사자의 성실도가 더 이상 증가할 수 없습니다!");
            return;
        }
        baby.setSincerity(babySincerity+1);
    }

    @Override
    public void decreaseSincerity(String studentID) {
        babyLion baby = map.get(studentID);
        int babySincerity = baby.getSincerity();

        if(babySincerity <= 0) {
            System.out.println("아기사자의 성실도가 더 이상 감소할 수 없습니다!");
            return;
        }
        baby.setSincerity(babySincerity-1);
    }
}
