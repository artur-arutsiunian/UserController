package restservicetest.EditTest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restservice.CreateSupervisorService;
import restservice.EditUserService;
import restservice.pojo.userCreate.CreateRes;
import restservicetest.BaseTest;

public class EditAdminTest extends BaseTest {
    private final CreateSupervisorService crService = new CreateSupervisorService();
    private final EditUserService service = new EditUserService();
    @Test
    @DisplayName("Change 'user' age by admin")
    @Description("Change 'user' age by admin")
    void editUserAgeByAdminPositiveTest(){
        CreateRes res = crService.createUserInstanceForRestOfTheMethods();
        service.editUserAgeByAdminPositive(res.getId());
    }

    @Test
    @DisplayName("Change 'admin' age by admin'")
    @Description("Change 'admin' age by admin'")
    void editAdminAgeByAdminPositiveTest(){
        CreateRes res = crService.createAdminInstanceForRestOfTheMethods();
        service.editUserAgeByAdminPositive(res.getId());
    }
}
