public class BabyLion {
    private Long id;
    private String name;
    private String introduce;
    private Integer fame;

    BabyLion(Long id, String name, String introduce, Integer fame) { //init set BLion
        this.id = id;
        this.name = name;
        this.introduce = introduce;
        this.fame = fame;
    }

    public Long getId() {
        return id;
    }

    public Object getName() {
        return name;
    }

    public Integer getFame() {
        return fame;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public void setFame(Integer newFame) {
        this.fame = newFame;
    }

    @Override
    public String toString() {
        return "====================================================================================" +
                "\n학번 : " + id + "\n이름 : " + name + "\n자기소개 : " + introduce + "\n성실도 : " + fame
                + "\n====================================================================================" ;
    }



}
