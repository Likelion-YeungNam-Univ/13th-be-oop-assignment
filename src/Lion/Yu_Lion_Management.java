package Lion;
import java.util.*;
/*
-------------------------------------------------------
🛡 자바 접근 제어자 (Access Modifiers) 정리
-------------------------------------------------------

1. public     ✅ 어디서든 접근 가능 (다른 패키지도 OK)
2. protected  ✅ 같은 패키지 + 상속받은 자식 클래스에서 접근 가능
3. (default)  ✅ 같은 패키지 내에서만 접근 가능 (접근제어자 생략 시)
4. private    ✅ 해당 클래스 내부에서만 접근 가능 (외부 접근 불가)

-------------------------------------------------------
| 제어자     | 같은 클래스 | 같은 패키지 | 자식 클래스 | 전체 접근 |
|------------|-------------|--------------|--------------|-------------|
| public     |     ✅      |     ✅       |     ✅       |     ✅      |
| protected  |     ✅      |     ✅       |     ✅       |     ❌      |
| (default)  |     ✅      |     ✅       |     ❌       |     ❌      |
| private    |     ✅      |     ❌       |     ❌       |     ❌      |
-------------------------------------------------------
💡 팁:
- 외부 노출 필요 시 → public
- 내부 전용 로직 → private
- 같은 패키지 간 협업 → default (생략)
- 상속 시 공유할 메서드 → protected
*/
//관리 시스템 메인 클래스
public class Yu_Lion_Management {
    Scanner sc = new Scanner(System.in);
    Yu_Lion_Repository lion = new Yu_Lion_Repository(); //생성자 따로 만들지 않아서 기본생성자 생성
    void Menu()
    {
        while(true)
        {
            Display();
            int key_num = sc.nextInt();
            if (key_num == 1) {Update_Lion();} //아기사자 등록
            else if (key_num == 2) {getAll_Lion();} //아기사자 전체조회
            else if (key_num == 3) {getById_Lion();} //아기사자 개별조회
            else if (key_num == 4) {updatePr_Lion();} //아기사자 자기소개 수정
            else if (key_num == 5) {updatesincerity_Lion();} //아기사자 성실도 변경
            else if (key_num == 6) {delete_Lion();} //아기사자 삭제
            key_num = 0;
        }
    }

    public void Update_Lion() //아기사자 등록
    {
        sc.nextLine(); //nextint로 인해서 엔터 인식 방지
        System.out.println("아기사자 학번: ");
        String std_id = sc.nextLine();
        System.out.println("아기사자 이름: ");
        String std_name = sc.nextLine();
        System.out.println("자기소개: ");
        String pr = sc.nextLine();
        System.out.println("성실도: ");
        int sincerity = sc.nextInt();
        if(sincerity < 0 || sincerity > 5) //성실도 범위 초과
        {
            while(true)
            {
                System.out.println("성실도를 다시 입력해주세요! ");
                sincerity = sc.nextInt();
                if(sincerity >= 0 && sincerity <= 5)
                    break;
            }
        }
        lion.add_lion(new Yu_Lion(std_id, std_name, pr, sincerity)); //Yu_Lion이 객체라서 new라고 입력을 받는거임 일반 변수라면 new선언 없이 입력받기
        /* 참고용
        studentList.size()	학생 수 확인
        studentList.get(0)	첫 번째 학생 객체 반환
        studentList.get(1).getName() 두 번째 학생의 이름 반환
        studentList.remove(0)	첫 번째 학생 삭제
        for-each 문으로 전체 순회	모든 학생 출력 가능
         */
    }
    public void getAll_Lion()
    {
        //Yu_Lion = 게터세터 클래스
        for(Yu_Lion lion : lion.getAll_Lion()) //Yu_Lion클래스로 생성된 객체 데이터를 불러오기
        {
            System.out.println(lion);
        }
    }
    public void getById_Lion()
    {
        sc.nextLine(); //nextint로 인해서 엔터 인식 방지
        System.out.println("학번을 입력해주세요: ");
        String std_id = sc.nextLine();
        Yu_Lion lion_one = lion.getLionById(std_id);
        System.out.println(lion_one != null ? lion_one : "존재하지 않는 아기사자입니다.");
        /*처음에 학번이 틀릴 경우 리포지토리 getLionById 메서드에서 학생을 찾을 수 없을 경우에
        오류문구 출력을 하고 여기 함수에서 그냥 맞을 때만 이걸 출력하겠지 생각했는데
        그 안에서 널을 반환하니 여기서도 널을 반환하는 문제 발생 그냥 리턴 값만 받고 이 코드에서
        틀림 맞음 여부를 체크해야 겠다.*/
        //System.out.println(lion_one);
        //Yu_Lion lion_one = lion.getLionById(std_id);
    }

    public void updatePr_Lion()
    {
        sc.nextLine(); //nextint로 인해서 엔터 인식 방지
        System.out.println("학번을 입력해주세요: ");
        String std_id = sc.nextLine();
        System.out.println("새로운 자기소개를 입력해주세요: ");
        String pr = sc.nextLine();
        lion.updatePr(std_id, pr); //오류 문구는 리포지토리에서 출력
    }

    public void updatesincerity_Lion()
    {
        sc.nextLine(); //nextint로 인해서 엔터 인식 방지
        System.out.println("학번을 입력해주세요: ");
        String std_id = sc.nextLine();
        System.out.println("성실도 증가 (+) OR 성실도 감소 (-) 입력해주세요");
        String sincerity = sc.nextLine();
        lion.update_sincerity(std_id, sincerity);
    }
    public void delete_Lion()
    {
        sc.nextLine(); //nextint로 인해서 엔터 인식 방지
        System.out.println("삭제하는 아기사자 학번을 입력해주세요: ");
        String std_id = sc.nextLine();
        lion.delete_lion(std_id);
    }

    public void Display()
    {
        System.out.println("멋쟁이 사자처럼 학생관리 프로그램 - Made by SJH");
        System.out.println("1. 아기사자 등록:");
        System.out.println("2. 아기사자 전체조회:");
        System.out.println("3. 아기사자 개별조회:");
        System.out.println("4. 아기사자 자기소개 수정:");
        System.out.println("5. 아기사자 성실도 변경:");
        System.out.println("6. 아기사자 삭제:");
    }
}
