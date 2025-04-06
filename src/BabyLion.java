class BabyLion {
    private String studentNumber;
    private String studentName;
    private String studentIntro;
    private int sincerity = 0;

    public BabyLion(String studentNumber, String studentName, String studentIntro) {
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.studentIntro = studentIntro;
    }

    public String getStudentNumber() {
        return this.studentNumber;
    }
    public String getStudentName() {
        return this.studentName;
    }
    public String getStudentIntro() {
        return this.studentIntro;
    }
    public int getSincerity() {
        return this.sincerity;
    }

    public void setStudentIntro(String studentIntro) { // 자기소개 수정을 위한 Setter
        this.studentIntro = studentIntro;
    }

    public void setSincerity(int sincerity) { // 성실도 변경을 위한 Setter
        this.sincerity = sincerity;
    }

    @Override
    public String toString() {
        return "학번 : " + studentNumber + " | 이름 : " + studentName + " | 자기소개 : " + studentIntro + " | 성실도 : " + sincerity;
    }
}
