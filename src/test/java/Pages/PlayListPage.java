package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class PlayListPage extends BasePage {

   public PlayListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='playlists']/ul/li[3]")
    WebElement playlistElement;

    @FindBy(css = "[name='name']")
    WebElement playlistNameField;

    @FindBy(css= "#playlists  li:nth-child(5)")
    WebElement playListElementExists  ;

    @FindBy(css = "[data-testid='sidebar-create-playlist-btn']")
    WebElement plusIconElement;

    @FindBy(xpath = "*//li[contains(text(),'New Playlist')]")
    WebElement playlistOptionElement;

    @FindBy(css = ".del.btn-delete-playlist")
    WebElement deletePlaylistBtn;

    public PlayListPage doubleClickMyPlaylist() {

        wait.until(ExpectedConditions.visibilityOf(playlistElement));
        actions.doubleClick(playlistElement).perform();
        return this;
    }

    public PlayListPage enterNewPlaylistName() {
        wait.until(ExpectedConditions.visibilityOf(playlistNameField));
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistNameField.sendKeys("TobeDeletedPL");
        playlistNameField.sendKeys(Keys.ENTER);
        return this;
    }

    public boolean doesPlaylistExists() {

       wait.until(ExpectedConditions.visibilityOf(playListElementExists ));
      return playListElementExists .isDisplayed();
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
