package qcc;

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

public class GetQccCalenderData {

    /**
     * 1. Go to Queens College website
     * 2. Get the calendar information
     * 3. Find out if there is any special event for today
     * 4. Notify Nazrul about the information via email
     * */
    private static final Logger logger = LogManager.getLogger(GetQccCalenderData.class);
    WebDriver driver;  //instance level variable, everyone can use it

    /**
     * Let's write a method to open the browser and do necessary setup (maximize) before a test run
     * This method will run before every time a test runs
     */

    @Before
    public void beforeTest(){

        logger.info("Hello!! Let's get calender info.");
        String url = "https://www.qcc.cuny.edu/academics/academic-calendars.html";

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
    public void getCalenderDataTest(){
//
        // At first find the h2 element location, and now give me value/tag-value from h2 tag
        String actualHeading = driver.findElement(new By.ByTagName("h2")).getText();
        logger.info(actualHeading);

        String expectedValue = "Spring 2023 (1/25/2023 – 5/23/2023)";
        Assert.assertEquals(expectedValue, actualHeading ); //select -> assetEquals: long expected, long actual

//       List<WebElement> webElementList = driver.findElements(new By.ByTagName("h2"));
//
//           //1stH2Value
//        String firstH2Value = webElementList.get(0).getText();
//        logger.info(firstH2Value);
//
//          //2ndH2Value
//        String secondH2Value = webElementList.get(1).getText();
//        logger.info(secondH2Value);
//
//         //3rdH2Value
//        String thirdH2Value = webElementList.get(2).getText();
//        logger.info(thirdH2Value);
//
//          //4thH2value
//        String fourthH2Value = webElementList.get(3).getText();
//        logger.info(fourthH2Value);

        // My Job is done. It's time to close the window
  //      driver.close();
    }


    @Test
    public void allH2HeadingTest(){
        logger.info("******* allHeadingTest() *********");

        List<WebElement> webElementList = driver.findElements(new By.ByTagName("h2"));
        String secondH2Value = webElementList.get(1).getText();
        logger.info("second H2 Value verified");
         // Summer 2023 (5/30/2023 - 8/18/2023)
         // Fall 2023 (8/25/2023 - 12/20/2023)

        Assert.assertEquals("Summer 2023 (5/30/2023 – 8/18/2023)",secondH2Value);
        Assert.assertEquals("Fall 2023 (8/25/2023 – 12/20/2023)",webElementList.get(2).getText());
        logger.info("Third H2 Value verified");
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
