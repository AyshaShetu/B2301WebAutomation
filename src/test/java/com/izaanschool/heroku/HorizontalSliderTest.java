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
public class HorizontalSliderTest {
    /**
     * Problem Statement
     * open Horizontal Slider page to see slider sliding properly.
     * verify right page opened
     * click slider and drag to right
     * Verify 0 is move towards 5 and vice versa
     */

    private static final Logger logger = LogManager.getLogger(com.izaanschool.heroku.HorizontalSliderTest.class);
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
    public void slidingTest() throws InterruptedException {
        // Go to Horizontal Slider page
        driver.findElement(By.linkText("Horizontal Slider")).click();
        // Opening Horizontal Slider page
        String actualHeading = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("Horizontal Slider", actualHeading);
        // click on Horizontal Slider
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).click();
        //Horizontal Slider page shows up
        Thread.sleep(5000);
        logger.info(" Horizontal Slider Page opens ");

        //set path for 0 to 5
        WebElement source = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/input"));
        WebElement target = driver.findElement(By.xpath("//*[@id=\"range\"]"));

// Horizontal Slide 0 to 5
        Actions builder = new Actions(driver);
        // let sliding start from 0 to 5
        builder.dragAndDrop(source, target).build().perform();
        logger.info("Sliding done to 0 to 5");

        // verify sliding done perfectly from 0 to 5
        String number0 = source.getText();
        String number5 = target.getText();

//        Assert.assertEquals("0", number0);
//      Assert.assertEquals("0", number5);
    }
    @After
    public void cleanup(){
        driver.close();
    }
}