import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    public WebDriver driver;

    public String url = " https://qa.koel.app/";

    public WebDriverWait wait;

    @BeforeSuite

    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})

    public void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        url = BaseURL;
        navigateToPage();
    }

    public void navigateToPage() {

        driver.get(url);
    }

    @AfterMethod

    public void closeBrowser() {

        driver.quit();
    }
}