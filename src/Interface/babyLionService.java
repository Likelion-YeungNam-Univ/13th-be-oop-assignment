package Interface;

public interface babyLionService {
    public void register(String studentID, String name, String selfIntro, int sincerity);
    public void delete(String studentID);

    public void increaseSincerity(String studentID);
    public void decreaseSincerity(String studentID);

    public void updateSelfIntro(String studentID, String newSelfIntro);
}
