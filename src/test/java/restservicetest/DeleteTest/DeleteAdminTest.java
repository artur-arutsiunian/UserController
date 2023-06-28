package restservicetest.DeleteTest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restservice.CreateSupervisorService;
import restservice.DeleteUserService;
import restservice.pojo.userCreate.CreateRes;
import restservicetest.BaseTest;

public class DeleteAdminTest extends BaseTest {

    private final CreateSupervisorService crService = new CreateSupervisorService();
    private final DeleteUserService service = new DeleteUserService();

    @Test
    @DisplayName("Remove user by role 'admin'")
    @Description("Remove user by role 'admin'")
    void deleteUserByAdminPositiveTest(){
        CreateRes res = crService.createUserInstanceForRestOfTheMethods();
        service.deleteUserByAdminPositive(res.getId());
    }

    @Test
    @DisplayName("Remove admin by role 'admin'")
    @Description("Remove admin by role 'admin'")
    void deleteAdminByAdminPositiveTest(){
        CreateRes res = crService.createAdminInstanceForRestOfTheMethods();
        service.deleteUserByAdminPositive(res.getId());
    }
}
