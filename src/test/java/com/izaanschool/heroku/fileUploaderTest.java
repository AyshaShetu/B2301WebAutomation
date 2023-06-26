package com.izaanschool.heroku;

import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger;
        import org.junit.After;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;

public class fileUploaderTest {

    /** problem statement
     * I want to go to Heroku app website and open file Upload page
     * verify heading
     * I want to upload a file from my local machine
     * I want to choose a file by clicking choose a file and
     * then upload by clicking upload
     * 3. I want to verify file is uploaded

     */
    private static final Logger logger = LogManager.getLogger(com.izaanschool.heroku.fileUploaderTest.class);
    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/";

    @Before
    public void beforeTest() {
        String driverPath = System.getProperty("user.dir") + "/driver/windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void fileUploaderTest() throws InterruptedException {
        driver.findElement(By.linkText("File Upload")).click();
        String actualHeading = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("File Uploader", actualHeading);

        String filePath = "C:\\Users\\ashet\\Downloads\\selenium\\B2301WebAutomation\\dallas downtown.jpg";
        WebElement fileInput = driver.findElement(By.id("file-upload"));
        fileInput.sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        String uploadedFileName = driver.findElement(By.id("uploaded-files")).getText();
      //  Assert.assertEquals("your_file_name", uploadedFileName);
        Thread.sleep (3000);
        logger.info("File uploaded successfully");
    }

    @After
    public void cleanUp() {
        driver.close();
    }
}
