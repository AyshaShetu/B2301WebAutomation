package com.izaanschool.heroku;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.By.xpath;

public class dynamicContentTest {
    /**
     * Problem Statement
     * I want to go to Heroku app website and verify Dynamic Content page
     * I want to see "click here" button is working properly and showing new content.
     */
    private static final Logger logger = LogManager.getLogger(com.izaanschool.heroku.addRemoveElementTest.class);
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
    public void dynamicContentTest() throws InterruptedException {
        // Go to Dynamic Content page
        driver.findElement(By.linkText("Dynamic Content")).click();
        // verifying Dynamic Content page
        String actualHeading = driver.findElement(By.tagName("h3")).getText();
        logger.info(actualHeading);
        // verifying Dynamic Content heading
        Assert.assertEquals("Dynamic Content", actualHeading);

        // ********* CLICK HERE button verifying **************//
        driver.findElement(By.linkText("click here")).click();
        String dynamicHeading = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals("Dynamic Content",dynamicHeading);
        Thread.sleep(5000);
        logger.info("Click here Button clicked : test passed");
    }
    @After
    public void cleanUp() {
        driver.close();

    }
}
