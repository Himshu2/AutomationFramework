import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;


public class ProductCatalogueTest extends TestUtils {

    @Test(dataProvider = "productData",description = "To verify that item that user needs to purchase is available on UI or not")
    public void validateAvailabilityOfProduct(String productName) throws InterruptedException {

        String expectedProduct = "ZARA COAT 3";
        String actualProduct = productCataloguePage.getProductList(productName);
        System.out.println("actualProduct is " + actualProduct);
        softAssert.assertEquals(actualProduct, expectedProduct);
        softAssert.assertAll();

    }
    @Test(description = "To verify the cart in case when cart is empty")
    public void validateEmptyCart() {
        productCataloguePage.validateEmptyCart();
        softAssert.assertEquals(productCataloguePage.getToastMessage(),"No Product in Your Cart");

    }

    @SneakyThrows
    @Test(description = "To verify that user should be able to add the items in the cart")
    public void addToCartItem() {

        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        System.out.println("No. of Elements available on UI are : " + products.size());
        WebElement prod = products.stream().filter
                (product -> product.findElement(By.cssSelector("b"))
                        .getText().equalsIgnoreCase("ZARA COAT 3")).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        Thread.sleep(3000);
    }

    @SneakyThrows
    @Test(description = "To verify that the added item is  available in the cart or not")
    public void validateAddedItemInCartList() {
        addToCartItem();
       productCataloguePage.clickOnCartButton();
        String actualProduct =  productCataloguePage.validateCartItem("ZARA COAT 3");
        String expectedProduct = "ZARA COAT 3";
        System.out.println("actualProduct is " + actualProduct);
        softAssert.assertEquals(actualProduct, expectedProduct);
        softAssert.assertAll();
    }
    @Test(description="To validate that user is able to checkout the item from the cart")
    public void checkoutTest(){
        validateAddedItemInCartList();
        cartPage.clickOnCheckout();
    }

    @Test(description="To validate that user is able to submit the order")
    public void submitOrderTest(){
        checkoutTest();
        checkoutPage.enterCountry();
        checkoutPage.submitOrder();
    }
@DataProvider(name="productData")
    public Object[][] getData(){
        Object[][] data={{"ZARA COAT 3"}};
        return data;
    }

}
