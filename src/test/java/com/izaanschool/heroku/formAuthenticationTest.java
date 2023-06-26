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

import static com.beust.jcommander.JCommander.getConsole;
import static jdk.nashorn.internal.objects.NativeFunction.function;
import static org.apache.logging.log4j.util.Chars.TAB;
import static org.openqa.selenium.Keys.*;

public class formAuthenticationTest {
    private static final Logger logger = LogManager.getLogger(formAuthenticationTest.class);
    private static String TAB;
    WebDriver driver;  //instance level variable, everyone can use it
    String url = "http://the-internet.herokuapp.com/";
    private Alert alert;
    /** Problem Statement
     * 1) open http://the-internet.herokuapp.com
     * 2) click FORM AUTHENTICATION and open FORM AUTHENTICATION page
     * 3) a page should open to put credential where Username : tomsmith and Password : SuperSecretPassword!
     * 4) I want click LOGIN and message will come for successful sign in
     * I want to verify clicking logout button takes to login page
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
        //click form authentication and log in page open
        driver.findElement(By.linkText("Form Authentication")).click();
        logger.info("Form Authentication page opened");

        // open login page heading
        String loginHeading = driver.findElement(By.tagName("h2")).getText();
        logger.info("log in page opened");

        // verifying heading
        Assert.assertEquals(loginHeading, "Login Page");
        logger.info("page opened, heading verified");


        //Code to get Username and password box
        WebElement username= driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement password= driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement login=driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        Thread.sleep(3000);

         // Putting Credential
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        // click log in
        driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();
        Thread.sleep(3000);

//         // verifying Logging confirmation
//        String message = driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
//        Assert.assertEquals(true,message);

//        // verifying logout button
//        WebElement logoutButton = driver.findElement(By.xpath("xpath: //i[@class='icon-2x icon-signout']]"));
//        Assert.assertEquals(logoutButton, "Logout");
    }
        @After
        public void cleanup () {
           driver.close();
        }
    }

