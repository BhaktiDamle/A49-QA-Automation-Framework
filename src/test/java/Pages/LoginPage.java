package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void loginCorrectCred() {
        provideEmail("bhakti.damle@testpro.io");
        providePassword("Mangodesk234!");
        clickSubmit();
        Assert.assertTrue(isAvatarDisplayed());
    }

    public void loginIncorrectEmailPasswordCred(){
        provideEmail("bhakti@testpro.io");
        providePassword("Mangodesk");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl()," https://qa.koel.app/");
    }

    public void loginValidEmailEmptyPassword(){

        provideEmail("bhakti@testpro.io");
        providePassword("");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), " https://qa.koel.app/");
    }
    public void provideEmail(String email)
    {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void providePassword(String password)
    {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit()
    {
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        submitButton.click();
    }

    public boolean isAvatarDisplayed(){
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        return isAvatarDisplayed();
    }
}
