public class BabyLion {
    private String name; //private로 보호
    private int std_num;
    private String introduce;
    private int much_Nice; //성실도


    public BabyLion(String name, int std_num, String introduce, int much_Nice){
        this.name = name;
        this.std_num = std_num;
        this.introduce = introduce;
        this.much_Nice = much_Nice;
    }
    //private + getter로 보호
    public String getName(){
        return name;
    }
    public int getStd_num(){
        return std_num;
    }
    public String getIntroduce(){
        return introduce;
    }
    public int getMuch_Nice(){
        return much_Nice;
    }
    public String setIntroduce(String introduce){
        this.introduce = introduce;
        return introduce;
    }
    public int setMuch_Nice(int much_Nice) {
        this.much_Nice = much_Nice;
        return much_Nice;
    }
    //toString 오버라이딩 통해 Main에서 제대로 출력받기
    @Override
    public String toString() {
        return "이름: " + name + ", 학번: " + std_num + ", 소개: " + introduce + ", 성실도: " + much_Nice;
    }

}
