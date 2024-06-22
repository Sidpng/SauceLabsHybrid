package tests.Performance_Glitch_User_All_Scenarios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

public class Performance_glitch_user_login extends BaseClass {

    @Test(priority = 5, groups = {"Login_tests"})
    public void performance_glitch_user_login() throws IOException {

        driver.navigate().refresh();
        driver.findElement(By.xpath(readConfig.getProperty("username_input_field"))).sendKeys(readConfig.getProperty("performance_glitch_username"));
        driver.findElement(By.xpath(readConfig.getProperty("password_input_field"))).sendKeys(readConfig.getProperty("password_for_all"));
        driver.findElement(By.xpath(readConfig.getProperty("login_button"))).click();
        String url = driver.getCurrentUrl();

        /*
         * Capturing UI for test evidence
         * Naming convention to include dynamic time stamp
         */

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date d = new Date();
        String FileName = d.toString().replace(":", "_").replace(" ", "_") + "GlitchUser.png";
        File destinationFile = new File("./src/test/resources/Glitch_User_TestEvidences/" + FileName);
        FileHandler.copy(screenshot, destinationFile);

        //Verifying whether the landed page is correct after login

        Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html");

        driver.findElement(By.xpath(readConfig.getProperty("additional_menu_icon"))).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(readConfig.getProperty("logout_button"))));
        element.click();

        /*
         * Capturing UI for test evidence
         * Naming convention to include dynamic time stamp
         */

        File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date d1 = new Date();
        String FileName1 = d1.toString().replace(":", "_").replace(" ", "_") + "GlitchUser.png";
        File destinationFile1 = new File("./src/test/resources/Glitch_User_TestEvidences/" + FileName1);
        FileHandler.copy(screenshot1, destinationFile1);

    }
}
