package restservice.pojo.userCreate;

public class Model {

    public CreateReq getCreateReq(String age, Gender gender, String login, String password, Role role, String screenName){
        return new CreateReq(age, gender, login, password, role, screenName);
    }
}
