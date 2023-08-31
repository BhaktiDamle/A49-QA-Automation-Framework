import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import


public class BaseTest {

    public WebDriver driver;

    public String url =" https://qa.koel.app/";

    BasePage basePage;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeClass

public void launchBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

    }

    @AfterClass
    public void closeBrowser() {
        basePage.quitBrowser();
    }
}

