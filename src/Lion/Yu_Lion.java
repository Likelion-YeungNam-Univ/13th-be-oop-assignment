package Lion;

//학생 데이터 클래스
public class Yu_Lion {

    private String std_id; //학번
    private String std_name; //학생 이름
    private String pr; //자기소개
    private int sincerity; //성실도 diligencepublic Yu_Lion(){}
    public Yu_Lion(String std_id, String std_name, String pr, int sincerity) {
        this.std_id = std_id;
        this.std_name = std_name;
        this.pr = pr;
        this.sincerity = sincerity;
    }
    public int getSincerity() {
        return sincerity;
    }

    public void setSincerity(int sincerity) {
        this.sincerity = sincerity;
    }

    public String getPr() { return pr; }

    public void setPr(String pr) { this.pr = pr; }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public String getStd_id() {
        return std_id;
    }

    public void setStd_id(String std_id) {
        this.std_id = std_id;
    }

    @Override //꼭 안해줘도 되긴해...
    public String toString() //Yu_Lion 객체가 toString으로 출력할 때 Lion.Yu_Lion@7106e68e 이런 문제가 발생함ㅠㅠ...
    {
        return "학번: " + std_id + " 이름: " + std_name + " 자기소개: " + pr + " 성실도: " + sincerity;
    }

}
