import java.util.Objects;

public class Repository {
    int studentId;
    String studentName;
    String introduction;
    int faithful = 0;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getFaithful() {
        return faithful;
    }

    public void setFaithful(String score) {
        if (Objects.equals(score, "+"))
            this.faithful++;
        else if (Objects.equals(score, "-"))
            this.faithful--;
    }

}
