package com.izaanschool.heroku;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.xpath;

public class ContextMenuPageTest {
    /**
     * Problem Statement
     * I want to go to Heroku app website and verify the Context Menu page is opened
     * I want to check Right-click in the box working properly and it's popping up a message window.
     * if click ok on message, it will show a menu bar
     * */

    private static final Logger logger = LogManager.getLogger(CheckBoxesPageTest.class);
    WebDriver driver;  //instance level variable, everyone can use it
    String url = "http://the-internet.herokuapp.com/";
   // String titleIs = "Context Menu";
    /**
     * Let's write a method to open the browser and do necessary setup (maximize) before a test run
     * This method will run before every time a test runs
     */

    @Before
    public void beforeTest(){

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
    public void contextMenuTest() throws InterruptedException {
        // Go to Context Menu page
        driver.findElement(By.linkText("Context Menu")).click();
        // // Opening Context Menu page
        String actualHeading = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("Context Menu",actualHeading);
        driver.findElement(xpath("//*[@id=\"hot-spot\"]")).click();
        // Stop execution for 5 sec
        Thread.sleep(5000);
        logger.info(" Context Menu page opens ");

        driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        WebElement box = driver.findElement(By.id("hot-spot"));;
        actions.contextClick(box).perform();
        logger.info("Right-clicked on the box");
       Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        Thread.sleep (5000);
        logger.info("Alert message: " + alertText);
    }

    /**
     * Let's write a method to close the browser as soon as a test is completed (pass/fail)
     * This method will run after every time a test runs
     */
    @After
    public void cleanUp(){
        driver.close();
    }
}

