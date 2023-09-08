import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;

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
    public WebDriver setupBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.86.44:4444/";
        switch (browser) {

            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "lambda":
                return lambdaTest();
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
    public WebDriver lambdaTest() throws MalformedURLException {

        String hubURL = "https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("117.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "damle.bhakti");
        ltOptions.put("accessKey", "cx0IaioTVsupr92xov2H9X0y9zMvIlAmSN6yvbwO4F1srS2NZq");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL(hubURL), browserOptions);

    }
    @AfterMethod

    public void closeBrowser() {

        driver.quit();
    }

}