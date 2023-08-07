package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    public static ExtentReports getReportObject() {
        String userDir = System.getProperty("D:\\RahulShetty_SeleniumFramework\\SeleniumFramework\\src");
        String path = userDir + "\\Reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test results");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Himanshu Sisodia");
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("Browser Name", "Google Chrome");

        return extent;

    }
}
