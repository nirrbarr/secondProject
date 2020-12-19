package tests;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeScreen extends BaseTest {

    @Test
    public void pickPricePoint() {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            test = extent.createTest("Home Screen Test", "test number 2");
            List<WebElement> elementList = driver.findElements(By.cssSelector("li[class=\"active-results\""));
            // Iterating through the list
            for (WebElement currentElement : elementList) {
                // Finding a specific element with a specific text and clicking it
                if (currentElement.getText().equals("עד 99 ש\"ח")) {
                    currentElement.click();
                }
            }
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        } catch (Exception exception) {
            test.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64));
            test.log(Status.FAIL, "failed: no such element");
            Assert.fail("failed: no such element");
        }
        test.log(Status.PASS, "Home Screen- step 1: passed"); //extent report
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}

