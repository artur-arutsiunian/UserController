package restservice.pojo.userGet;

public class GetRes {

    private int age;
    private String gender;
    private int id;
    private String login;
    private String password;
    private String role;
    private String screenName;

    public GetRes(int age, String gender, int id, String login, String password, String role, String screenName) {
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.screenName = screenName;
    }

    public GetRes() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }
}
