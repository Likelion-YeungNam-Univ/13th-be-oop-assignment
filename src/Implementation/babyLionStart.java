package Implementation;

import java.io.*;
import java.util.*;

public class babyLionStart {
    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        babyLionRepositoryImpl repository = new babyLionRepositoryImpl();
        babyLionServiceImpl service = new babyLionServiceImpl(repository);

        StringTokenizer st;

        //menu출력
        while(true) {
            printMenu();
            int number;
            try {
                number = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요!");
                continue;
            }

            //아기사자 등록
            if (number == 1) {
                while (true) {
                    System.out.print("이름, 학번, 성실도, 자기소개를 입력하세요 (띄어쓰기로 구분) : ");
                    String[] arr = br.readLine().split(" ", 4);

                    if (arr.length != 4) {
                        System.out.println("이름, 학번, 성실도, 자기소개를 정확히 입력하세요!");
                        continue;
                    }

                    String name = arr[0];
                    String studentID = arr[1];
                    int sincerity;

                    try {
                        sincerity = Integer.parseInt(arr[2]);

                        if (sincerity < 0 || sincerity > 5) {
                            System.out.println("성실도는 0~5 사이의 숫자만 가능합니다!");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("성실도는 숫자로 입력해주세요!");
                        continue;
                    }

                    String selfIntro = arr[3];

                    service.register(studentID, name, selfIntro, sincerity);
                    break;
                }

            }

            //아기사자 전체 조회
            else if(number == 2) {
                repository.findAll();
            }

            //아기사자 개별 조회
            else if(number == 3) {
                System.out.print("조회하고자 하는 아기사자의 학번을 입력하세요 : ");
                String studentID = br.readLine();

                repository.findBabyLion(studentID);
            }

            //아기사자 자기소개 수정
            else if(number == 4) {
                while(true) {
                    System.out.print("수정하고자 하는 아기사자의 학번과 자기소개를 입력하세요 : ");
                    String[] arr = br.readLine().split(" ", 2);

                    if(arr.length != 2) {
                        System.out.println("아기사자의 학번과 자기소개를 정확히 입력하세요!");
                        continue;
                    }

                    String studentID = arr[0];
                    String selfIntro = arr[1];

                    service.updateSelfIntro(studentID, selfIntro);
                    break;
                }
            }

            //아기사자 성실도 수정
            else if(number == 5) {
                while(true) {
                    System.out.print("수정하고자 하는 아기사자의 학번을 입력하세요 : ");
                    String studentID = br.readLine();
                    System.out.print("성실도 증가 or 감소 : ");
                    String value = br.readLine();

                    if(value.equals("증가")) service.increaseSincerity(studentID);
                    else if(value.equals("감소")) service.decreaseSincerity(studentID);
                    else {
                        System.out.println("증가, 감소를 정확히 입력하세요.");
                        continue;
                    }
                    break;
                }
            }

            //아기사자 삭제
            else if(number == 6) {
                System.out.println("삭제하고자 하는 아기사자의 학번을 입력하세요 : ");
                String studentID = br.readLine();
                service.delete(studentID);
            }

            else if(number == 7) {
                break;
            }

            else {
                System.out.println("1~6까지의 범위만 선택할 수 있습니다.");
            }
        }

    }

    public void printMenu() {
        System.out.print(
                "=============================\n" +
                        "\t🦁아기사자 관리 프로그램🦁\n" +
                        "=============================\n\n" +

                        "① 아기사자 등록\n" +
                        "② 아기사자 전체 조회\n" +
                        "③ 아기사자 개별 조회\n" +
                        "④ 아기사자 자기소개 수정\n" +
                        "⑤ 아기사자 성실도 수정(+/-)\n" +
                        "⑥ 아기사자 삭제\n" +
                        "⑦ 종료\n" +
                        "=============================\n" +
                        "선택 : "
        );
    }
}
