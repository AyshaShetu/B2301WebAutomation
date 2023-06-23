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



public class disAppearingElementTest {

    /**
     * Problem Statement
     * I want to go to Heroku app website and verify the add/remove element page to see add element button is
     * working properly.
     * I want to click the add element box and verify that delete button is showing
     * I also want to check clicking delete button is deleting successfully and not showing anymore
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
    public void disappearingElementsTest() throws InterruptedException {
        // Go to Disappearing Elements page
        driver.findElement(By.linkText("Disappearing Elements")).click();
        // Opening Disappearing Elements page
        String actualHeading = driver.findElement(By.tagName("h3")).getText();
        logger.info(actualHeading);
        // verifying Disappearing Elements heading
        Assert.assertEquals("Disappearing Elements", actualHeading);

        // ********* PORTFOLIO button verifying **************//
        driver.findElement(By.linkText("Portfolio")).click();
        String portfolioHeading = driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals("Not Found", portfolioHeading);
        Thread.sleep(5000);
        logger.info("portfolio Button clicked : test passed");
    }
        // ********* HOME button verifying **************//
@Test
    public void homeTest() throws InterruptedException {
    driver.findElement(By.linkText("Disappearing Elements")).click();

    driver.findElement(By.linkText("Home")).click();
        String HomeHeading = driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals("Welcome to the-internet", HomeHeading);
        Thread.sleep(3000);
        logger.info("home Button clicked : test passed");

    }

    @After
    public void cleanUp() {
        driver.close();

    }
}
