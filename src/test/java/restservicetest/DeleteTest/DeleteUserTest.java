package restservicetest.DeleteTest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restservice.CreateSupervisorService;
import restservice.DeleteUserService;
import restservice.pojo.userCreate.CreateRes;
import restservicetest.BaseTest;

public class DeleteUserTest extends BaseTest {

    private final CreateSupervisorService crService = new CreateSupervisorService();
    private final DeleteUserService service = new DeleteUserService();

    @Test
    @DisplayName("Remove user by role 'user'")
    @Description("Remove user by role 'user'")
    void deleteUserByUserNegativeTest(){
        CreateRes res = crService.createUserInstanceForRestOfTheMethods();
        service.deleteUserByUserNegative(res.getId());
    }

    @Test
    @DisplayName("Remove admin by role 'user'")
    @Description("Remove admin by role 'user'")
    void deleteAdminByUserNegativeTest(){
        CreateRes res = crService.createAdminInstanceForRestOfTheMethods();
        service.deleteUserByUserNegative(res.getId());
    }
}
