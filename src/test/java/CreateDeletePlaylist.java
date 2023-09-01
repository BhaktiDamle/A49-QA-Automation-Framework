import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateDeletePlaylist extends BaseTest {

    String newPlayListName = "My Playlist 3";

    @Test
public void createDeletePlaylist(){

        provideEmail("bhakti.damle@testpro.io");
        providePassword("Mangodesk234!");
        clickSubmit();
        clickOnCreatePlaylistButton() ;
        enterNewPlaylistName(newPlayListName);
        clickOnDeletePlaylistBtn();
    }

    public void clickOnCreatePlaylistButton() {

        WebElement plusIconElement = driver.findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"));
        plusIconElement.click();

    }

    public void enterNewPlaylistName(String newPlayListName) {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.COMMAND,"A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlayListName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public void clickOnDeletePlaylistBtn() {
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".del.btn-delete-playlist")));
        actions.click(deletePlaylistBtn).perform();
    }

}



