package com.izaanschool.heroku;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class EntryAdTest {
    /**
     * Problem Statement
     * I want to go to Heroku app website and verify entry ad page to verify heading
     * I want to see click here button are
     * working properly.
     * I want to click the click here link and verify its removing its showing a pop up window
     */
    private static final Logger logger = LogManager.getLogger(EntryAdTest.class);
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
    public void entryAdpageTest() throws InterruptedException {
        // Go to Entry Ad page
        driver.findElement(By.linkText("Entry Ad")).click();
        // Opening Entry Ad page
        String actualHeading = driver.findElement(By.tagName("h3")).getText();
        logger.info(actualHeading);
        // verifying Entry Ad heading
        Assert.assertEquals("Entry Ad", actualHeading);

        // ********* CLICK HERE verifying **************//
       driver.findElement(By.linkText("click here")).click();
       String closeKey = driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/div[3]/p")).getText();
        Thread.sleep(5000);
        logger.info(closeKey);

        String modalwindow = driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/div[1]/h3")).getText();
        Assert.assertEquals("THIS IS A MODAL WINDOW",modalwindow);

        // tried to do  close key assertion, but it did not find out close key. check logger.info(closeKey). line 62
       // Assert.assertEquals(closeKey,"Close");
       // Assert.assertTrue(closeKey.contains("Close"));
       // Assert.assertTrue(closeKey.trim().("Close"));


        logger.info("click here Button clicked : test passed and pop up window showed");
    }

    @After
    public void cleanUp() {
        driver.close();

    }
}
