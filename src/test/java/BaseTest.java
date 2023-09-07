import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URI;

public class BaseTest {

    public WebDriver driver;
    public String url = "https://qa.koel.app/";

    @BeforeSuite
    public void setupSuit() throws MalformedURLException {
        String browser = System.getProperty("browser");
        driver = setupBrowser(browser);
    }

    @BeforeMethod

    public void navigateToPage() {

        driver.get(url);
    }

    WebDriver setupBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.86.44:4444/";
        switch (browser) {

            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            default:
                return setupChrome();
        }
    }

        public WebDriver setupChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        return driver;
    }

    @AfterMethod

    public void closeBrowser()
    {
        driver.quit();
    }
}



