package com.izaanschool.heroku;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthTest {
    private static final Logger logger = LogManager.getLogger(BasicAuthTest.class);
    private static String TAB;
    WebDriver driver;  //instance level variable, everyone can use it
    String url = "http://the-internet.herokuapp.com/";
   private Alert alert;

    /** Problem Statement
    * 1) open http://the-internet.herokuapp.com
    * 2) click Basic Auth and open Basic Auth page
    * 3) a credential window should pop up to put credential.Username : admin and Password : admin
    * 4) click sign in and message will come for successful sign in
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
    public void testBasicAuth() throws InterruptedException {
        driver.findElement(By.linkText("Basic Auth")).click();
        logger.info("page opened");
       driver.switchTo().alert();
        String alertText = alert.getText();

        Thread.sleep(5000);
        logger.info("Alert message: " + alertText);
         //Create an alert object

        // Enter the username and password
        alert.sendKeys("admin");
        alert.sendKeys(BasicAuthTest.TAB);
        alert.sendKeys("admin");
        alert.accept();
          }

    private static Object getKeys() {
        Object Keys = TAB;
        return Keys;
    }

    @After
     public void cleanup(){
       driver.close();
    }


}

///// NOTE :



/////////////////////////////taneeza's/////////////////


//    @Test
//    public void basicAuthTest() throws InterruptedException {
//        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
//        //verify if we landed on the page or not by comparing the heading
//        String h3actual = driver.findElement(By.tagName("h3")).getText();
//        logger.info(h3actual);
//        String h3expect = "Basic Auth";
//        Assert.assertEquals(h3expect, h3actual);
//        logger.info("test passed");
//        Thread.sleep(10000);
//    }
////    @After
////    public void cleanup(){
////        driver.close();
////    }
//}
////////////////////////////////////////////////////////////////////



//
//        // Accept the alert
//        alert.accept();
//        // Verify that the user has been logged in successfully
//        boolean message;
//        driver.findElement(By.cssSelector(".example p")).getText().
//                then(function(message) {
//            if (message === "Congratulations! You must have the proper credentials.")
//                console.log('User logged in successfully!');
//            else {
//                console.log('Error logging in!');
//            }
//        }
//        driver.switchTo().alert().sendKeys('admin' + webdriver.Key.TAB + 'admin');
//        driver.switchTo().alert().accept();
//        driver.findElement(webdriver.By.css('.example p')).getText().then(function (text) {
//            assert.equal(text, 'Congratulations! You must have the proper credentials.');});

