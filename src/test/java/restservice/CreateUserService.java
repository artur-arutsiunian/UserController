package restservice;

import restservice.pojo.userCreate.Gender;
import restservice.pojo.userCreate.Role;

import static io.restassured.RestAssured.given;

public class CreateUserService implements BaseService {
    private final RequestBuilder requestBuilder = new RequestBuilder();
    private final ResponseBuilderForbiddenNegative responseBuilderForbiddenNeg = new ResponseBuilderForbiddenNegative();

    public int verifyingRoleSupervisorNegative() {
        return given(requestBuilder.requestSpec)
                .queryParams("age", "17")
                .queryParams("gender", Gender.male)
                .queryParams("login", "Us")
                .queryParams("password", "1234567")
                .queryParams("role", Role.supervisor)
                .queryParams("screenName", "Us1")
                .when()
                .get("/create/user")
                .then()
                .spec(responseBuilderForbiddenNeg.responseSpecForbiddenNegative)
                .extract().statusCode();
    }

    public int verifyingRoleAdminNegative() {
        return given(requestBuilder.requestSpec)
                .queryParams("age", "17")
                .queryParams("gender", Gender.male)
                .queryParams("login", "Us")
                .queryParams("password", "1234567")
                .queryParams("role", Role.admin)
                .queryParams("screenName", "Us1")
                .when()
                .get("/create/user")
                .then()
                .spec(responseBuilderForbiddenNeg.responseSpecForbiddenNegative)
                .extract().statusCode();
    }

    public int verifyingRoleUserNegative() {
        return given(requestBuilder.requestSpec)
                .queryParams("age", "17")
                .queryParams("gender", Gender.male)
                .queryParams("login", "Us")
                .queryParams("password", "1234567")
                .queryParams("role", Role.user)
                .queryParams("screenName", "Us1")
                .when()
                .get("/create/user")
                .then()
                .spec(responseBuilderForbiddenNeg.responseSpecForbiddenNegative)
                .extract().statusCode();
    }
}
