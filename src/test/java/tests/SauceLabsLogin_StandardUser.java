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

public class SauceLabsLogin_StandardUser extends BaseClass {

	@Test(priority = 1, groups = {"Login_tests"})
	public void standard_user_login() throws IOException {

		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Define the destination file
		Date d = new Date();
		String FileName = d.toString().replace(":", "_").replace(" ", "_") + "StandardUser.png";
		File destinationFile = new File("./src/test/resources/Testevidence/" + FileName);

		// Copy the screenshot to the destination file
		FileHandler.copy(screenshot, destinationFile);

		Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html");
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Define the destination file
		Date d1 = new Date();
		String FileName1 = d1.toString().replace(":", "_").replace(" ", "_") + "StandardUser.png";
		File destinationFile1 = new File("./src/test/resources/Testevidence/" + FileName1);
		FileHandler.copy(screenshot1, destinationFile1);

	}

}
