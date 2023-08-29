import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    String newPlaylistName = "MyRenamedPlaylist";

    @Test
    public void renamePlaylist() {

        provideEmail("bhakti.damle@testpro.io");
        providePassword("Mangodesk234!");
        clickSubmit();
        doubleClickMyPlaylist();
        enterNewPlaylistName();
        Assert.assertTrue(doesPlaylistExists());
    }
    public void doubleClickMyPlaylist() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']/ul/li[3]")));
        WebElement playListElement = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]"));
        actions.doubleClick(playListElement).perform();
    }
    public void enterNewPlaylistName() {
        WebElement playlistNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistNameField.sendKeys(newPlaylistName);
        playlistNameField.sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExists() {

        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + newPlaylistName + "']")));
        return playlistElement.isDisplayed();
    }
}