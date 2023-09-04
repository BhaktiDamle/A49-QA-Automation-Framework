package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "li a.songs")
    WebElement allSongsBtn;

    @FindBy(css = "#songsWrapper tr:nth-child(1) td.title")
    WebElement firstSongElement;

    @FindBy(xpath = "//span[@data-testid='play-btn']")
    WebElement playElement;


    public HomePage clickAllSongs() {

        wait.until(ExpectedConditions.elementToBeClickable(allSongsBtn)).click();
        return this;
    }

    public HomePage contextClickFirstSong() {

        wait.until(ExpectedConditions.visibilityOf(firstSongElement));
        actions.contextClick(firstSongElement).perform();
        return this;
    }

    public HomePage hoverOverPlayButton() {

       wait.until(ExpectedConditions.visibilityOf(playElement));
        actions.moveToElement(playElement).perform();
        return this;
    }
}
