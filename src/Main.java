import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        BabyLionList helper = new BabyLionList(100); //최대인원 설정
        int select;
        while(true){
            System.out.println("=======아기사자들=======");
            System.out.println("1. 아기사자등록");
            System.out.println("2. 아기사자 전체조회");
            System.out.println("3. 아기사자 개별조회(학번)");
            System.out.println("4. 아기사자 자기소개 수정");
            System.out.println("5. 아기사자 성실도 변경");
            System.out.println("6. 아기사자 삭제");
            System.out.println("7. 종료");
            System.out.println("메뉴선택 :");
            select = scanner.nextInt();
            scanner.nextLine(); //버퍼에 남은 엔터 제거

            if(select == 1){
                System.out.println("이름 :");
                String name = scanner.nextLine();
                System.out.println("학번: ");
                int std_num = scanner.nextInt();
                scanner.nextLine();
                System.out.println("자기소개: ");
                String introduce = scanner.nextLine();
                System.out.println("성실도 (0~5): ");
                int much_nice = scanner.nextInt();
                scanner.nextLine();
                helper.addBLion(new BabyLion(name,std_num,introduce,much_nice));
                System.out.println("아기사자 추가완료!");
            }
            if(select == 2){
                System.out.println("아기사자 전체조회");
                helper.allBabyLion();

            }
            if(select == 3){
                System.out.println("아기사자 개별조회");
                System.out.println("학번 입력 :");
                int a = scanner.nextInt();
                scanner.nextLine();
                System.out.println(helper.findStdNum(a));
            }
            if(select == 4){
                System.out.println("아기사자 자기소개 수정하기");
                System.out.println("학번 입력 :");
                int b = scanner.nextInt();
                scanner.nextLine();
                String c = scanner.nextLine();
                System.out.println("수정할 내용 : ");

                System.out.println(helper.updateIntroduce(b,c));
            }
            if(select == 5){
                System.out.println("학번 입력: ");
                int d = scanner.nextInt();
                scanner.nextLine();
                System.out.println("1. 성실도 +1");
                System.out.println("2. 성실도 -1");
                System.out.print("선택: ");
                int e = scanner.nextInt();
                scanner.nextLine();

                String result;
                if (e == 1) {
                    result = helper.increaseNice(d);
                } else if (e == 2) {
                    result = helper.decreaseNice(d);
                } else {
                    result = "잘못된 선택입니다.";
                }

                System.out.println(result);
            }
            if(select == 6){
                System.out.println("학번 입력 : ");
                int f = scanner.nextInt();
                scanner.nextLine();
                helper.removeBLion(f);

            }
            if(select == 7){
                System.out.println("종료하겠습니다.");
                break;
            }

        }

    }
}
