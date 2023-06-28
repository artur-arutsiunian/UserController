package restservicetest.DeleteTest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restservice.CreateSupervisorService;
import restservice.DeleteUserService;
import restservice.pojo.userCreate.CreateRes;
import restservicetest.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteSupervisorTest extends BaseTest {

    private final CreateSupervisorService crService = new CreateSupervisorService();
    private final DeleteUserService service = new DeleteUserService();

    @Test
    @DisplayName("Delete 'user' by supervisor")
    @Description("Delete 'user' by supervisor")
    void deleteUserBySupervisorPositiveTest(){
        CreateRes res = crService.createUserInstanceForRestOfTheMethods();
        service.deleteUserBySupervisorPositive(res.getId());
    }

    @Test
    @DisplayName("Remove user with wrong id")
    @Description("Delete of user with wrong id")
    void deleteUserNegativeTest(){
        assertEquals(403, service.deleteUserNegative(), "HTTP code is not 403");
    }

    @Test
    @DisplayName("Delete 'admin' by supervisor")
    @Description("Delete 'admin' by supervisor")
    void deleteAdminBySupervisorPositiveTest(){
        CreateRes res = crService.createAdminInstanceForRestOfTheMethods();
        service.deleteUserBySupervisorPositive(res.getId());
    }
}
