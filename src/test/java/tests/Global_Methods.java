package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static tests.BaseClass.driver;

public class Global_Methods implements Global_Methods_Interface{

    @Override
    public void clickElementByXPath(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            element.click();
            System.out.println("Clicked on element with XPath: " + xpath);
        } catch (Exception e) {
            System.err.println("Failed to click on element with XPath: " + xpath);
            e.printStackTrace();
        }
    }

    @Override
    public void clickElementByID(String xpath) {
        try {
            WebElement element = driver.findElement(By.id(xpath));
            element.click();
            System.out.println("Clicked on element with XPath: " + xpath);
        } catch (Exception e) {
            System.err.println("Failed to click on element with XPath: " + xpath);
            e.printStackTrace();
        }
    }

    // Generic function to wait for a web element by XPath
    @Override
    public WebElement waitForElementByXPath(String xpath, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            System.err.println("Failed to find element with XPath: " + xpath + " within " + timeoutInSeconds + " seconds.");
            e.printStackTrace();
            return null;
        }
    }

    // Generic function to send input data to any text field
    @Override
    public void sendKeysToElementByXPath(String xpath, String keys, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.sendKeys(keys);
            System.out.println("Sent keys to element with XPath: " + xpath);
        } catch (Exception e) {
            System.err.println("Failed to send keys to element with XPath: " + xpath + " within " + timeoutInSeconds + " seconds.");
            e.printStackTrace();
        }
    }

}
