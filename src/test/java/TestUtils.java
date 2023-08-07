import Base.TestBase;
import POM.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestUtils extends TestBase {

   public static LoginPage loginPage;
    public static ProductCataloguePage productCataloguePage;
    public static CartPage cartPage;
    public static CheckoutPage checkoutPage;

    public static ConfirmationPage confirmationPage;
    public static SoftAssert softAssert;

    @BeforeSuite(alwaysRun = true)
    public void instantiation()  {
        launchApplication();
        loginPage=new LoginPage();
        productCataloguePage=new ProductCataloguePage();
        cartPage=new CartPage();
        checkoutPage=new CheckoutPage();
        confirmationPage=new ConfirmationPage();
        softAssert=new SoftAssert();
    }

   /* @BeforeMethod(alwaysRun = true)
    public void loginApplication() {
        loginPage.loginApplication("hs@gmail.com", "Anish29@");
    }
*/
  /*  @AfterMethod(alwaysRun = true)
    public void logOutApplication() {

        productCataloguePage.signOutApplication();
    }*/

}
