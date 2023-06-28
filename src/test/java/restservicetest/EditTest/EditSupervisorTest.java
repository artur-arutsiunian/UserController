package restservicetest.EditTest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restservice.CreateSupervisorService;
import restservice.EditUserService;
import restservice.pojo.userCreate.CreateRes;
import restservicetest.BaseTest;

public class EditSupervisorTest extends BaseTest {
    private final CreateSupervisorService crService = new CreateSupervisorService();
    private final EditUserService service = new EditUserService();

    @Test
    @DisplayName("Change on correct user age")
    @Description("Check of edit age of user with correct value")
    void editUserAgePositiveTest(){
        CreateRes res = crService.createUserInstanceForRestOfTheMethods();
        service.editUserAgePositive(res.getId());
    }

    @Test
    @DisplayName("Change on wrong user age")
    @Description("Check of edit age of user with incorrect value")
    void editUserAgeNegativeTest(){
        CreateRes res = crService.createUserInstanceForRestOfTheMethods();
        service.editUserAgeNegative(res.getId());
    }

    @Test
    @DisplayName("Change 'user' age by supervisor")
    @Description("Change 'user' age by supervisor")
    void editUserAgeBySupervisorPositiveTest(){
        CreateRes res = crService.createUserInstanceForRestOfTheMethods();
        service.editUserAgeBySupervisorPositive(res.getId());
    }

    @Test
    @DisplayName("Change 'admin' age by supervisor'")
    @Description("Change 'admin' age by supervisor'")
    void editAdminAgeBySupervisorPositiveTest(){
        CreateRes res = crService.createAdminInstanceForRestOfTheMethods();
        service.editUserAgeBySupervisorPositive(res.getId());
    }
}
