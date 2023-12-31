package restservice;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public interface   BaseService {

//    private final RequestSpecification rs;
//
//    public BaseService(RequestSpecification rs) {
//        this.rs = rs;
//    }

//    public  RequestSpecification given() {
//        return RestAssured.given()
//                .setBaseUri("http://3.68.165.45")
//                .setBasePath("/player")
//                .setContentType(ContentType.JSON)
//                .addFilter(new AllureRestAssured())
//                .build();
//    }
//}
    public static class RequestBuilder {
        public final RequestSpecification requestSpec = new RequestSpecBuilder()
                    .setBaseUri("http://3.68.165.45")
                    .setBasePath("/player")
                    .setContentType(ContentType.JSON)
                    .addFilter(new AllureRestAssured())
                    .build();
    }



//    public static class RequestEndpointBuilder{
//        public final RequestSpecification requestEndpointSpec = new RequestSpecBuilder()
//                .setBasePath("/create/admin")
//                .build();
//    }

    public static class ResponseBuilderPositive{
        public final ResponseSpecification responseSpecPositive;

        public ResponseBuilderPositive(){
            this.responseSpecPositive = new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .build();
        }
    }

    public static class ResponseBuilderNegative{
        public final ResponseSpecification responseSpecNegative;

        public ResponseBuilderNegative(){
            this.responseSpecNegative = new ResponseSpecBuilder()
                    .expectStatusCode(400)
                    .build();
        }
    }

    public static class ResponseBuilderDeletePositive{

        public final ResponseSpecification responseSpecDeletePositive;

        public ResponseBuilderDeletePositive(){
            this.responseSpecDeletePositive = new ResponseSpecBuilder()
                    .expectStatusCode(204)
                    .build();
        }
    }

    public static class ResponseBuilderForbiddenNegative{

        public final ResponseSpecification responseSpecForbiddenNegative;

        public ResponseBuilderForbiddenNegative(){
            this.responseSpecForbiddenNegative = new ResponseSpecBuilder()
                    .expectStatusCode(403)
                    .build();
        }
    }
}
