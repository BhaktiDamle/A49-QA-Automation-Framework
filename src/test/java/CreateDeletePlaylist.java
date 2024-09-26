import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CreateDeletePlaylist extends BaseTest {

    String newPlayListName = "My New Playlist 3";

    @Test
public void createDeletePlaylist() throws InterruptedException {

        provideEmail("bhakti.damle@testpro.io");
        providePassword("Mangodesk234!");
        clickSubmit();
        Thread.sleep(2000);
        clickOnCreatePlaylistButton();
        clickPlaylistOption();
        enterNewPlaylistName(newPlayListName);
        clickOnDeletePlaylistBtn();
    }

    public void clickOnCreatePlaylistButton() {

        WebElement plusIconElement = driver.findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"));
        plusIconElement.click();

    }

    public void clickPlaylistOption() {

        WebElement playlistOptionElement = driver.findElement(By.xpath("*//li[contains(text(),'New Playlist')]"));
        playlistOptionElement.click();

    }


        public void enterNewPlaylistName(String newPlayListName){
            WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
            playlistInputField.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
            playlistInputField.sendKeys(newPlayListName);
            playlistInputField.sendKeys(Keys.ENTER);
        }

        public void clickOnDeletePlaylistBtn(){
            WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".del.btn-delete-playlist")));
            actions.click(deletePlaylistBtn).perform();
        }


    }


