public class BabyLionList {
    private BabyLion[] lions; //BabyLion을 나타내기위해 클래스명을 타입으로
    private int count;

    public BabyLionList(int size){
        lions = new BabyLion[size];
        count = 0;
    }
    //아기사자 추가
    public void addBLion(BabyLion lion){
        if(lions.length<count) {
            System.out.println("용량초과");
        }
        lions[count++] = lion;
        System.out.println("아기사자가 등록되었습니다.");

    }
    //아기사자 전체조회
    public void allBabyLion(){
        if(count == 0){
            System.out.println("등록된 아기사자가 없습니다.");
        }
        for(int i=0; i<count; i++){
            System.out.println(lions[i]);
        }
    }
    //아기사자 개별조회(학번으로)
    public BabyLion findStdNum(int std_Num){
        for(int i = 0; i < count; i++){
            if(lions[i].getStd_num() == std_Num)
                return lions[i];
        }
        return null;
    }
    //아기사자 자기소개 수정
    public String updateIntroduce(int std_Num,String udIntroduce){
        for(int i=0;i<count;i++){
            if(lions[i].getStd_num() == std_Num){
                lions[i].setIntroduce(udIntroduce);
               return "수정완료!";
            }
        }return "해당학번 존재x";
    }
    //아기사자 삭제 배열 앞당기기로 덮어쓰는 방식으로 삭제
    public void removeBLion(int std_Num){
        for(int i=0; i<count; i++){
            if(lions[i].getStd_num() == std_Num){
                for(int j= i; j<count-1; j++){
                    lions[j] = lions[j+1];
                }
                lions[--count] = null;
                System.out.println("아기사자 삭제완료!");
                return; //해당라인에서 메소드 종료위함
            }
        }
        System.out.println("해당학번 존재X");
    }
    //성실도 + - 메서드
    public String increaseNice(int studentId) {
        for (int i = 0; i < count; i++) {
            if (lions[i].getStd_num() == studentId) {
                if (lions[i].getMuch_Nice() < 5) {
                    lions[i].setMuch_Nice(lions[i].getMuch_Nice() + 1);
                    return "성실도 1 증가!";
                } else {
                    return "이미 최대치입니다 (5)";
                }
            }
        }
        return "해당 학번 없음";
    }

    public String decreaseNice(int studentId) {
        for (int i = 0; i < count; i++) {
            if (lions[i].getStd_num() == studentId) {
                if (lions[i].getMuch_Nice() > 0) {
                    lions[i].setMuch_Nice(lions[i].getMuch_Nice() - 1);
                    return "성실도 1 감소";
                } else {
                    return "이미 0점입니다";
                }
            }
        }
        return "해당 학번 없음";
    }
}