public class Person {
    private int studentId;
    private String name;
    private String introduction;
    private int Score;

    public Person(int studentId, String name, String introduction, int score) {
        this.studentId = studentId;
        this.name = name;
        this.introduction = introduction;
        Score = score;
    }

    public int getStudentId() {
        return this.studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIntroduction() {
        return this.introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public int getScore() {
        return this.Score;
    }
    public void setScore(int score) {
        this.Score = score;
    }

    public void printInfo(){
        System.out.println("🦁아기사자 학번: " +this.studentId + " 이름: "+ this.name+" 자기소개: "
                +this.introduction+" 성실도 점수: "+this.Score);
    }
}

