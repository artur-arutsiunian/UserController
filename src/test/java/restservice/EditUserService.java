package restservice;

import org.hamcrest.Matchers;
import restservice.pojo.userPatch.PatchReq;
import restservice.pojo.userPatch.PatchRes;
import static io.restassured.RestAssured.given;

public class EditUserService implements BaseService {

    private final RequestBuilder requestBuilder = new RequestBuilder();
    private final ResponseBuilderPositive responseBuilderPos = new ResponseBuilderPositive();
    private final ResponseBuilderNegative responseBuilderNeg = new ResponseBuilderNegative();
    private final ResponseBuilderForbiddenNegative responseBuilderForbiddenNeg = new ResponseBuilderForbiddenNegative();

    public PatchRes editUserAgePositive(int userId) {
        PatchReq pr = new PatchReq(25);
        return given(requestBuilder.requestSpec)
                .when()
                .body(pr)
                .patch("/update/supervisor/" + userId)
                .then()
                .spec(responseBuilderPos.responseSpecPositive)
                .body("age", Matchers.equalTo(25))
                .extract().as(PatchRes.class);
    }
    public int editUserAgeNegative(int userId) {
        PatchReq pr = new PatchReq(16);
        return given(requestBuilder.requestSpec)
                .when()
                .body(pr)
                .patch("/update/supervisor/" + userId)
                .then()
                .spec(responseBuilderNeg.responseSpecNegative)
                .extract().statusCode();
    }

    public int editUserAgeBySupervisorPositive(int userId) {
        PatchReq pr = new PatchReq(25);
        return given(requestBuilder.requestSpec)
                .when()
                .body(pr)
                .patch("/update/supervisor/" + userId)
                .then()
                .spec(responseBuilderPos.responseSpecPositive)
                .extract().statusCode();
    }

    public int editUserAgeByAdminPositive(int userId) {
        PatchReq pr = new PatchReq(25);
        return given(requestBuilder.requestSpec)
                .when()
                .body(pr)
                .patch("/update/admin/" + userId)
                .then()
                .spec(responseBuilderPos.responseSpecPositive)
                .extract().statusCode();
    }

    public int editUserAgeByUserPositive(int userId) {
        PatchReq pr = new PatchReq(25);
        return given(requestBuilder.requestSpec)
                .when()
                .body(pr)
                .patch("/update/user/" + userId)
                .then()
                .spec(responseBuilderPos.responseSpecPositive)
                .extract().statusCode();
    }

    public int editUserAgeByUserNegative(int userId) {
        PatchReq pr = new PatchReq(25);
        return given(requestBuilder.requestSpec)
                .when()
                .body(pr)
                .patch("/update/user/" + userId)
                .then()
                .spec(responseBuilderForbiddenNeg.responseSpecForbiddenNegative)
                .extract().statusCode();
    }
}
