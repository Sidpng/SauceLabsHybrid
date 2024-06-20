package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class TC01_All_Login_Scenarios extends BaseClass {

    ReadConfig readConfig = new ReadConfig();
    @Test(priority = 1, groups = {"Login_tests"})
    public void standard_user_login() throws IOException {

        driver.findElement(By.xpath(readConfig.getProperty("username_input_field"))).
                sendKeys(readConfig.getProperty("standard_username"));
        driver.findElement(By.xpath(readConfig.getProperty("password_input_field"))).
                sendKeys(readConfig.getProperty("password_for_all"));
        driver.findElement(By.xpath(readConfig.getProperty("login_button"))).click();
        String url = driver.getCurrentUrl();

        /*
        * Capturing UI for test evidence
        * Naming convention to include dynamic time stamp
        */

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date d = new Date();
        String FileName = d.toString().replace(":", "_").replace(" ", "_") + "StandardUser.png";
        File destinationFile = new File("./src/test/resources/Standard_User_TestEvidences/" + FileName);
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
        String FileName1 = d1.toString().replace(":", "_").replace(" ", "_") + "StandardUser.png";
        File destinationFile1 = new File("./src/test/resources/Standard_User_TestEvidences/" + FileName1);
        FileHandler.copy(screenshot1, destinationFile1);

    }

    @Test(priority = 2, groups = {"Login_tests"})
    public void visual_user_login() throws IOException {

        driver.findElement(By.xpath(readConfig.getProperty("username_input_field"))).
                sendKeys(readConfig.getProperty("visual_username"));
        driver.findElement(By.xpath(readConfig.getProperty("password_input_field"))).
                sendKeys(readConfig.getProperty("password_for_all"));
        driver.findElement(By.xpath(readConfig.getProperty("login_button"))).click();
        String url = driver.getCurrentUrl();

        /*
         * Capturing UI for test evidence
         * Naming convention to include dynamic time stamp
         */

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date d = new Date();
        String FileName = d.toString().replace(":", "_").replace(" ", "_") + "VisualUser.png";
        File destinationFile = new File("./src/test/resources/Visual_User_TestEvidences/" + FileName);
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
        String FileName1 = d1.toString().replace(":", "_").replace(" ", "_") + "VisualUser.png";
        File destinationFile1 = new File("./src/test/resources/Visual_User_TestEvidences/" + FileName1);
        FileHandler.copy(screenshot1, destinationFile1);

    }

    @Test(priority = 3, groups = {"Login_tests"})
    public void locked_out_user_login() throws IOException {

        driver.findElement(By.xpath(readConfig.getProperty("username_input_field"))).
                sendKeys(readConfig.getProperty("lockedOut_username"));
        driver.findElement(By.xpath(readConfig.getProperty("password_input_field"))).
                sendKeys(readConfig.getProperty("password_for_all"));
        driver.findElement(By.xpath(readConfig.getProperty("login_button"))).click();
        String url = driver.getCurrentUrl();

        /*
         * Capturing UI for test evidence
         * Naming convention to include dynamic time stamp
         */

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date d = new Date();
        String FileName = d.toString().replace(":", "_").replace(" ", "_") + "LockedOutUser.png";
        File destinationFile = new File("./src/test/resources/Locked_Out_User_TestEvidences/" + FileName);
        FileHandler.copy(screenshot, destinationFile);

        //Verifying whether the landed page is correct after login

        Assert.assertEquals(url, readConfig.getProperty("baseurl"));
        List<WebElement> ele = driver.findElements(By.xpath(readConfig.getProperty("locked_out_error_button")));
        Assert.assertTrue(ele.size()>0);

        /*
         * Capturing UI for test evidence
         * Naming convention to include dynamic time stamp
         */

        File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date d1 = new Date();
        String FileName1 = d1.toString().replace(":", "_").replace(" ", "_") + "LockedOutUser.png";
        File destinationFile1 = new File("./src/test/resources/Locked_Out_User_TestEvidences/" + FileName1);
        FileHandler.copy(screenshot1, destinationFile1);

    }

    @Test(priority = 4, groups = {"Login_tests"})
    public void error_user_login() throws IOException {

        driver.navigate().refresh();
        driver.findElement(By.xpath(readConfig.getProperty("username_input_field"))).
                sendKeys(readConfig.getProperty("error_username"));
        driver.findElement(By.xpath(readConfig.getProperty("password_input_field"))).
                sendKeys(readConfig.getProperty("password_for_all"));
        driver.findElement(By.xpath(readConfig.getProperty("login_button"))).click();
        String url = driver.getCurrentUrl();

        /*
         * Capturing UI for test evidence
         * Naming convention to include dynamic time stamp
         */

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date d = new Date();
        String FileName = d.toString().replace(":", "_").replace(" ", "_") + "ErrorUser.png";
        File destinationFile = new File("./src/test/resources/Error_User_TestEvidences/" + FileName);
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
        String FileName1 = d1.toString().replace(":", "_").replace(" ", "_") + "ErrorUser.png";
        File destinationFile1 = new File("./src/test/resources/Error_User_TestEvidences/" + FileName1);
        FileHandler.copy(screenshot1, destinationFile1);

    }

    @Test(priority = 5, groups = {"Login_tests"})
    public void performance_glitch_user_login() throws IOException {

        driver.navigate().refresh();
        driver.findElement(By.xpath(readConfig.getProperty("username_input_field"))).
                sendKeys(readConfig.getProperty("performance_glitch_username"));
        driver.findElement(By.xpath(readConfig.getProperty("password_input_field"))).
                sendKeys(readConfig.getProperty("password_for_all"));
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

    @Test(priority = 6, groups = {"Login_tests"})
    public void problem_user_login() throws IOException {

        driver.navigate().refresh();
        driver.findElement(By.xpath(readConfig.getProperty("username_input_field"))).
                sendKeys(readConfig.getProperty("problem_username"));
        driver.findElement(By.xpath(readConfig.getProperty("password_input_field"))).
                sendKeys(readConfig.getProperty("password_for_all"));
        driver.findElement(By.xpath(readConfig.getProperty("login_button"))).click();
        String url = driver.getCurrentUrl();

        /*
         * Capturing UI for test evidence
         * Naming convention to include dynamic time stamp
         */

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date d = new Date();
        String FileName = d.toString().replace(":", "_").replace(" ", "_") + "ProblemUser.png";
        File destinationFile = new File("./src/test/resources/Problem_User_TestEvidences/" + FileName);
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
        String FileName1 = d1.toString().replace(":", "_").replace(" ", "_") + "ProblemUser.png";
        File destinationFile1 = new File("./src/test/resources/Problem_User_TestEvidences/" + FileName1);
        FileHandler.copy(screenshot1, destinationFile1);

    }
}
