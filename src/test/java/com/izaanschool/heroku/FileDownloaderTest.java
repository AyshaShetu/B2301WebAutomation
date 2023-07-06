package com.izaanschool.heroku;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownloaderTest {

    /** problem statement
     * I want to go to Heroku app website and open file Downloader  page
     * verify heading
     * I want to download a file by clicking on the given link
     * I want to verify file is uploaded

     */
    private static final Logger logger = LogManager.getLogger(com.izaanschool.heroku.FileDownloaderTest.class);
    WebDriver driver;
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
    public void fileDownloadingTest() throws InterruptedException {
        //go to file downloader page by clicking  hyperlink
        driver.findElement(By.linkText("File Download")).click();
        //verify if the page opened properly
        String actualHeading = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actualHeading, "File Downloader");
        logger.info("File Downloader page opened");

        //locate file to download
        WebElement fileDownload =driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[7]"));
        //click to download
        fileDownload.click();

        Thread.sleep(8000);

    }
    @After
    public void cleanup(){
        driver.close();
    }
}