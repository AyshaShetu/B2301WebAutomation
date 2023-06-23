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

public class addRemoveElementTest {

    /**
     * Problem Statement
     * I want to go to Heroku app website and verify the add/remove element page to see add element button is
     * working properly.
     * I want to click the add element box and verify that delete button is showing
     * I also want to check clicking delete button is deleting successfully and not showing anymore
     * */

    private static final Logger logger = LogManager.getLogger(com.izaanschool.heroku.addRemoveElementTest.class);
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
    public void addElementTest() throws InterruptedException {
        // Go to Add/Remove Elements page
        driver.findElement(By.linkText("Add/Remove Elements")).click();
        // Opening add remove element page
        String actualHeading = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("Add/Remove Elements",actualHeading);
        // click on add element
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
        // Stop execution for 5 sec
        //Delete button should show
        Thread.sleep(5000);
        logger.info(" add removal Page opens ");


          // Appearing delete button
        Boolean deleteButtonStatus = driver.findElement(By.xpath("//*[@id=\"elements\"]/button")).isDisplayed();
        Assert.assertEquals(true, deleteButtonStatus);
        //Assert.assertEquals(true,deleteButtonStatus);
        logger.info(" delete button shows ");

       // Removing Delete button
       // Verify deleteButtonStatus is clicked - > Delete button is disappeared
        driver.findElement(By.className("added-manually")).click();
       boolean deleteButtonRemove = driver.findElement(By.xpath("//*[@id=\"elements\"]")).isDisplayed();
      Assert.assertEquals(true,deleteButtonRemove);
       logger.info(" delete button removed ");

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
