package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;


public class PlayListPage extends BasePage {

    public String newPlaylistName = "MyRenamedPlaylist";

    public PlayListPage(WebDriver driver) {
        super(driver);
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

    public void clickOnCreatePlaylistButton() {

        WebElement plusIconElement = driver.findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"));
        plusIconElement.click();

    }

    public void clickPlaylistOption() {

        WebElement playlistOptionElement = driver.findElement(By.xpath("*//li[contains(text(),'New Playlist')]"));
        playlistOptionElement.click();

    }


    public void clickOnDeletePlaylistBtn() {
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".del.btn-delete-playlist")));
        actions.click(deletePlaylistBtn).perform();
    }


}



