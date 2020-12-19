package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.DriverManager;

import java.util.concurrent.TimeUnit;

import static org.testng.FileAssert.fail;

public class BaseTest {
    static WebDriver driver;
    // create ExtentReports and attach reporter(s)
    static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    static ExtentTest test;

    @BeforeClass
    public static void beforeClass() {
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // add custom system info
        extent.setSystemInfo("Tester:", "Nir Bar");
        // log results
        try {
            driver = DriverManager.getDriverInstance();
            driver.get(DriverManager.getData("url"));
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
            fail("Cant connect chromeDriver");
            test.log(Status.FAIL, "Driver Connection Failed! " + e.getMessage());
        }
    }


    @AfterClass
    public static void afterClass() {
        //test.log(Status.INFO, "@After test " + "After test method");
        //driver.quit();
        // build and flush report
        extent.flush();
    }

    /*private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }*/
}
