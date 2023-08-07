import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;
import java.util.List;

public class StandaloneTest {
    public static void main(String[] args)  {
        WebDriver driver=  new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/client");
        driver.findElement(By.id("userEmail")).sendKeys("hs@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Anish29@");
        driver.findElement(By.cssSelector("#login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        System.out.println("Message is : " +driver.findElement(By.id("toast-container")).getText());
        System.out.println("Title of the page is : " +driver.getTitle());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
        System.out.println("No. of Elements available on UI are : " +products.size());
       WebElement prod= products.stream().filter
                (product->product.findElement(By.cssSelector("b"))
                        .getText().equalsIgnoreCase("ZARA COAT 3")).findFirst().orElse(null);
       prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();


       wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("toast-bottom-right")));
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast-bottom-right")));
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
        List<WebElement> cartProducts=driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
        Boolean matchedProduct=cartProducts.stream().anyMatch(matchingProduct->matchingProduct.getText().equalsIgnoreCase("ZARA COAT 3"));
        Assert.assertTrue(matchedProduct);
        driver.findElement(By.xpath("//*[contains(text(),'Checkout')]")).click();
         driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("Ind");
           List<WebElement> elements= driver.findElements(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted']"));
        System.out.println("No of elements present in dropdown :" +elements.size());

        for (int i=0;i<elements.size();i++){
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
           if( elements.get(i).getText().equalsIgnoreCase("India")){
               elements.get(i).click();
               break;
           }
        }
        driver.findElement(By.xpath("//*[contains(text(),'Place Order')]")).click();
        }



    }

