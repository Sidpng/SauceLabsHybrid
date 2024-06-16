package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	static WebDriver driver;

	@BeforeClass
	public void navigate_to_sauce_labs_homepage() {

		System.out.println("Initialising browser");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

	}

	@AfterClass
	public void login_to_sauce_labs() {

		driver.manage().deleteAllCookies();
		driver.quit();

	}
}
