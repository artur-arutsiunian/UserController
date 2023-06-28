package restservice;

import static io.restassured.RestAssured.given;

public class GetListUserService extends BaseService{
    private final RequestBuilder requestBuilder = new RequestBuilder();
    private final ResponseBuilderPositive responseBuilderPos = new ResponseBuilderPositive();
    private final ResponseBuilderNegative responseBuilderNeg = new ResponseBuilderNegative();

    public int verifyListPlayersPositive(){
        return given(requestBuilder.requestSpec)
                .when()
                .get("/get/all")
                .then()
                .spec(responseBuilderPos.responseSpecPositive)
                .extract().statusCode();
    }
}
