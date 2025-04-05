import java.util.ArrayList;
import java.util.Scanner;

public class BabyLionDB {
    private ArrayList<BabyLion> data;
    private Scanner sc;

    BabyLionDB(){
        data = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void add(){
        System.out.print("학번을 입력하세요 : ");
        Long id = sc.nextLong();
        sc.nextLine();

        System.out.print("이름을 입력하세요 : ");
        String name = sc.nextLine();

        for(BabyLion bls : data) if(bls.getId().equals(id) || bls.getName().equals(name)){
            System.out.println("학번이나 이름이 중복되었습니다.");
            return;
        }

        System.out.print("자기소개를 간략히 입력하세요 : ");
        String introduce = sc.nextLine();

        System.out.println("초기 성실도는 0으로 시작합니다.");
        data.add(new BabyLion(id, name, introduce, 0));
    }

    public BabyLion findById(){
        BabyLion bl = null;
        System.out.print("학번을 입력하세요 : ");
        Long id = sc.nextLong();
        sc.nextLine();
        for(BabyLion bls : data) if(bls.getId().equals(id)){
            bl = bls;
            break;
        }
        if(bl == null) System.out.println("조회된 데이터가 없습니다.");
        return bl;
    }

    public BabyLion findByName(){
        BabyLion bl = null;
        System.out.print("이름을 입력하세요 : ");
        String name = sc.nextLine();
        for(BabyLion bls : data) if(bls.getName().equals(name)){
            bl = bls;
            break;
        }
        if(bl == null) System.out.println("조회된 데이터가 없습니다.");
        return bl;
    }

    public BabyLion selectFindMethod(){
        BabyLion bl;
        System.out.println("1. 학번 탐색\n2. 이름 탐색\noth. 뒤로가기\n>> ");
        int select = sc.nextInt();
        sc.nextLine();
        if(select == 1) bl = findById();
        else if(select == 2) bl = findByName();
        else bl = null;
        return bl;
    }

    public void findAll(){
        if(data.isEmpty()) System.out.println("아기사자의 데이터가 없습니다.");
        else for(BabyLion bls : data) System.out.println(bls.toString());
    }

    public void findOne(){
        BabyLion bl = selectFindMethod();
        if(bl == null) return;
        System.out.println(bl.toString());
    }

    public void editIntro(){
        String change;
        BabyLion bl = selectFindMethod();
        if(bl == null) return;

        System.out.print("바꿀 자기소개 내용\n>> ");
        change = sc.nextLine();
        bl.setIntroduce(change);
        System.out.println("반영된 정보 확인\n" + bl.toString());
    }

    public void editFame(){
        BabyLion bl = selectFindMethod();
        if(bl == null) return;
        int select;
        while(true){
            Integer temp = bl.getFame();
            System.out.println("현재 점수 : " + bl.getFame());
            System.out.println("1. 가점\n2. 감점\noth. 나가기\n(1점단위이며 0<=x<=5 범위 내 허용) : ");
            select = sc.nextInt();
            sc.nextLine();
            if(select == 1) temp++;
            else if(select == 2) temp--;
            else return;

            if(!(temp>=0 && temp<=5))
                System.out.println("점수의 범위를 벗어났습니다. 반영할 수 없습니다.");
            else
                bl.setFame(temp);
        }
    }

    public void delete(){
        BabyLion bl = selectFindMethod();
        if(bl == null) return;
        data.remove(bl);
        System.out.println("삭제하였습니다.");
    }
}
