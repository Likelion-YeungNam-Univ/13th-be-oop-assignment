import java.util.ArrayList;
import java.util.Scanner;

public class Manage {
    /*
        List 종류
        ArrayList : 인덱스로 객체를 관리
                    크기를 동적으로 관리
        Vector : 동기화된 메서드 구성 (멀티 스레드 환경에서 안전하게 객체를 추가, 삭제 가능)
                 동기화되어 있어 ArrayList보다 느림
                 trade off관계 : 속도, 안전
        LinkedList : 인접 참조를 통해 체인처럼 관리

        # ArrayList를 사용하는 이유
        원하는 아기사자를 찾은후 그 인덱스를 사용하기 위해
        LinkedList로 사용하면 함수를 사용할때마다 원하는 아기사자를 계속 찾아야 함

        학번이 겹쳤을때 수정이 되도록 수정
     */

    /*
        # 각 함수에 Scanner 생성X, 객체 하나만 생성 왜?
        Scanner 입력스트림 달라서 상관없음
        여러 번 사용해도 큰 문제 X
    */

    /*
        # 문자열 입력 받을때 nextLine 과 next 차이
        nextLine : 개행 문자 가져옴
        next : 공백 전까지의 단어 / 개행 문자 가져오지 않음
     */

    ArrayList<Repository> babyLions = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void register(){
        Repository babyLion = new Repository();

        System.out.print("학번 입력 : ");
        try {
            babyLion.setStudentId(scanner.nextInt());
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("error 학번에 숫자 입력");
            scanner.nextLine();
            return;
        }

        System.out.print("이름 입력 : ");
        babyLion.setStudentName(scanner.next());

        scanner.nextLine(); //next에서 생긴 줄바꿈(버퍼) 없앰

        System.out.print("자기소개 입력 : ");
        babyLion.setIntroduction(scanner.nextLine());

        babyLions.add(babyLion);
    }

    public void allInquiry(){
        for (int i = 0; i < babyLions.size(); i++){
            Inquiry(babyLions.get(i));
        }
//        for (Repository babyLion : babyLions)
//            Inquiry(babyLion);
    }

    public void individualInquiry(){
        System.out.print("조회하고 싶은 아기사자 학번 입력 : ");
        int num = scanner.nextInt();
        for (int i = 0; i < babyLions.size(); i++){
            if (babyLions.get(i).getStudentId() == num){
                Inquiry(babyLions.get(i));
                return;
            }
        }
        System.out.println("학번" + num + " 아기사자가 없습니다");
    }

    public void Inquiry(Repository babyLion){
        System.out.println("학번 : " + babyLion.getStudentId() + "  이름 : " + babyLion.getStudentName() + "  자기소개 : " + babyLion.getIntroduction() + "  성실도 : " + babyLion.getFaithful());
    }

    public void modifyIntroduction(){
        System.out.print("자기소개 수정하고 싶은 아기사자 학번 입력 : ");
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < babyLions.size(); i++){
            if (babyLions.get(i).getStudentId() == num){
                System.out.print("자기소개 수정 내용 입력 : ");
                babyLions.get(i).setIntroduction(scanner.nextLine());
                return;
            }
        }
        System.out.println("학번" + num + " 아기사자가 없습니다");
    }

    public void modifyFaithful() {
        System.out.print("성실도 수정하고 싶은 아기사자 학번 입력 : ");
        int num = scanner.nextInt();
        for (int i = 0; i < babyLions.size(); i++){
            if (babyLions.get(i).getStudentId() == num){
                if (babyLions.get(i).getFaithful() > 5 || babyLions.get(i).getFaithful() < 0){
                    System.out.println("성실도는 0~5 범위 내에서만 가능");
                    return;
                }
                System.out.print("+ 또는 - 입력 : ");
                String score = scanner.next();
                babyLions.get(i).setFaithful(score);
                return;
            }
        }
        System.out.println("학번" + num + " 아기사자가 없습니다");
    }

    public void delete(){
        System.out.print("삭제하고 싶은 아기사자 학번 입력 : ");
        int num = scanner.nextInt();
        for (int i = 0; i < babyLions.size(); i++){
            if (babyLions.get(i).getStudentId() == num){
                babyLions.remove(i);
                return;
            }
        }
        System.out.println("학번" + num + " 아기사자가 없습니다");
    }
}
