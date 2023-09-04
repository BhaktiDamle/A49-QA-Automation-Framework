package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class PlayListPage extends BasePage {

    public String newPlaylistName = "MyRenamedPlaylist";

    public PlayListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='playlists']/ul/li[3]")
    WebElement playListElement;

    @FindBy(css = "[name='name']" )
    WebElement playlistNameField;

    @FindBy(xpath = "//a[text()='" + newPlaylistName + "']")
    WebElement playlistElement;

    @FindBy(css = "[data-testid='sidebar-create-playlist-btn']")
    WebElement plusIconElement;

    @FindBy(xpath = "*//li[contains(text(),'New Playlist')]")
    WebElement playlistOptionElement;

    @FindBy(css = ".del.btn-delete-playlist")
    WebElement deletePlaylistBtn;

    public PlayListPage doubleClickMyPlaylist() {

        wait.until(ExpectedConditions.visibilityOf(playListElement);
        actions.doubleClick(playListElement).perform();
        return this;
    }

    public PlayListPage enterNewPlaylistName() {
        wait.until(ExpectedConditions.visibilityOf(playListElement));
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistNameField.sendKeys(newPlaylistName);
        playlistNameField.sendKeys(Keys.ENTER);
        return this;
    }

    public boolean doesPlaylistExists() {

       wait.until(ExpectedConditions.visibilityOf(playlistElement));
      return playListElement.isDisplayed();
    }

    public PlayListPage clickOnCreatePlaylistButton() {

        wait.until(ExpectedConditions.elementToBeClickable(plusIconElement)).click();
        return this;

    }

    public PlayListPage clickPlaylistOption() {

        wait.until(ExpectedConditions.elementToBeClickable(playlistOptionElement)).click();
        return this;
    }


    public PlayListPage clickOnDeletePlaylistBtn() {
        wait.until(ExpectedConditions.visibilityOf(deletePlaylistBtn));
        actions.click(deletePlaylistBtn).perform();
        return this;
    }


}
