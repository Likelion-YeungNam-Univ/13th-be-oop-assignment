import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    String sign;
    int n;

    List<Person> lionList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    //1. 아기사자 등록 -> 정보 입력
    public void register(){
        System.out.print("🦁학번: ");
        int studentId = sc.nextInt();

        System.out.print("🦁이름: ");
        String name = sc.next();

        System.out.print("🦁자기소개: ");
        String introduction = sc.next();

        System.out.print("🦁성실도: 0점");

        Person lion = new Person(studentId,name,introduction,0);
        lionList.add(lion);
    }
    //2. 아기사자 삭제
    public void delete(){
        System.out.print("🦁삭제할 아기사자의 학번: ");
        int studentId = sc.nextInt();

        for(int i = 0; i<lionList.size(); i++){
            if(lionList.get(i).getStudentId() == studentId){
                lionList.remove(i);
            }
        }
    }

    //3. 아기사자 전체 조회
    public void allView(){
        if(lionList.size() == 0){
            System.out.print("등록된 아기사자가 없습니다.");
        }
        else{
            for(int i = 0; i<lionList.size(); i++){
                lionList.get(i).printInfo();
            }
        }
    }
    //4. 아기사자 개별 조회
    public void personView(){
        System.out.print("조회할 아기사자의 학번: ");
        int studentId = sc.nextInt();

        if(lionList.size() == 0){
            System.out.print("등록된 아기사자가 없습니다.");
        }
        else{
            for(int i = 0; i<lionList.size(); i++){
                if(lionList.get(i).getStudentId() == studentId){
                    lionList.get(i).printInfo();
                }
                else{
                    System.out.printf(studentId+"아기사자가 없습니다.");
                }
            }
        }
    }

    //5. 아기사자 자기소개 수정
    public void editIntro(){
        System.out.print("수정할 아기사자의 학번: ");
        int studentId = sc.nextInt();

        if(lionList.size() == 0){
            System.out.print("등록된 아기사자가 없습니다.");
        }
        else{
            for(int i = 0; i<lionList.size(); i++){
                if(lionList.get(i).getStudentId() == studentId){
                    System.out.print("🦁기존 자기소개: ");
                    System.out.print(lionList.get(i).getIntroduction());
                    System.out.print("\n수정한 자기소개 입력:");
                    String introduction = sc.next();
                    lionList.get(i).setIntroduction(introduction);
                    System.out.print("완료🦁");
                }
                else{
                    System.out.printf(studentId+"아기사자가 없습니다.");
                }
            }
        }

    }
    //6. 아기사자 성실도 변경
    public void editScore(){
        System.out.print("성실도 변경할 아기사자의 학번: ");
        int studentId = sc.nextInt();

        if(lionList.size() == 0){
            System.out.print("등록된 아기사자가 없습니다.");
        }
        else{
            for(int i = 0; i<lionList.size(); i++){
                if(lionList.get(i).getStudentId() == studentId){
                    System.out.print("성실도 변경(+/-): ");
                    String sign = sc.next();
                    System.out.print("몇 점?: ");
                    int n = sc.nextInt();

                    if(sign.equals("+")){
                        lionList.get(i).setScore(lionList.get(i).getScore()+n);
                    }
                    else if(sign.equals("-")){
                        lionList.get(i).setScore(lionList.get(i).getScore()-n);
                    }
                    else if(n>10||n<0){
                        System.out.print("잘못된 입력입니다.");
                    }
                }
                else{
                    System.out.printf(studentId+"아기사자가 없습니다.");
                }
            }
        }

    }






}
