package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefs {

    WebDriver driver;

    WebDriverWait wait;

    @Before

    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Given("I open Login Page")
    public void iOpenLoginPage() {
        String url = "https://qa.koel.app/";
        driver.get(url);

    }

    @When("I enter Email {string}")
    public void iEnterEmail(String arg0) {

        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.clear();
        emailField.sendKeys();
    }

    @And("I enter password {string}")
    public void iEnterPassword(String arg0) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']"))).sendKeys();
    }

    @And("I submit")
    public void iSubmit() {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }

    @After

    public void closeBrowser() {

        driver.quit();
    }
}
