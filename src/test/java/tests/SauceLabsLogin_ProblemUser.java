package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class SauceLabsLogin_ProblemUser extends BaseClass {

    @Test(priority = 3, groups = {"Login tests"})
    public void standard_user_login() throws IOException {

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("problem_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        String url = driver.getCurrentUrl();
        System.out.println(url);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Define the destination file
        Date d = new Date();
        String FileName = d.toString().replace(":", "_").replace(" ", "_") + "ProblemUser.png";
        File destinationFile = new File("./src/test/resources/Testevidence/" + FileName);

        // Copy the screenshot to the destination file
        FileHandler.copy(screenshot, destinationFile);

        Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html");

    }

}
