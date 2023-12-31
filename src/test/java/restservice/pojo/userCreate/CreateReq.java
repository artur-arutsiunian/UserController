package restservice.pojo.userCreate;

import io.restassured.response.Response;
import restservice.BaseService;

public class CreateReq implements RequestModel, BaseService{

    RequestBuilder rb = new RequestBuilder();

    private String age;
    private Gender gender ;
    private String login;
    private String password;
    private Role role;
    private String screenName;

    public CreateReq(String age, Gender gender, String login, String password, Role role, String screenName) {
        this.age = age;
        this.gender = gender;
        this.login = login;
        this.password = password;
        this.role = role;
        this.screenName = screenName;
    }

    public CreateReq() {
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

//    public static CreateReq getCreateReq(String age){
//        return getCreateDto();
//    }

    public Response send(){
        return send(null);
    }

    public Response send(RequestModel rm){
        return rb.requestSpec.get();
    }
}
