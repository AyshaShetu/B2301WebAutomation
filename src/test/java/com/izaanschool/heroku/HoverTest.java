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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
public class HoverTest {
    /**
     * Problem Statement
     * open Hover page.
     * verify right page opened by heading verification
     * Hover over on the images to see if they are showing image caption and a hyperlink under the image
     * click on "View profile" hyperlink under image and see if it opens a new page.
     * Verify opening of new page by "Not Found" heading
     */

    private static final Logger logger = LogManager.getLogger(com.izaanschool.heroku.HoverTest.class);
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
    public void hoverTest() throws InterruptedException {
        // Go to Hovers page
        driver.findElement(By.linkText("Hovers")).click();
        // Opening Hovers page
        String actualHeading = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("Hovers", actualHeading);
        // click on Hovers
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).click();
        //Hovers page shows up
        Thread.sleep(8000);
        logger.info(" Hovers Page opens ");

        // click on image 3
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img")).click();
        // click on "view profile" under image 3
        driver.findElement(By.linkText("View profile")).click();
        // "view profile " click working fine amd open new page and "Not Found" displayed
        driver.findElement(By.tagName("h1")).isDisplayed();

        Thread.sleep(8000);
        String verifyHeading = driver.findElement(By.tagName("h1")).getText();

        // verifying "Not Found"
        Assert.assertEquals("Not Found", verifyHeading);
        }
    @After
    public void cleanup(){
       driver.close();
    }
}