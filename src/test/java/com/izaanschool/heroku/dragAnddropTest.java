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

public class dragAnddropTest {
    /**
     * Problem Statement
     * verify the drag and drop page to see drag and drop
     * working properly.
     * click and drag the A file and drop on B file
     * Verify A and B file swapped
     * */

    private static final Logger logger = LogManager.getLogger(com.izaanschool.heroku.dragAnddropTest.class);
    WebDriver driver;  //instance level variable, everyone can use it
    String url = "http://the-internet.herokuapp.com/";

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
    public void dragAndDropTest() throws InterruptedException {
        // Go to Drag and Drop page
        driver.findElement(By.linkText("Drag and Drop")).click();
        // Opening Drag and Drop page
        String actualHeading = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("Drag and Drop", actualHeading);
        // click on Drag and Drop
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).click();
        //Drag and Drop page shows up
        //Thread.sleep(5000);
        logger.info(" Drag and Drop Page opens ");

        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

// Drag and drop A file to B file
        Actions builder = new Actions(driver);
        builder.dragAndDrop(source, target).build().perform();

// Verify A file and B file swapped their place
        String columnAText = source.getText();
        String columnBText = target.getText();

        Assert.assertEquals("A", columnAText);    // changed B = A then passed
        Assert.assertEquals("B", columnBText);    // changed A = B then passed



//        WebElement source = driver.findElement(By.id("column-a"));
//        WebElement target = driver.findElement(By.id("column-b"));
//
//        // Drag and drop A file to B file
//        Actions builder = new Actions(driver);
//        Action dragAndDrop = builder.clickAndHold(source)
//                .moveToElement(target)
//                .release(target)
//                .build();
//        dragAndDrop.perform();
//
//        // Verify A file and B file swapped their place
//        String columnAText = source.getText();
//        String columnBText = target.getText();
//
//        Assert.assertEquals("B", columnAText);
//        Assert.assertEquals("A", columnBText);

//        List <org.openqa.selenium.WebElement> elements = driver.findElements(By.cssSelector("#column-a"));
//        org.openqa.selenium.WebElement source = elements.get(0);
//        List <org.openqa.selenium.WebElement> targets = driver.findElements(By.cssSelector("#column-b"));
//        org.openqa.selenium.WebElement target = targets.get(0);
//        (new org.openqa.selenium.interactions.Actions(driver)).dragAndDrop(source, target).perform();
//        Thread.sleep(5000);
//        String columnAText = source.getText();
//        String columnBText = target.getText();
//        Assert.assertEquals("A", columnBText);
//        Assert.assertEquals("B", columnAText);
    }

    @After
    public void cleanUp(){
        driver.close();
    }
    }
////////////////////////////////////*******************************/////////////////////////////////////////////////////

                  ////this is test passed but no drag down/////////////
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
//
//import static org.junit.Assert.assertEquals;
//
//public class dragAnddropTest {
//    private static final Logger logger = LogManager.getLogger(com.izaanschool.heroku.dragAnddropTest.class);
//    WebDriver driver;
//    String url = "http://the-internet.herokuapp.com/";
//
//    @Before
//    public void beforeTest() {
//        String systemProperties = System.getProperties().toString();
//        logger.info(systemProperties);
//        String driverPath = System.getProperty("user.dir") + "/driver/windows/chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver", driverPath);
//        driver = new ChromeDriver(); // Chrome Browser Object
//        driver.get(url);
//        driver.manage().window().maximize();
//    }
//
//    @Test
//    public void dragAndDropTest() throws InterruptedException {
//        driver.findElement(By.linkText("Drag and Drop")).click();
//        String actualHeading = driver.findElement(By.tagName("h3")).getText();
//        assertEquals("Drag and Drop", actualHeading);
//        Thread.sleep(5000);
//        WebElement source = driver.findElement(By.id("column-a"));
//        WebElement target = driver.findElement(By.id("column-b"));
//
//        // Drag and drop A file to B file
//        Actions builder = new Actions(driver);
//        Action dragAndDrop = builder.clickAndHold(source)
//                .moveToElement(target)
//                .release(target)
//                .build();
//        dragAndDrop.perform();
//
//        // Verify A file and B file swapped their place
//        String columnAText = source.getText();
//        String columnBText = target.getText();
//
//        assertEquals("A", columnAText);
//        assertEquals("B", columnBText);
//
//    }
//
//    @After
//    public void cleanUp () {
//        driver.close();
//    }
//}
