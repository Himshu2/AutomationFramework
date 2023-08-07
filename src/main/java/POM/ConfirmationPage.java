package POM;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ConfirmationPage extends TestBase {
    public ConfirmationPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(tagName = "h1")
    WebElement confirmationPage;
    public String getConfirmationMessage(){
       return confirmationPage.getText();

    }
}
