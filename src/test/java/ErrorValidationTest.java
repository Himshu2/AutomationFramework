
import org.testng.annotations.Test;

public class ErrorValidationTest extends TestUtils {

    @Test(description = "To verify that user should be able to login successfully when enters a valid credentials")
    public void loginApplicationWithInvalidCredentials()  {

        loginPage.loginApplication("hk@gmail.com","Anish");
       loginPage. waitTillLocatorDisplay();

        softAssert.assertEquals(loginPage.getToastMessage(),"Incorrect Email or password");
        softAssert.assertAll();
    }
}
