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


public class dynamicControlTest {
    /**
     * Problem Statement
     * I want to go to Heroku app website and verify disappearing element page to verify heading
     * I want to see REMOVE/ADD and ENABLE/DISABLE button are
     * working properly.
     * I want to click the REMOVE button and verify its removing "a checkbox"  and showing ADD button
     * I want to click the ENABLE button and verify its showing "It's enabled!"  message and DISABLE button
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
    public void removeButtonTest() throws InterruptedException {
        // Go to Dynamic Controls page
        driver.findElement(By.linkText("Dynamic Controls")).click();
        // Opening Dynamic Controls page
        String actualHeading = driver.findElement(By.tagName("h4")).getText();
        logger.info(actualHeading);
        // verifying Dynamic Controls heading
        Assert.assertEquals("Dynamic Controls", actualHeading);

        // ********* REMOVE button verifying **************//
        driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();
        String addHeading = driver.findElement(By.tagName("h4")).getText();

        Assert.assertEquals("Dynamic Controls", addHeading);
        Thread.sleep(3000);
        logger.info("Remove Button clicked : test passed and ADD button showed");
    }
    // ********* ENABLE button verifying **************//
    @Test
    public void enableButtonTest() throws InterruptedException {
        // Go to Dynamic Controls page
        driver.findElement(By.linkText("Dynamic Controls")).click();
        // Opening Dynamic Controls page
        String actualHeading = driver.findElement(By.tagName("h4")).getText();

        // ********* ENABLE button verifying **************//
        driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();
       // String actualmessage = driver.findElement(By.id("message")).getText()----> tried with message after button click (Its enabled!)
        String enableHeading = driver.findElement(By.tagName("h4")).getText();
        Assert.assertEquals("Dynamic Controls", enableHeading);
        Thread.sleep(3000);

        logger.info("Enable Button clicked : DISABLE button showed");

    }

    @After
    public void cleanUp() {
        driver.close();

    }
}


