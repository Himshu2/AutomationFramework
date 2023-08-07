package POM;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class CheckoutPage extends TestBase {
    public CheckoutPage(){
        PageFactory.initElements(driver,this);
    }
@FindBy(css="[placeholder='Select Country']")
    WebElement enterCountry;
    @FindBy(xpath="//button[@class='ta-item list-group-item ng-star-inserted']")
    List<WebElement> dropdownCountries;

    @FindBy(xpath="//*[contains(text(),'Place Order')]")
    WebElement submitOrder;

    public void enterCountry(){
        enterCountry.sendKeys("Ind");
        List<WebElement> elements= dropdownCountries;
            for (int i=0;i<elements.size();i++){
              //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
                if( elements.get(i).getText().equalsIgnoreCase("India")){
                    elements.get(i).click();
                    break;
                }
        }
    }

    public void submitOrder(){
        submitOrder.click();
    }
}
