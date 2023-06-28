package restservicetest.CreateTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restservice.CreateAdminService;
import restservice.CreateSupervisorService;
import restservice.CreateUserService;
import restservicetest.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class CreateUserTest extends BaseTest {
    private final CreateUserService serviceUser = new CreateUserService();

    @Test
    @DisplayName("Send wrong user role who can't be created")
    @Description("Send wrong type of role with which user can't be created")
    void verifyingRoleSupervisorNegativeTest(){
        assertEquals(403, serviceUser.verifyingRoleSupervisorNegative(), "HTTP code is not 403");
    }

    @Test
    @DisplayName("Send wrong user role who can't be created")
    @Description("Send wrong type of role with which user can't be created")
    void verifyingRoleAdminNegativeTest(){
        assertEquals(403, serviceUser.verifyingRoleAdminNegative(), "HTTP code is not 403");
    }

    @Test
    @DisplayName("Send wrong user role who can't be created")
    @Description("Send wrong type of role with which user can't be created")
    void verifyingRoleUserNegativeTest(){
        assertEquals(403, serviceUser.verifyingRoleUserNegative(), "HTTP code is not 403");
    }
}
