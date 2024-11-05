import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.time.Duration;

public class SeleniumTest {
    private WebDriver webDriver;

    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");//linux_64

        // Get file
        File file = new File("src/main/index.html");
        String path = "file://" + file.getAbsolutePath();

        // Create a new ChromeDriver instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        webDriver = new ChromeDriver(options);

        // Open the HTML file
        webDriver.get(path);
    }

    @After
    public void tearDown() {
        // Close the browser
        webDriver.quit();
    }

    @Test
    public void testPageText() throws InterruptedException {
        //setup
    WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    WebElement speechPart1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opening")));
    WebElement speechPart2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("theRest")));
    String opening = "To be, or not to be, that is the question:";
    String theRest = "Whether 'tis nobler in the mind to suffer";

    // Assertions
    Assert.assertEquals(opening, speechPart1.getText());
    Assert.assertEquals(theRest, speechPart2.getText().substring(0, 41));
}

    }



