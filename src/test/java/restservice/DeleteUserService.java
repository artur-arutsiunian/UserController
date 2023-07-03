package restservice;

import restservice.pojo.userDelete.DeleteReq;
import restservice.pojo.userPatch.PatchReq;

import static io.restassured.RestAssured.given;
public class DeleteUserService implements BaseService{

    private final RequestBuilder requestBuilder = new RequestBuilder();
    private final ResponseBuilderDeletePositive responseBuilderDeletePos = new ResponseBuilderDeletePositive();
    private final ResponseBuilderForbiddenNegative responseBuilderDeleteNeg = new ResponseBuilderForbiddenNegative();

    public int deleteUserBySupervisorPositive(int playerId){
        DeleteReq dl = new DeleteReq(playerId);
        return given(requestBuilder.requestSpec)
                .when()
                .body(dl)
                .delete("/delete/supervisor/")
                .then()
                .spec(responseBuilderDeletePos.responseSpecDeletePositive)
                .extract().statusCode();
    }

    public int deleteUserNegative(){
        DeleteReq dl = new DeleteReq(54533);
        return given(requestBuilder.requestSpec)
                .when()
                .body(dl)
                .delete("/delete/supervisor/")
                .then()
                .spec(responseBuilderDeleteNeg.responseSpecForbiddenNegative)
                .extract().statusCode();
    }

    public int deleteUserByAdminPositive(int playerId){
        DeleteReq dl = new DeleteReq(playerId);
        return given(requestBuilder.requestSpec)
                .when()
                .body(dl)
                .delete("/delete/admin/")
                .then()
                .spec(responseBuilderDeletePos.responseSpecDeletePositive)
                .extract().statusCode();
    }

    public int deleteUserByUserNegative(int playerId){
        DeleteReq dl = new DeleteReq(playerId);
        return given(requestBuilder.requestSpec)
                .when()
                .body(dl)
                .delete("/delete/user/")
                .then()
                .spec(responseBuilderDeleteNeg.responseSpecForbiddenNegative)
                .extract().statusCode();
    }
}
