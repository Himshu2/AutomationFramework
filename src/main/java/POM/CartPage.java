package POM;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends TestBase {

    public CartPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//button[contains(text(),'Checkout')]")
    WebElement checkout;

    public void clickOnCheckout(){
        checkout.click();
    }
}
