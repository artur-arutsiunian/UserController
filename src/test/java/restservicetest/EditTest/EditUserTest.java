package restservicetest.EditTest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restservice.CreateSupervisorService;
import restservice.EditUserService;
import restservice.pojo.userCreate.CreateRes;
import restservicetest.BaseTest;

public class EditUserTest extends BaseTest {
    private final CreateSupervisorService crService = new CreateSupervisorService();
    private final EditUserService service = new EditUserService();

    @Test
    @DisplayName("Change 'user' age by user")
    @Description("Change 'user' age by user")
    void editUserAgeByUserPositiveTest(){
        CreateRes res = crService.createUserInstanceForRestOfTheMethods();
        service.editUserAgeByUserPositive(res.getId());
    }

    @Test
    @DisplayName("Change 'admin' age by user'")
    @Description("Change 'admin' age by user'")
    void editAdminAgeByUserNegativeTest(){
        CreateRes res = crService.createAdminInstanceForRestOfTheMethods();
        service.editUserAgeByUserNegative(res.getId());
    }
}
