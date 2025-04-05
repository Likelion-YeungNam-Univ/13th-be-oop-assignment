package Lion;

import java.util.*;

public class Yu_Lion_Repository {
    private static Map<String, Yu_Lion> lion_data= new HashMap<>();
    //Yu_Lion클래스에서 데이터를 가지고 온다
    //여기서 자료형 기준이 가장 중요하게 다루는 키 기준으로 한다.
    //궁금한점이 중요하게 생각하는 키 기준이 여기에서는 학번을 기준으로 검색을 하니 그 자료형 String을 기준인건가...?

    public void add_lion(Yu_Lion yu_lion) { //Yu_Lion클래스 타입의 변수를 입력
        if(lion_data.containsKey(yu_lion.getStd_id()))//key와 value존재
        {
            System.out.println("이미 존재하는 아기사자입니다.");
            return;
        }
        lion_data.put(yu_lion.getStd_id(),yu_lion); //학번을 key값으로 받아서 학생데이터 value를 저장
        System.out.println("아기사자 등록 성공!");
    }
    public Yu_Lion getLionById(String std_id)
    {
        Yu_Lion yu_lion = lion_data.get(std_id);
        /*if(yu_lion == null) //바보...
        {
            System.out.println("존재하지 않는 아기사자입니다.");
            return null;
        }*/
        return lion_data.get(std_id);
    }

    public List<Yu_Lion> getAll_Lion(){
        return new ArrayList<>(lion_data.values());
    }

    public void updatePr(String std_id, String pr){
        Yu_Lion yu_lion = lion_data.get(std_id);
        if(yu_lion == null)
        {
            System.out.println("존재하지 않는 아기사자입니다.-pr");
            return;
        }
        yu_lion.setPr(pr);
    }

    public void update_sincerity(String std_id, String ch_sign){
        Yu_Lion yu_lion = lion_data.get(std_id);
        if(yu_lion == null)
        {
            System.out.println("존재하지 않는 아기사자입니다.-sincerity");
            return;
        }
        if(yu_lion.getSincerity()>= 0 && yu_lion.getSincerity()<=5) {
            if (ch_sign.equals("+")) {
                yu_lion.setSincerity(yu_lion.getSincerity() + 1);
                if(yu_lion.getSincerity()>5)
                {
                    System.out.println("성실도 설정범위초과!!!");
                    yu_lion.setSincerity(5);
                    return;
                }
                System.out.println("변경된 성실도: " + yu_lion.getSincerity());
            }
            if (ch_sign.equals("-")) {
                yu_lion.setSincerity(yu_lion.getSincerity() - 1);
                if(yu_lion.getSincerity()<0)
                {
                    System.out.println("성실도 설정범위미만!!!");
                    yu_lion.setSincerity(0);
                    return;
                }
                System.out.println("변경된 성실도: " + yu_lion.getSincerity());
            }
        }
    }

    public void delete_lion(String std_id)
    {
        if(lion_data.remove(std_id) == null)
        {
            System.out.println("존재하지 않는 아기사자입니다. = delete");
            return;
        }
        System.out.println("삭제 성공 = delete");
    }

}
