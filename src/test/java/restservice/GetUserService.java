package restservice;

import org.hamcrest.Matchers;
import restservice.pojo.userGet.GetReq;
import restservice.pojo.userGet.GetRes;

import static io.restassured.RestAssured.given;

public class GetUserService implements BaseService{

    private final RequestBuilder requestBuilder = new RequestBuilder();
    private final ResponseBuilderPositive responseBuilderPos = new ResponseBuilderPositive();
    private final ResponseBuilderNegative responseBuilderNeg = new ResponseBuilderNegative();

    public GetRes getUserPositive(int playerId){
        GetReq gr = new GetReq(playerId);
        return given(requestBuilder.requestSpec)
                .when()
                .body(gr)
                .post("/get")
                .then()
                .spec(responseBuilderPos.responseSpecPositive)
                .body("id", Matchers.equalTo(playerId))
                .extract().as(GetRes.class);
    }

    public int getUserNegative(){
        GetReq gr = new GetReq(432432);
        return given(requestBuilder.requestSpec)
                .when()
                .body(gr)
                .post("/get")
                .then()
                .spec(responseBuilderNeg.responseSpecNegative)
                .extract().statusCode();
    }
}
