import org.testng.annotations.Test;
import Pages.LoginPage;

public class LoginTests extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void login() {

        loginPage = new LoginPage(driver);
        loginPage.provideEmail("bhakti.damle@testpro.io")
                .providePassword("Mangodesk234!")
                .clickSubmit();
    }
}