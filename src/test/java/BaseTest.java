import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver = null;

    public static String url ="";

    public static WebDriverWait wait;

    public static Actions actions = null;




    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

@BeforeMethod
@Parameters({"BaseURL"})

    public static void launchBrowser(String BaseURL){

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    options.addArguments("--disable-popup-blocking");
    options.addArguments("--disable-notifications");
    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    url = BaseURL;
    driver.get(url);
    wait = new WebDriverWait(driver, Duration.ofSeconds(4));
}

//Helper Methods

    public void provideEmail(String email){

WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
emailField.clear();
emailField.sendKeys(email);

}

public void providePassword(String password){

WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password'']")));
passwordField.clear();
passwordField.sendKeys(password);

    }

public void clickSubmit(){
        WebElement submitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        submitElement.click();
}

@AfterMethod

    public void closeBrowser(){

        driver.quit();
}
}