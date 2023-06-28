package restservicetest.CreateTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restservice.CreateSupervisorService;
import restservicetest.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateSupervisorTest extends BaseTest {
    private final CreateSupervisorService serviceSupervisor = new CreateSupervisorService();
    @Test
    @DisplayName("Check user creation")
    @Description("Check that user creates with all necessary fields and values")
    @Severity(value = SeverityLevel.BLOCKER)
    void createUserPositiveTest() {
        serviceSupervisor.createUserPositive();
    }

    @Test
    @DisplayName("Send wrong age field")
    @Description("Send wrong user age")
    void verifyingAgeNegativeTest() {
        assertEquals(400, serviceSupervisor.verifyingAgeNegative(), "HTTP code is not 400");
    }

    @Test
    @DisplayName(("Send wrong password field"))
    @Description("Send wrong user password")
    void verifyingPasswordNegativeTest() {
        assertEquals(400, serviceSupervisor.verifyingPasswordNegative(), "HTTP code is not 400");
    }

    @Test
    @DisplayName("Send 'user' role who can be created")
    @Description("Send 'user' role who can be created")
    void verifyingRoleUserPositiveTest(){
        assertEquals(200, serviceSupervisor.verifyingRoleUserPositive(), "HTTP code is not 200");
    }

    @Test
    @DisplayName("Send 'admin' role who can be created")
    @Description("Send 'admin' role who can be created")
    void verifyingRoleAdminPositiveTest(){
        assertEquals(200, serviceSupervisor.verifyingRoleAdminPositive(), "HTTP code is not 200");
    }

    @Test
    @DisplayName("Send 'supervisor' role who can't be created")
    @Description("Send 'supervisor' role who can't be created")
    void verifyingRoleSupervisorNegativeTest(){
        assertEquals(400, serviceSupervisor.verifyingRoleSupervisorNegative(), "HTTP code is not 400");
    }

    @Test
    @DisplayName("Send 'login' which was already used")
    @Description("Send 'login' field which was used before")
    void verifyingUniqueLoginFieldNegativeTest(){
        assertEquals(400, serviceSupervisor.verifyingUniqueLoginFieldNegative(), "HTTP code is not 400");
    }

    @Test
    @DisplayName("Send 'screenName' which was already used")
    @Description("Send 'screenName' field which was used before")
    void verifyingUniqueScreenNameFieldNegative(){
        assertEquals(400, serviceSupervisor.verifyingUniqueScreenNameFieldNegative(), "HTTP code is not 400");
    }

    @Test
    @DisplayName("Send another correct user gender")
    @Description("Send another correct option gender of user")
    void verifyingGenderFieldPositive(){
        assertEquals(200, serviceSupervisor.verifyingGenderFieldPositive(), "HTTP code is not 200");
    }

    @Test
    @DisplayName("Send wrong user gender")
    @Description("Send incorrect gender of user")
    void verifyingGenderFieldNegative(){
        assertEquals(400, serviceSupervisor.verifyingGenderFieldNegative(), "HTTP code is not 400");
    }
}
