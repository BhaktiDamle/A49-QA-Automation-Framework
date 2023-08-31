import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class PracticeContextClick extends BaseTest {

    @Test
    public void ContextClick() {

       provideEmail("bhakti.damle@testpro.io");
        providePassword("Mangodesk234!");
        clickSubmit();
        clickAllSongs();
        contextClickFirstSong();
    }



    public void clickAllSongs() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs")));
        WebElement clickAllSongsElement = driver.findElement(By.cssSelector("li a.songs"));
        clickAllSongsElement.click();
    }

    public void contextClickFirstSong() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songsWrapper tr:nth-child(1) td.title")));
        WebElement firstSongElement = driver.findElement(By.cssSelector("#songsWrapper tr:nth-child(1) td.title"));
        actions.contextClick(firstSongElement).perform();
    }
}
