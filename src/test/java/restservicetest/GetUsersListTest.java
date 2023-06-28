package restservicetest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restservice.GetListUserService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetUsersListTest extends BaseTest{

    private final GetListUserService service = new GetListUserService();
    @Test
    @DisplayName("Receive users list")
    @Description("Get list of users")
    void verifyListPlayersPositiveTest(){
        assertEquals(200, service.verifyListPlayersPositive(), "HTTP code is not 200");
    }
}
