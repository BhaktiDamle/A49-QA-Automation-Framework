import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

//    @Test
//
//    public void loginCorrectCred(){
//        provideEmail("bhakti.damle@testpro.io");
//        providePassword("Mangodesk234!");
//        clickSubmit();
//        Assert.assertTrue(isAvatarDisplayed());
  //  }
@Test
   public void loginIncorrectEmailPasswordCred(){
       provideEmail("bhakti@testpro.io");
        providePassword("Mangodesk");
       clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl()," https://qa.koel.app/");
    }


//@Test
//    public void loginValidEmailEmptyPassword(){
//
//        provideEmail("bhakti@testpro.io");
//        providePassword("");
//        clickSubmit();
//        Assert.assertEquals(driver.getCurrentUrl(), " https://qa.koel.app/");
//    }

}
