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


public class JQueryMenuPageTest {
    private static final Logger logger = LogManager.getLogger(JQueryMenuPageTest.class);
    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/";
    /** Problem Statement
     *  open http://the-internet.herokuapp.com
     *  click hyperlink- JQuery UI Menus and open JQueryUI - Menu page
     *  a page should open with another hyperlink JQuery UI Menus
     *
     **  test 1 : verify JQuery UI - Menus with heading
     **  test 2 : a) click Enable --> download--> pdf and pdf downloaded should show.
     *            b) assert pdf is downloaded
     **  test 3 : a) click JQuery UI Menus a new page should open. Verify with heading
     *            b)
     *               i) verifying : search bar is working or not
     *              ii) click Search bar, write "test", click search button
     *              ii) verifying search result shows for test
     **  test 4 : a)
     *              i) Click "Demo"  and a page should show up with jQuery UI Demos heading. Verify heading
     *             ii) click draggable and verify
     *            iii) click droppable and verify
     *             iv) click resizable and verify
     *              v) click sortable and verify
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

        //click JQuery UI Menus and JQueryUI - Menu page open
        driver.findElement(By.linkText("JQuery UI Menus")).click();
        logger.info("JQuery UI Menus page opened");

        // Make my Chrome window little look good by maximizing the size
        driver.manage().window().maximize();

    }

              //********* test 1 - FAILED  (JQueryUI - Menu heading verifying)
    @Test
   public void verifyJQueryUIMenusheading() throws InterruptedException {
        // Verify JQuery UI - Menus with heading
        WebElement jQueryUIMenusheading = driver.findElement(By.tagName("h3"));
        String expectedHeading= jQueryUIMenusheading.getText();
        Assert.assertEquals(expectedHeading,"JQueryUI - Menu");
        logger.info("JQueryUI - Menu heading verifying failed");
        Thread.sleep(3000);
    }

            // test 2 : Passed
                         // a) click Enable --> download--> pdf and pdf downloaded should show.
                         // b) assert pdf is downloaded

    @Test
    public void testEnable() throws InterruptedException {
        // click "Enabled"

        driver.findElement(By.id("ui-id-2")).click();
        // click "Downloads"
        driver.findElement(By.id("ui-id-4")).click();
        //click "PDF"
        driver.findElement(By.id("ui-id-8")).click();
        logger.info("PDF MENU downloaded");

        // Verify PDF button
        String headingDownload = driver.findElement(By.id("ui-id-8")).getText();
        Assert.assertEquals(headingDownload,"Excel"); // ????????????????

    }
    @After
     public void cleanup () {
        driver.close();
    }
}



