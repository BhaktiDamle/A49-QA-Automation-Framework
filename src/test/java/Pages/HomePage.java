package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickAllSongs() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs")));
        WebElement clickAllSongsElement = driver.findElement(By.cssSelector("li a.songs"));
        clickAllSongsElement.click();
    }

    public void contextClickFirstSong() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songsWrapper tr:nth-child(1) td.title")));
        WebElement firstSongElement = driver.findElement(By.cssSelector("#songsWrapper tr:nth-child(1) td.title"));
        actions.contextClick(firstSongElement);
    }

    public void hoverOverPlayButton() {

        WebElement playElement = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        actions.moveToElement(playElement).perform();


    }
}





