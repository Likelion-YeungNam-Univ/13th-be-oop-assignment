import java.util.HashMap;
import java.util.Map;

public class BabyLionRepository {
    private Map<String, BabyLion> BabyLions = new HashMap<>();

    public void addBabyLion(BabyLion babylion) { // 아기사자 등록
        String key = babylion.getStudentNumber(); // 학번을 key 변수로 등록

        if (BabyLions.containsKey(key)) { // 예외처리
            System.out.println("중복입니다.");
        }
        else {
            BabyLions.put(key, babylion);
            System.out.println("아기사자가 등록되었습니다.");
        }
    }

    public void entireView() { // 아기사자 전체 조회
        if (BabyLions.isEmpty()) { // 예외처리
            System.out.println("조회할 아기사자가 없습니다.");
        }
        else {
            for (BabyLion babyLion : BabyLions.values()) {
                System.out.println(babyLion);
            }
        }
    }

    public void indivView(String studentNumber) { // 아기사자 개별 조회
        String key = studentNumber; // 학번을 key 변수로 등록

        if (!BabyLions.containsKey(key)) { // 예외처리
            System.out.println("입력한 학번에 맞는 아기사자가 존재하지 않습니다.");
        }
        else {
            BabyLion babyLionValue = BabyLions.get(key);
            System.out.println(babyLionValue);
        }
    }

    public void changeIntro(String studentNum , String changeValue) { // 아기사자 자기소개 수정
        if (!BabyLions.containsKey(studentNum)) { // 예외처리
            System.out.println("입력한 학번에 맞는 아기사자가 존재하지 않습니다.");
        }
        else {
            BabyLion changeLion = BabyLions.get(studentNum);
            changeLion.setStudentIntro(changeValue);
            System.out.println("학번 : " + studentNum + " 아기사자의 자기소개가 수정되었습니다.");
        }
    }

    public void addSincerity(String studentNum) { // 성실도 증가
        if (!BabyLions.containsKey(studentNum)) { // 예외처리
            System.out.println("입력한 학번에 맞는 아기사자가 존재하지 않습니다.");
        }
        else {
            BabyLion changeLion = BabyLions.get(studentNum);
            int currentSincerity = changeLion.getSincerity();

            if (currentSincerity == 5) { // 예외처리
                System.out.println("현재 성실도는 5로 더 이상 올릴 수 없습니다.");
            }
            else {
                int finalSincerity = currentSincerity + 1;
                changeLion.setSincerity(finalSincerity);
                System.out.println("학번 : " + studentNum + " 아기사자의 성실도가 +1 되었습니다.");
            }
        }
    }

    public void subSincerity(String studentNum) { // 성실도 감소
        if (!BabyLions.containsKey(studentNum)) { // 예외처리
            System.out.println("입력한 학번에 맞는 아기사자가 존재하지 않습니다.");
        }
        else {
            BabyLion changeLion = BabyLions.get(studentNum);
            int currentSincerity = changeLion.getSincerity();

            if (currentSincerity == 0) { // 예외처리
                System.out.println("현재 성실도는 0으로 더 이상 떨어뜨릴 수 없습니다.");
            }
            else {
                int finalSincerity = currentSincerity - 1;
                changeLion.setSincerity(finalSincerity);
                System.out.println("학번 : " + studentNum + " 아기사자의 성실도가 -1 되었습니다.");
            }
        }
    }

    public void deleteLion(String studentNum) { // 아기사자 삭제
        if (!BabyLions.containsKey(studentNum)) { // 예외처리
            System.out.println("입력한 학번에 맞는 아기사자가 존재하지 않습니다.");
        }
        else {
            BabyLions.remove(studentNum);
            System.out.println("아기사자가 삭제되었습니다.");
        }
    }
}
