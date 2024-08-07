/*
Author: GitHub: Sidpng
Project Info: Base class for SauceLabsHybrid for before and
              after steps related to its Regression testing.
 */
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.*;

public class BaseClass {

    protected final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    protected static WebDriver driver;    //Initialising Web driver variable

    {
        FileHandler fileHandler = null; // true for append mode
        try {
            String logDir = "src/test/resources/ExecutionLogs" + "_" + getClass().getSimpleName();
            Path logPath = Paths.get(logDir);
            if (!Files.exists(logPath)) {
                Files.createDirectories(logPath);
            }
            String logFile = logDir + "/" + getClass().getSimpleName() + ".log";
            fileHandler = new FileHandler(logFile, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        fileHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(fileHandler);
        LOGGER.setLevel(Level.ALL);
        LOGGER.setUseParentHandlers(false); // Prevents logging to the console twice
    }

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
        try {

            LOGGER.info("Initialising browser");
            driver = new ChromeDriver();
            driver.get(readConfig.getProperty("baseurl"));
            driver.manage().window().maximize();

        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "An error occurred during the test execution", e);

        }
    }

    /*
    Setting up After class with:
    1. Deleting cookies from previous session.
    2. Quitting all browser sessions to free up space,memory.
    */
    @AfterClass
    public void closing_test_session() {
        try {

            LOGGER.info("Quitting all browser sessions and deleting cookies generated in this session");
            driver.manage().deleteAllCookies();
            driver.quit();

        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "An error occurred during the test execution", e);

        }

    }
}
