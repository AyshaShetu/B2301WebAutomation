package qcc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    public static void main(String[] args) {
        logger.info("Hello!! Let's get calender info.");
        String url = "https://www.qcc.cuny.edu/academics/academic-calendars.html";

        // Get the current System Properties
        String systemProperties = System.getProperties().toString();
        logger.info(systemProperties);

        String driverPath = System.getProperty("user.dir") + "/driver/windows/chromedriver.exe";

        // Let's show the application where is the driver object
        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver(); // Chrome Browser Object
        // Open a new Chrome Window and browse to the website using URL
        driver.get(url);
        // Make my Chrome window little look good by maximizing the size
        driver.manage().window().maximize();
        // At first find the h2 element location, and now give me value/tag-value from h2 tag
        String heading = driver.findElement(new By.ByTagName("h2")).getText();
        logger.info(heading);

        List<WebElement> webElementList = driver.findElements(new By.ByTagName("h2"));
        String firstH2Value = webElementList.get(0).getText();

        logger.info(firstH2Value);

        // My Job is done. It's time to close the window
       // driver.close();
    }
}
