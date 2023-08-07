import lombok.SneakyThrows;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;


public class SubmitOrderTest extends TestUtils {

    @SneakyThrows
    @Test(description = "To verify that user is able to purchase the item from the application",dataProvider = "getData")

    public void submitOrder(HashMap<String,String> input)  {
        loginPage.loginApplication(input.get("email"),input.get("password"));
        productCataloguePage.getProductList(input.get("product"));
        productCataloguePage.clickOnCartButton();
        productCataloguePage.validateCartItem(input.get("product"));
        cartPage.clickOnCheckout();
        checkoutPage.enterCountry();
        checkoutPage.submitOrder();
        softAssert.assertEquals(confirmationPage.getConfirmationMessage(),"THANKYOU FOR THE ORDER.");
        softAssert.assertAll();
        productCataloguePage.signOutApplication();
        Thread.sleep(3000);

    }

    @SneakyThrows
    @DataProvider(name="getData")
    public Object[][] getData(){
       /* HashMap<String,String> map=new HashMap<>();
        map.put("email","hs@gmail.com");
        map.put("password","Anish29@");
        map.put("product","ZARA COAT 3");
        HashMap<Object,Object> map1=new HashMap<>();
        map1.put("email","as@gmail.com");
        map1.put("password","Anish29@");
        map1.put("product","ADIDAS ORIGINAL");*/
        List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\PurchaseOrder.json");
        return new Object[][] {{data.get(0)},{data.get(1)}};
    }
}
