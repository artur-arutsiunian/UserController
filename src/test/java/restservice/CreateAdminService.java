package restservice;

import restservice.pojo.userCreate.Gender;
import restservice.pojo.userCreate.Role;

import static io.restassured.RestAssured.given;

public class CreateAdminService extends BaseService {
    private final RequestBuilder requestBuilder = new RequestBuilder();
    private final ResponseBuilderPositive responseBuilderPos = new ResponseBuilderPositive();
    private final ResponseBuilderNegative responseBuilderNeg = new ResponseBuilderNegative();
    public int verifyingRoleSupervisorNegative() {
        return given(requestBuilder.requestSpec)
                .queryParams("age", "17")
                .queryParams("gender", Gender.male)
                .queryParams("login", "Us")
                .queryParams("password", "1234567")
                .queryParams("role", Role.supervisor)
                .queryParams("screenName", "Us1")
                .when()
                .get("/create/admin")
                .then()
                .spec(responseBuilderNeg.responseSpecNegative)
                .extract().statusCode();
    }

    public int verifyingRoleAdminPositive() {
        return given(requestBuilder.requestSpec)
                .queryParams("age", "17")
                .queryParams("gender", Gender.male)
                .queryParams("login", "Us")
                .queryParams("password", "1234567")
                .queryParams("role", Role.admin)
                .queryParams("screenName", "Us1")
                .when()
                .get("/create/admin")
                .then()
                .spec(responseBuilderPos.responseSpecPositive)
                .extract().statusCode();
    }

    public int verifyingRoleUserPositive() {
        return given(requestBuilder.requestSpec)
                .queryParams("age", "17")
                .queryParams("gender", Gender.male)
                .queryParams("login", "Us")
                .queryParams("password", "1234567")
                .queryParams("role", Role.user)
                .queryParams("screenName", "Us1")
                .when()
                .get("/create/admin")
                .then()
                .spec(responseBuilderPos.responseSpecPositive)
                .extract().statusCode();
    }
}
