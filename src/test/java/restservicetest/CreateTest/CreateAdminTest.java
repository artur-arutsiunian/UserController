package restservicetest.CreateTest;

import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restservice.CreateAdminService;
import restservice.pojo.userCreate.CreateReq;
import restservice.pojo.userCreate.CreateRes;
import restservicetest.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateAdminTest extends BaseTest {
    private final CreateAdminService serviceAdmin = new CreateAdminService();
    private final CreateReq cReq = new CreateReq();
    private final CreateAdminService cAs = new CreateAdminService();

    @Test
    @DisplayName("Send wrong user role who can't be created")
    @Description("Send wrong type of role with which user can't be created")
    void verifyingRoleSupervisorNegativeTest(){
        CreateReq rCP = cReq.getCreateDto();
        Response respCP = new CreateReq().send(rCP);
        respCP.as(CreateRes.class);
//        respCP.as(CreateRes.class);
        assertEquals(400, serviceAdmin.verifyingRoleSupervisorNegative(), "HTTP code is not 400");
    }

    @Test
    @DisplayName("Send correct role of user who can be created")
    @Description("Send another correct option role of user who can be created")
    void verifyingRoleAdminPositiveTest(){
        assertEquals(200, serviceAdmin.verifyingRoleAdminPositive(), "HTTP code is not 200");
    }

    @Test
    @DisplayName("Send correct role of user who can be created")
    @Description("Send another correct option role of user who can be created")
    void verifyingRoleUserPositiveTest(){
        assertEquals(200, serviceAdmin.verifyingRoleUserPositive(), "HTTP code is not 200");
    }
}
