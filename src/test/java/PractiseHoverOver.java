import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PractiseHoverOver extends BaseTest {

    @Test

     public void hoverPlay(){

      provideEmail("bhakti.damle@testpro.io");
      providePassword("Mangodesk234!");
      clickSubmit();
      clickAllSongs();
      hoverOverPlayButton();
    }

    public void clickAllSongs() {

        WebElement allSongsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sidebar li:nth-child(3)")));
        allSongsElement.click();
    }

    public void hoverOverPlayButton() {

        WebElement playElement = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        actions.moveToElement(playElement).perform();


    }
}


