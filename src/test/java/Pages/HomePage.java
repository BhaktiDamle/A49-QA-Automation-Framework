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

    @FindBy(css = "#sidebar li:nth-child(5)")
    WebElement artistsElement;


    public HomePage clickAllSongs() {

        wait.until(ExpectedConditions.elementToBeClickable(allSongsBtn)).click();
        return this;
    }

    public HomePage contextClickFirstSong() {

        wait.until(ExpectedConditions.visibilityOf(firstSongElement));
        actions.contextClick(firstSongElement).perform();
        return this;
    }

    public HomePage hoverOverArtists() {

       wait.until(ExpectedConditions.visibilityOf(artistsElement));
        actions.moveToElement(artistsElement).perform();
        return this;
    }
}
