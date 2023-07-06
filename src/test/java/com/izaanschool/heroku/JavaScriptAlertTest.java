package com.izaanschool.heroku;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class JavaScriptAlertTest {
    private static final Logger logger = LogManager.getLogger(formAuthenticationTest.class);
    private static String TAB;
    WebDriver driver;  //instance level variable, everyone can use it
    String url = "http://the-internet.herokuapp.com/";
    private Alert alert;
    /** Problem Statement
     *  open http://the-internet.herokuapp.com
     *  click JavaScript Alerts and open JavaScript Alerts page
     *  a page should open showing 3 button to click
     * I want click "Click for JS Promp" and pop up window should show up with fillup tab
     * I want to write "javahero" and click ok
     * Result should show
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
    public void testformAuth() throws InterruptedException {
        //click form authentication and form authentication page open
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        logger.info("JavaScript Alert page opened");

        // click "CLICK FOR JS PROMPT"
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
        // Write "javahero" inside pop up tab
        alert = driver.switchTo().alert();
        alert.sendKeys("javahero");
        alert.accept();

        // Verify Result message
        WebElement resultMessage = driver.findElement(By.id("result"));
        Assert.assertEquals(resultMessage.getText(), "You entered: javahero");
        Thread.sleep(3000);
    }
    @After
    public void cleanup () {
        driver.close();
    }
}


