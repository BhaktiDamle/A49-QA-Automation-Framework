import Pages.LoginPage;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import Pages.HomePage;


public class HomePageTests extends BaseTest{

    @Test

    public void contextClick(){

        LoginPage loginPage= new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.loginCorrectCred();
        homePage.clickAllSongs()
                .contextClickFirstSong();
    }
    @Test

    public void hoverPlay(){

        LoginPage loginPage= new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.loginCorrectCred();
        homePage.clickAllSongs()
                .hoverOverPlayButton();
    }
}