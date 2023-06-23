package com.izaanschool.heroku;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class brokenImagePageTest {
    /**
     * Problem Statement
     * I want to go to Heroku app website and verify the Broken Images page is opened
     * verify first image is showing broken
     * */

    private static final Logger logger = LogManager.getLogger(brokenImagePageTest.class);
    WebDriver driver;  //instance level variable, everyone can use it
    String url = "http://the-internet.herokuapp.com/";

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
    public void brokenImageTest() throws InterruptedException {
        // Go to http://the-internet.herokuapp.com page
        driver.findElement(By.linkText("Broken Images")).click();
        // // Opening Broken Images page
        String actualHeading = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("Broken Images", actualHeading);
       Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).click();
        logger.info(" **** Broken Images page opens ***** ");

        // ****** Verify that the first image is broken *********
        boolean isImageBroken;
        if (driver.findElement(By.tagName("img")).getAttribute("src").endsWith("asdf.jpg")) isImageBroken = true;
        else isImageBroken = false;
        assertEquals(false, isImageBroken);
        Thread.sleep(5000);
        logger.info("The first image is broken.");

        // ********** verify 3rd img is okay ***********
        boolean isImageOkay = driver.findElements(By.tagName("img")).size() >= 3 ? !driver.findElements(By.tagName("img")).get(2).getAttribute("src").endsWith("asdf.jpg") : true;
        assertEquals(true, isImageOkay);
        Thread.sleep(5000);
        logger.info("The third image is okay.");
    }
                      //The size() method returns the number of elements that match the specified locator.
                     // In this case, driver.findElements(By.tagName("img")).size() returns the number of img
                     // elements on the page. The >= 3 part checks if there are at least three images on the
                    // page before trying to access the third image.
                   // This is necessary to avoid an IndexOutOfBoundsException error if there are fewer than
                  // three images on the page.
                  // The ! operator is used to negate the result of the endsWith() method, so that isImageBroken
                  // is set to false if the third image’s source does not end with “asdf.jpg”.

        @After
        public void cleanUp () {
        driver.close();
        }
    }


