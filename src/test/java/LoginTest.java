
import org.testng.annotations.*;


public class LoginTest extends TestUtils {

    @Test(description = "To verify that user should be able to login successfully when enters a valid credentials")
    public void loginApplication() {
        loginPage.loginApplication("hs@gmail.com","Anish29@");
        loginPage.waitTillLocatorDisplay();
        softAssert.assertEquals(loginPage.getToastMessage(),"Login successfully");
    }






}



