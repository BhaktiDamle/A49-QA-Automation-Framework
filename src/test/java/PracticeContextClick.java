import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class PracticeContextClick extends BaseTest {

    public void ContextClick() {

        provideEmail("bhakti.damle@testpro.io");
        providePassword("Mangodesk234!");
        clickSubmit();
        clickAllSongs();
        contextClickFirstSong();
    }

    @Test

    public void clickAllSongs() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("li a.songs")));
        WebElement clickAllSongsElement = driver.findElement(By.xpath("li a.songs"));
        clickAllSongsElement.click();
    }

    public void contextClickFirstSong() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth child[1]")));
        WebElement firstSongElement = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth child[1]"));
        actions.contextClick(firstSongElement);
    }
}
