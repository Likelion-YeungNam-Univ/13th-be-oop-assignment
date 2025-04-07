package Entity;

public class babyLion {
    private String name;
    private String studentID;
    private String selfIntro;
    private int sincerity;


    public babyLion(String name, String studentID, String selfIntroduction, int sincerity) {
        this.name = name;
        this.studentID = studentID;
        this.selfIntro = selfIntroduction;
        this.sincerity = sincerity;
    }

    public String getName() {
        return this.name;
    }
    public String getStudentID() {
        return this.studentID;
    }
    public String getSelfIntro() {
        return this.selfIntro;
    }
    public int getSincerity() {
        return this.sincerity;
    }

    public void setSelfIntro(String selfIntro) {
        this.selfIntro = selfIntro;
    }
    public void setSincerity(int sincerity) {
        this.sincerity = sincerity;
    }

    @Override
    public String toString() {
        return "🦁아기사자🦁" + '\t' + '\t' + "학번" + '\t' + '\t' + "이름"+ '\t'+ '\t' + "성실도" + '\t' + "자기소개" + '\n' +
                "      " + '\t'+ '\t' + studentID + '\t' + name + '\t' + sincerity + '\t'+ '\t' + selfIntro;
    }
}
