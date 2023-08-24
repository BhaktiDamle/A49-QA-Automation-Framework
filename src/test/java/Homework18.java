import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.time.Duration;

public class Homework18 extends BaseTest {


    @Test

    public void playSong() throws InterruptedException {

        navigateToPage();
        provideEmail("bhakti.damle@testpro.io");
        providePassword("Mangodesk234!");
        clickSubmit();
        //Songs();
        playSongTest();
        Assert.assertTrue(isSongPlaying());


    }


    public void playSongTest() throws InterruptedException {
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButtonElement = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playNextButton.click();
        playButtonElement.click();
        Thread.sleep(2000);
    }

    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@class='bars']"));
        return soundBar.isDisplayed();
    }


}





