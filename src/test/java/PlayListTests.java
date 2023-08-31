import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.BaseTest;
import Pages.LoginPage;
import Pages.PlayListPage;


public class PlayListTests extends BaseTest {
    LoginPage loginPage;
    PlaylistPage playlistPage;


    @BeforeClass
    void login() {

        loginPage = new LoginPage(driver);
        playlistPage = new PlaylistPage(driver);
        loginPage.loginCorrectCred();
    }

    @Test
    public void renamePlaylist() {
        playlistPage.doubleClickMyPlaylist();
        playlistPage.enterNewPlaylistName();
        Assert.assertTrue(doesPlaylistExists());

    }

}



