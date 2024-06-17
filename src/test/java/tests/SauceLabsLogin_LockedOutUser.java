package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class SauceLabsLogin_LockedOutUser extends BaseClass {

    @Test(priority = 2, groups = {"Login_tests"})
    public void standard_user_login() throws IOException {

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("locked_out_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Define the destination file
        Date d = new Date();
        String FileName = d.toString().replace(":", "_").replace(" ", "_") + "LockedOutUser.png";
        File destinationFile = new File("./src/test/resources/Testevidence/" + FileName);

        // Copy the screenshot to the destination file
        FileHandler.copy(screenshot, destinationFile);
        List<WebElement> errorWindow = driver.findElements(By.xpath("//button[@class='error-button']"));
        Assert.assertTrue(errorWindow.size()>0);
    }

}
