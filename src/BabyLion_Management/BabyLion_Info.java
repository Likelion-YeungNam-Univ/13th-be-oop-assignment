package BabyLion_Management;

//아기사자 정보 저장 클래스
public class BabyLion_Info {
    private String studentId;
    private String name;
    private String self_introduction;
    private int sincerity_score;

    public BabyLion_Info(String studentId, String name, String self_introduction) {
        this.studentId = studentId;
        this.name = name;
        this.self_introduction = self_introduction;
        this.sincerity_score = 0;
    }

    public String getStudent_id() {
        return studentId;
    }

    public String getSelf_introduction() {
        return self_introduction;
    }

    public void setSelf_introduction(String self_introduction) {
        this.self_introduction = self_introduction;
    }

    public int getSincerity_score() {
        return sincerity_score;
    }

    public void setSincerity_score(int sincerity_score) {
        this.sincerity_score = sincerity_score;
    }

    @Override //아기사자 출력시 아기사자의 정보를 출력해주는 함수
    public String toString() {
        return String.format("%-15s %-13s %-10d %-32s", studentId, name, sincerity_score, self_introduction);
    }
}
