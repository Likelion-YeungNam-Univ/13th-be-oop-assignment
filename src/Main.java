import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        Manage manage = new Manage();

        int num = 0;
        while (true){
            menu.print_menu();
            System.out.print("원하는 기능 선택 : ");
            try {
                num = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("error 숫자 입력");
                System.out.println();
                scanner.nextLine();
                continue;
            }
            switch(num){
                case 1:
                    manage.register();
                    break;
                case 2:
                    manage.allInquiry();
                    break;
                case 3:
                    manage.individualInquiry();
                    break;
                case 4:
                    manage.modifyIntroduction();
                    break;
                case 5:
                    manage.modifyFaithful();
                    break;
                case 6:
                    manage.delete();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("잘못 입력");
            }
            System.out.println();
        }
    }
}