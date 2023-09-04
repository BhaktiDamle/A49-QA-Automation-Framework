import org.testng.annotations.Test;
import Pages.LoginPage;

public class LoginTests extends BaseTest {

    LoginPage loginPage;

    @Test
    public void login() {

        loginPage = new LoginPage(driver);
        loginPage.loginCorrectCred();
    }


}