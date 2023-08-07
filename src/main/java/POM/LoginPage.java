package POM;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    public LoginPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(id="userEmail")
    WebElement email;

    @FindBy(id="userPassword")
    WebElement password;

    @FindBy(id="login")
    WebElement login;

    @FindBy(id="toast-container" )
    WebElement toastMessage;

    By toastMsg= By.id("toast-container");

    public void loginApplication(String userEmail,String pwd){
    email.sendKeys(userEmail);
    password.sendKeys(pwd);
    login.click();

    }
    public  String getToastMessage(){
        System.out.println("Toast Message is : " +toastMessage.getText());
        return toastMessage.getText();

    }

    public void waitTillLocatorDisplay(){

        handleWaitTillElementVisibility(toastMsg);
    }

}
