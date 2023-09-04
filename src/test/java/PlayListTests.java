import org.testng.annotations.Test;
import Pages.PlayListPage;
import Pages.LoginPage;
import org.testng.Assert;


public class PlayListTests extends BaseTest {

    @Test
    public void renamePlaylist() {

        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        loginPage.provideEmail("bhakti.damle@testpro.io")
                 .providePassword("Mangodesk234!")
                 .clickSubmit();
        playListPage.doubleClickMyPlaylist().enterNewPlaylistName();
        Assert.assertTrue(playListPage.doesPlaylistExists());

    }

    @Test
    public void createPlaylist() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        loginPage.provideEmail("bhakti.damle@testpro.io")
                .providePassword("Mangodesk234!")
                .clickSubmit();
        Thread.sleep(2000);
        playListPage.clickOnCreatePlaylistButton()
                .clickPlaylistOption()
                .enterNewPlaylistName()
                .clickOnDeletePlaylistBtn();




    }

}
