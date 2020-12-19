package tests;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationScreen extends BaseTest {

    @Test
    public void pressLoginRegister_01() {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            test = extent.createTest("Registration Test", "test number 1");
            driver.findElement(By.cssSelector(".seperator-link")).click();
            WebElement webElement = driver.findElement(By.cssSelector(".seperator-link"));
            System.out.println("Element is displayed: " + webElement.isDisplayed());
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        } catch (Exception exception) {
            test.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64));
            test.log(Status.FAIL, "failed: no such element");
            Assert.fail("failed: no such element");
        }
        test.log(Status.PASS, "Register- step 1: passed"); //extent report
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pressRegister();
    }

    private void pressRegister() {
        try {
            driver.findElement(By.cssSelector("span[class=text-btn]")).click();
            WebElement webElement = driver.findElement(By.cssSelector("span[class=text-btn]"));
            System.out.println("element is displayed: " + webElement.isDisplayed());
        } catch (Exception exception) {
            test.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64));
            test.log(Status.FAIL, "failed: no such element");
            Assert.fail("failed: no such element");
        }
        test.log(Status.PASS, "Register- step 2: passed"); //extent report
        insertFirstName();
    }

    private void insertFirstName() {
        try {
            driver.findElement(By.cssSelector("input[placeholder=\"שם פרטי\"]")).sendKeys("Nir");
            WebElement webElement = driver.findElement(By.cssSelector("input[placeholder=\"שם פרטי\"]"));
            System.out.println("element is displayed: " + webElement.isDisplayed());
        } catch (Exception exception) {
            test.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64));
            test.log(Status.FAIL, "failed: no such element");
            Assert.fail("failed: no such element");
        }
        test.log(Status.PASS, "Register- step 3: passed"); //extent report
        insertValidEmail();
    }

    private void insertValidEmail() {
        try {
            driver.findElement(By.cssSelector("input[placeholder=\"מייל\"]")).sendKeys("Nirtest@test.com");
            WebElement webElement = driver.findElement(By.cssSelector("input[placeholder=\"מייל\"]"));
            System.out.println("element is displayed: " + webElement.isDisplayed());
        } catch (Exception exception) {
            test.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64));
            test.log(Status.FAIL, "failed: no such element");
            Assert.fail("failed: no such element");
        }
        test.log(Status.PASS, "Register- step 4: passed"); //extent report
        insertPassword();
    }

    private void insertPassword() {
        try {
            driver.findElement(By.cssSelector("input[placeholder=\"סיסמה\"]")).sendKeys("nir123456");
            WebElement webElement = driver.findElement(By.cssSelector("input[placeholder=\"סיסמה\"]"));
            System.out.println("element is displayed: " + webElement.isDisplayed());
        } catch (Exception exception) {
            test.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64));
            test.log(Status.FAIL, "failed: no such element");
            Assert.fail("failed: no such element");
        }
        test.log(Status.PASS, "Register- step 5: passed"); //extent report
        validatePassword();
    }

    private void validatePassword() {
        try {
            driver.findElement(By.cssSelector("input[placeholder=\"אימות סיסמה\"]")).sendKeys("nir123456");
            WebElement webElement = driver.findElement(By.cssSelector("input[placeholder=\"אימות סיסמה\"]"));
            System.out.println("element is displayed: " + webElement.isDisplayed());
        } catch (Exception exception) {
            test.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64));
            test.log(Status.FAIL, "failed: no such element");
            Assert.fail("failed: no such element");
        }
        test.log(Status.PASS, "Register- step 6: passed"); //extent report
        submitRegister();
    }

    private void submitRegister() {
        try {
            driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
            WebElement webElement = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
            System.out.println("element is displayed: " + webElement.isDisplayed());
        } catch (Exception exception) {
            test.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64));
            test.log(Status.FAIL, "failed: no such element");
            Assert.fail("failed: no such element");
        }
        test.log(Status.PASS, "Register- step 7: passed"); //extent report
    }
}

