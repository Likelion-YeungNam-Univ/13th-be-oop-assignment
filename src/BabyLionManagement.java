import java.util.Scanner;

class BabyLionManagement {
    private BabyLionRepository babyLionRepository = new BabyLionRepository();
    Scanner input = new Scanner(System.in);


    public void run() {
        while (true) {
            System.out.println("=============아기사자 관리 프로그램=============");
            System.out.println("1. 아기사자 등록                             ");
            System.out.println("2. 아기사자 전체 조회                         ");
            System.out.println("3. 아기사자 개별 조회                         ");
            System.out.println("4. 아기사자 자기소개 수정                      ");
            System.out.println("5. 아기사자 성실도 변경 (+/-)                  ");
            System.out.println("6. 아기사자 삭제                             ");
            System.out.println("==========================================");
            System.out.print("선택 : ");
            int option = input.nextInt();
            input.nextLine();
            if (option == 1) {
                inputAdd();
            }
            else if (option == 2) {
                babyLionRepository.entireView();
            }
            else if (option == 3) {
                inputIndiv();
            }
            else if (option == 4) {
                inputIntro();
            }
            else if (option == 5) {
                inputSincerity();
            }
            else if (option == 6) {
                inputDelete();
            }
            else {
                System.out.println("1 - 6의 값만 입력하세요.");
            }

        }
    }
    public void inputAdd() {
        System.out.print("학번 : ");
        String studentNum = input.nextLine();
        System.out.print("이름 : ");
        String studentName = input.nextLine();
        System.out.print("자기소개 : ");
        String studentIntro = input.nextLine();

        BabyLion babyLion = new BabyLion(studentNum, studentName, studentIntro);
        babyLionRepository.addBabyLion(babyLion);
    }
    public void inputIndiv() {
        System.out.print("조회하고싶은 아기사자의 학번을 입력하세요 : ");
        String studentNum = input.nextLine();
        babyLionRepository.indivView(studentNum);
    }
    public void inputIntro() {
        System.out.print("자기소개를 수정하고싶은 아기사자의 학번을 입력하세요 : ");
        String studentNum = input.nextLine();
        System.out.print("수정하고 싶은 자기소개로 입력하세요 : ");
        String studentIntro = input.nextLine();
        babyLionRepository.changeIntro(studentNum, studentIntro);
    }
    public void inputSincerity() {
        System.out.print("성실도를 +/- 할 아기사자의 학번을 입력하세요 : ");
        String studentNum = input.nextLine();
        System.out.println("성실도(+) -> 1");
        System.out.println("성실도(-) -> 2");
        int optionSincerity = input.nextInt();
        if (optionSincerity == 1) {
            babyLionRepository.addSincerity(studentNum);
        }
        else if (optionSincerity == 2) {
            babyLionRepository.subSincerity(studentNum);
        }
        else {
            System.out.println("1 또는 2 만 입력하세요.");
        }
    }
    public void inputDelete() {
        System.out.print("삭제하고싶은 아기사자의 학번을 입력하세요 : ");
        String studentNum = input.nextLine();
        babyLionRepository.deleteLion(studentNum);
    }


}
