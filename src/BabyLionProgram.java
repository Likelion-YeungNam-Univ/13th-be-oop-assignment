import java.util.Scanner;

public class BabyLionProgram {

    public void run(){
        Scanner sc = new Scanner(System.in);
        BabyLionDB db = new BabyLionDB();
        int insert;
        while(true){
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("<<<<선택 메뉴>>>>");
            System.out.println("1. 아기사자 등록하기");
            System.out.println("2. 아기사자 전체 조회하기");
            System.out.println("3. 아기사자 개별 조회하기");
            System.out.println("4. 아기사자 자기소개 수정하기");
            System.out.println("5. 아기사자 성실도 수정하기(+/-)");
            System.out.println("6. 아기사자 정보 삭제하기");
            System.out.println("oth num. 프로그램 종료하기");
            System.out.println("------------------------------------------------------------------------------------");
            insert = sc.nextInt();
            switch(insert){
                case 1:
                    db.add();
                    break;
                case 2:
                    db.findAll();
                    break;
                case 3:
                    db.findOne();
                    break;
                case 4:
                    db.editIntro();
                    break;
                case 5:
                    db.editFame();
                    break;
                case 6:
                    db.delete();
                    break;
                default:
                    return;
            }
        }
    }
}
