package com.izaanschool.heroku;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AbTestControlTest {
    /**
     * Problem Statement
     * I want to go to Heroku app website and verify the A/B Testing page is opening properly.
     * I want to verify the heading of that page
     */

    private static final Logger logger = LogManager.getLogger(AddRemoveElementTest.class);
    WebDriver driver;  //instance level variable, everyone can use it
    String url = "http://the-internet.herokuapp.com/";

    @Before
    public void beforeTest() {

        // Get the current System Properties
        String systemProperties = System.getProperties().toString();
        logger.info(systemProperties);

        String driverPath = System.getProperty("user.dir") + "/driver/windows/chromedriver.exe";

        // Let's show the application where is the driver object
        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver(); // Chrome Browser Object
        // Open a new Chrome Window and browse to the website using URL
        driver.get(url);
        // Make my Chrome window little look good by maximizing the size
        driver.manage().window().maximize();

    }

    @Test
    public void abTest() throws InterruptedException {
        // Go to A/B Testing control page
        driver.findElement(By.linkText("A/B Testing")).click();
        // Opening A/B Testing control page
        String actualHeading = driver.findElement(By.tagName("h3")).getText();
        logger.info(actualHeading);

        // verifying heading
        Assert.assertEquals("A/B Test Control", actualHeading);

        // Stop execution for 5 sec
        Thread.sleep(5000);
        logger.info(" test passed : A/B Testing control Page opens ");
    }

    @After
    public void cleanUp() {
        driver.close();

    }
}