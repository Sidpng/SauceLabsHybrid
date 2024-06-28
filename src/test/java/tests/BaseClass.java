/*
Author: Github: Sidpng
Project Info: Base class for SauceLabsHybrid for before and
              after steps related to its Regression testing.
 */
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	protected static WebDriver driver;    //Initialising Web driver variable
	protected ReadConfig readConfig = new ReadConfig();
	protected Global_Methods global = new Global_Methods();

	/*
		Setting up Before class with:
		1. Driver Interface to be used, here : Chrome.
		2. Hitting the base url.
		3. Setting the UI to full screen mode for better accessibility.
	*/
	@BeforeClass
	public void navigate_to_sauce_labs_homepage() {

		System.out.println("Initialising browser");
		driver = new ChromeDriver();
		driver.get(readConfig.getProperty("baseurl"));
		driver.manage().window().maximize();

	}

	/*
    Setting up After class with:
    1. Deleting cookies from previous session.
    2. Quitting all browser sessions to free up space,memory.
	*/
	@AfterClass
	public void closing_test_session() {

		driver.manage().deleteAllCookies();
		driver.quit();

	}
}
