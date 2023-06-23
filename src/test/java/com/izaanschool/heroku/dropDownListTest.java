package com.izaanschool.heroku;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropDownListTest {
    /**
     * Problem Statement
     * I want to go to Heroku app website and verify the dropdown page dropdown button is
     * working properly.
     * I want to click Option 2 and verify that Option 2 is checked and showed in list bar
     * */

    private static final Logger logger = LogManager.getLogger(CheckBoxesPageTest.class);
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
    public void dropDownTest() throws InterruptedException {
        // Go to Dropdown List page
        driver.findElement(By.linkText("Dropdown")).click();
        // // Opening Dropdown List page
        String actualHeading = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("Dropdown List",actualHeading);
        driver.findElement(By.xpath("//*[@id=\"dropdown\"]")).isSelected();
        // Stop execution for 5 sec
        Thread.sleep(5000);
        logger.info(" Dropdown page opens ");


        // showing Dropdown list before selecting option
       Boolean opt2Selection = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]")).isDisplayed();
        // boolean because .isSelected() is a boolean
        // Verify actualStatus is true - > Box is checked
        //Assert.assertTrue(actualStatus);
        Assert.assertEquals(true,opt2Selection);
        logger.info(" Checked Option 2 Passed ");



       // *********  selecting option 2 *********

        // show dropdown page to select
        driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]")).click();

        // option 2 selected and showed
       boolean actualUncheckedStatus = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]")).isSelected();
        Assert.assertEquals(true,actualUncheckedStatus);
        logger.info(" Option 2 selected showing ");

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

