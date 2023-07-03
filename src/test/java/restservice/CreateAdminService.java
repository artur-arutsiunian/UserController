package restservice;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.client.methods.RequestBuilder;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateAdminService implements BaseService{
    private final RequestBuilder requestBuilder = new RequestBuilder();
//    private final RequestEndpointBuilder requestEndpointBuilder = new RequestEndpointBuilder();
    private final ResponseBuilderPositive responseBuilderPos = new ResponseBuilderPositive();
    private final ResponseBuilderNegative responseBuilderNeg = new ResponseBuilderNegative();
    public int verifyingRoleSupervisorNegative() {
        Map<String, String> createParamsMap = getCreatePlayerParamsMap("supervisor");
        return given(requestBuilder.requestSpec)
                .queryParams(createParamsMap)
                .when()
                .get("/create/admin")
                .then()
                .spec(responseBuilderNeg.responseSpecNegative)
                .extract().statusCode();
    }

    public int verifyingRoleAdminPositive() {
        Map<String, String> createParamsMap = getCreatePlayerParamsMap("admin");
        return given(requestBuilder.requestSpec)
                .queryParams(createParamsMap)
                .when()
                .get("/create/admin")
                .then()
                .spec(responseBuilderPos.responseSpecPositive)
                .extract().statusCode();
    }

    public int verifyingRoleUserPositive() {
        Map<String, String> createParamsMap = getCreatePlayerParamsMap("user");
        return given(requestBuilder.requestSpec)
                .queryParams(createParamsMap)
                .when()
                .get("/create/admin")
                .then()
                .spec(responseBuilderPos.responseSpecPositive)
                .extract().statusCode();
    }

    private Map<String, String> getCreatePlayerParamsMap(String age, String gender, String login, String password, String screenName, String role){
        return Map.of("age", age, "gender", gender, "login", login, "password", password, "screenName", screenName, "role", role);
    }

    private Map<String, String> getCreatePlayerParamsMap(String role){
        return getCreatePlayerParamsMap("17","male", RandomStringUtils.randomAlphanumeric(5), RandomStringUtils.randomAlphanumeric(7), RandomStringUtils.randomAlphanumeric(5), role);
    }
}
