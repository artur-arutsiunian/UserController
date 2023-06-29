package restservice;

import org.hamcrest.Matchers;
import restservice.pojo.userCreate.CreateRes;
import restservice.pojo.userCreate.Gender;
import restservice.pojo.userCreate.Role;

import static io.restassured.RestAssured.*;

public class CreateSupervisorService extends BaseService {
    private final RequestBuilder requestBuilder = new RequestBuilder();
    private final ResponseBuilderPositive responseBuilderPos = new ResponseBuilderPositive();
    private final ResponseBuilderNegative responseBuilderNeg = new ResponseBuilderNegative();
    public CreateRes createUserPositive() {
         return given(requestBuilder.requestSpec)
                .queryParams("age", "17")
                .queryParams("gender", Gender.male)
                .queryParams("login", "JackUser")
                .queryParams("password", "1234567")
                .queryParams("role", Role.admin)
                .queryParams("screenName", "JackScreenName10")
                .when()
                .get("/create/supervisor")
                .then()
                .spec(responseBuilderPos.responseSpecPositive)
                .body("login", Matchers.equalTo("JackUser"))
                .body("gender", Matchers.equalTo(Gender.male))
                .body("age", Matchers.equalTo(17))
                .body("password", Matchers.equalTo("1234567"))
                .body("role", Matchers.equalTo(Role.admin))
                .body("screenName", Matchers.equalTo("JackScreenName10"))
                .extract().as(CreateRes.class);
    }
    public int verifyingAgeNegative() {
        return given(requestBuilder.requestSpec)
                .queryParams("age", "60")
                .queryParams("gender", Gender.male)
                .queryParams("login", "Jack558806")
                .queryParams("password", "1234567")
                .queryParams("role", Role.admin)
                .queryParams("screenName", "JackScreenName558806")
                .when()
                .get("/create/supervisor")
                .then()
                .spec(responseBuilderNeg.responseSpecNegative)
                .extract().statusCode();
    }

    public int verifyingPasswordNegative() {
        return given(requestBuilder.requestSpec)
                .queryParams("age", "20")
                .queryParams("gender", Gender.male)
                .queryParams("login", "Jack559906")
                .queryParams("password", "123456")
                .queryParams("role", Role.admin)
                .queryParams("screenName", "JackScreenName559906")
                .when()
                .get("/create/supervisor")
                .then()
                .spec(responseBuilderNeg.responseSpecNegative)
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
                .get("/create/supervisor")
                .then()
                .spec(responseBuilderPos.responseSpecPositive)
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
                .get("/create/supervisor")
                .then()
                .spec(responseBuilderPos.responseSpecPositive)
                .extract().statusCode();
    }

    public int verifyingRoleSupervisorNegative() {
        return given(requestBuilder.requestSpec)
                .queryParams("age", "17")
                .queryParams("gender", Gender.male)
                .queryParams("login", "Us")
                .queryParams("password", "1234567")
                .queryParams("role", Role.supervisor)
                .queryParams("screenName", "Us1")
                .when()
                .get("/create/supervisor")
                .then()
                .spec(responseBuilderNeg.responseSpecNegative)
                .extract().statusCode();
    }

    public int verifyingUniqueLoginFieldNegative() {
        return given(requestBuilder.requestSpec)
                .queryParams("age", "17")
                .queryParams("gender", Gender.male)
                .queryParams("login", "JackUser")
                .queryParams("password", "1234567")
                .queryParams("role", Role.admin)
                .queryParams("screenName", "Us1")
                .when()
                .get("/create/supervisor")
                .then()
                .spec(responseBuilderNeg.responseSpecNegative)
                .extract().statusCode();
    }

    public int verifyingUniqueScreenNameFieldNegative() {
        return given(requestBuilder.requestSpec)
                .queryParams("age", "17")
                .queryParams("gender", Gender.male)
                .queryParams("login", "Us")
                .queryParams("password", "1234567")
                .queryParams("role", Role.admin)
                .queryParams("screenName", "JackScreenName10")
                .when()
                .get("/create/supervisor")
                .then()
                .spec(responseBuilderNeg.responseSpecNegative)
                .extract().statusCode();
    }

    public int verifyingGenderFieldPositive() {
        return given(requestBuilder.requestSpec)
                .queryParams("age", "17")
                .queryParams("gender", Gender.female)
                .queryParams("login", "Us")
                .queryParams("password", "1234567")
                .queryParams("role", Role.user)
                .queryParams("screenName", "Us1")
                .when()
                .get("/create/supervisor")
                .then()
                .spec(responseBuilderPos.responseSpecPositive)
                .extract().statusCode();
    }

    public int verifyingGenderFieldNegative() {
        return given(requestBuilder.requestSpec)
                .queryParams("age", "17")
                .queryParams("gender", "xxx")
                .queryParams("login", "Us")
                .queryParams("password", "1234567")
                .queryParams("role", Role.user)
                .queryParams("screenName", "Us1")
                .when()
                .get("/create/supervisor")
                .then()
                .spec(responseBuilderNeg.responseSpecNegative)
                .extract().statusCode();
    }

    public CreateRes createUserInstanceForRestOfTheMethods() {
        return given(requestBuilder.requestSpec)
                .queryParams("age", "17")
                .queryParams("gender", Gender.male)
                .queryParams("login", "Jack09")
                .queryParams("password", "1234567")
                .queryParams("role", Role.user)
                .queryParams("screenName", "JackScreenName09")
                .when()
                .get("/create/supervisor")
                .then()
                .spec(responseBuilderPos.responseSpecPositive)
                .extract().as(CreateRes.class);
    }

    public CreateRes createAdminInstanceForRestOfTheMethods() {
        return given(requestBuilder.requestSpec)
                .queryParams("age", "17")
                .queryParams("gender", Gender.male)
                .queryParams("login", "Jack09")
                .queryParams("password", "1234567")
                .queryParams("role", Role.admin)
                .queryParams("screenName", "JackScreenName09")
                .when()
                .get("/create/supervisor")
                .then()
                .spec(responseBuilderPos.responseSpecPositive)
                .extract().as(CreateRes.class);
    }
}