package POM;

import Base.TestBase;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class ProductCataloguePage extends TestBase {

    public ProductCataloguePage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "toast-container")
    WebElement toastMessage;

    By toastMsg = By.id("toast-container");

    @FindBy(css = ".btn-custom .fa-sign-out")
    WebElement signOut;

    @FindBy(xpath = "//h5")
    List<WebElement> productList;

    @FindBy(css = ".cartSection h3")
    List<WebElement> cartList;
    By prod=By.cssSelector("b");

@FindBy(css=".itemImg")
WebElement itemImage;
@FindBy(css=".card-body button:last-of-type")
List<WebElement> addToCart;

    public void clickOnCartButton() {
       /* handleWaitTillElementVisibility(toastMsg);
        handleWaitTillElementInvisibility(toastMsg);*/
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
    }

    public void signOutApplication() {
        signOut.click();
    }

    public String getProductList(String productName) throws InterruptedException {
        List<WebElement> products = productList;
String actualProduct="";
        for (int i=0;i<products.size();i++) {
            if (products.get(i).getText().equalsIgnoreCase(productName)) {
              addToCart.get(i).click();
                Thread.sleep(3000);

            }
        }
return actualProduct;
    }

    /*@SneakyThrows
    public WebElement getProductList(String productName) {
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        System.out.println("No. of Elements available on UI are : " + products.size());
        WebElement prod = products.stream().filter
                (product -> product.findElement(By.cssSelector("b"))
                        .getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        Thread.sleep(3000);
        return prod;
    }*/

    public void validateEmptyCart() {
        clickOnCartButton();

    }
    public  String getToastMessage(){
        System.out.println("Toast Message is : " +toastMessage.getText());
        return toastMessage.getText();

    }
    public String validateCartItem(String cartsProduct){
        List<WebElement> cartProducts = cartList;
        String actualItem="";
      for (WebElement cartProduct :cartProducts) {
         String desiredItem= cartProduct.getText();
         if(desiredItem.equalsIgnoreCase(cartsProduct)){
             actualItem=desiredItem;
         }
      }
     return actualItem;
    }

   /* @SneakyThrows
    public void addToCart(){
        addToCart.click();
        Thread.sleep(3000);
    }*/
}
