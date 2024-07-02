package tests.Standard_User_All_Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseClass;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Request_demo extends BaseClass {

    @Test(priority = 7, enabled = false)
    public void aboutSauceLabs_standard_user() throws IOException, InterruptedException {
        Standard_user_login standardUserLogin = new Standard_user_login();
        standardUserLogin.standard_user_login();
        driver.findElement(By.xpath(readConfig.getProperty("additional_menu_icon"))).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(readConfig.getProperty("aboutUs_button"))));
        element.click();
        Thread.sleep(2000);
        WebElement requestDemo = driver.findElement(By.xpath(readConfig.getProperty("request_demo_button")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", requestDemo);
        List<WebElement> elements = driver.findElements(By.xpath(readConfig.getProperty("request_demo_button")));
        elements.get(2).click();
        System.out.println(elements.size());
        Assert.assertEquals(driver.getTitle(),"Request a Sauce Labs Demo");

        driver.findElement(By.xpath(readConfig.getProperty("additional_menu_icon"))).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(readConfig.getProperty("logout_button"))));
        element1.click();
    }
}
