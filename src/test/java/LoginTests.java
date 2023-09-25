import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test

    public void loginCorrectCred() throws InterruptedException {
        provideEmail("bhakti.damle@testpro.io");
        providePassword("Mangodesk234!");
        clickSubmit();
        Thread.sleep(2000);
        clickAvatarIcon();
    }

    @Test
    public void loginIncorrectEmailPasswordCred() throws InterruptedException {
        provideEmail("bhakti@testpro.io");
        providePassword("Mangodesk");
        clickSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
    }


    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {

        provideEmail("bhakti@testpro.io");
        providePassword("");
        clickSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
    }

}
