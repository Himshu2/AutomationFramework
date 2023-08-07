package Base;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;
    public Properties prop;

    public TestBase() {
        try {
           prop = new Properties();
           FileInputStream ip = new FileInputStream("src/main/resources/Config/Config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void initialization() {

        String browserName= System.getProperty("browser") !=null ? System.getProperty("browser") : prop.getProperty("browser");
         // prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            driver=new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Driver not found or incorrect browser");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(prop.getProperty("url"));
    }

    public void launchApplication() {
        initialization();
        System.out.println("Browser gets launch successfully");
    }

    public void handleWaitTillElementVisibility(By findBy) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public void handleWaitTillElementInvisibility(By findBy) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }
    public  static List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

        // Convert JSON to String
        String jsonContent=  FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

        //Convert String to HashMap through Jackson Databind
        ObjectMapper mapper=new ObjectMapper();
        List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
        });
        return data;
    }
    public String getScreenShot(String testCaseName,WebDriver driver) throws IOException {

        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File file=new File(System.getProperty("user.dir") + "\\FailedTestCasesSnapshots\\" + testCaseName + ".png");
        FileUtils.copyFile(src, file);
        return System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
    }

}
