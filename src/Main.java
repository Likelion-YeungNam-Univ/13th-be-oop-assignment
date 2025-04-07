import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        Manage manage = new Manage();

        int num;
        while (true){
            menu.print_menu();
            System.out.print("원하는 기능 선택 : ");
            num = scanner.nextInt();
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
                default:
            }
            System.out.println();
        }
    }
}