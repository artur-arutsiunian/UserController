package restservicetest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restservice.CreateSupervisorService;
import restservice.GetUserService;
import restservice.pojo.userCreate.CreateRes;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetUserTest extends BaseTest {
    private final CreateSupervisorService crService = new CreateSupervisorService();
    private final GetUserService service = new GetUserService();

    @Test
    @DisplayName("Receive user with correct id")
    @Description("Get a specific user by id")
    void getUserPositiveTest() {
        CreateRes res = crService.createUserInstanceForRestOfTheMethods();
        service.getUserPositive(res.getId());
    }

    @Test
    @DisplayName("Receive user with wrong id")
    @Description("Get of user with wrong id")
    void getUserNegativeTest(){
        assertEquals(400, service.getUserNegative(), "HTTP code is not 400");
    }
}
