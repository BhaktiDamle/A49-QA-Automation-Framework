
import org.testng.annotations.Test;
import Pages.PlayListPage;
import Pages.LoginPage;
import org.testng.Assert;


public class PlayListTests extends BaseTest {

    @Test
    public void renamePlaylist() {

        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        loginPage.loginCorrectCred();
        playListPage.doubleClickMyPlaylist();
        playListPage.enterNewPlaylistName();
        Assert.assertTrue(playListPage.doesPlaylistExists());

    }

    public void createDeletePlaylist() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        loginPage.loginCorrectCred();
        Thread.sleep(2000);
        playListPage.clickOnDeletePlaylistBtn();
        playListPage.clickPlaylistOption();
        playListPage.enterNewPlaylistName();
        playListPage.clickOnDeletePlaylistBtn();
    }


}



