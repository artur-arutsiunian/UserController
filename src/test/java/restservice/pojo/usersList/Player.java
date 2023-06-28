package restservice.pojo.usersList;

public class Player {

    private int id;
    private String screenName;
    private String gender;
    private int age;
    private String role;

    public Player(int id, String screenName, String gender, int age, String role) {
        this.id = id;
        this.screenName = screenName;
        this.gender = gender;
        this.age = age;
        this.role = role;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
