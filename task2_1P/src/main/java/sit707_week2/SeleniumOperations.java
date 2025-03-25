package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class SeleniumOperations {
    
    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

     public static void officeworks_registration_page(String url) {
        // Step 1: Locate chrome driver folder in the local drive.
        System.setProperty("webdriver.chrome.driver", "/Users/preeyanshivangekar/Documents/chromedriver-mac-arm64/chromedriver"); // Update the path

        // Step 2: Use the above chrome driver to open up a chromium browser.
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();
        
        System.out.println("Driver info: " + driver);
        
        sleep(2);
    
        // Load a webpage in chromium browser.
        driver.get(url);
        
        // Find the first input field which is firstname
        WebElement element1 = driver.findElement(By.id("firstname"));
        System.out.println("Found element: " + element1);
        element1.sendKeys("Pree");
        
        // Find following input fields and populate with values
        WebElement element2 = driver.findElement(By.id("lastname"));
        System.out.println("Found element: " + element2);
        element2.sendKeys("Shivangekar");
        
        WebElement element3 = driver.findElement(By.id("phoneNumber"));
        System.out.println("Found element: " + element3);
        element3.sendKeys("000122232");
        
        WebElement element4 = driver.findElement(By.id("email"));
        System.out.println("Found element: " + element4);
        element4.sendKeys("pree@gmail.com");
        
        WebElement element5 = driver.findElement(By.id("password"));
        System.out.println("Found element: " + element5);
        element5.sendKeys("555");
        
        WebElement element6 = driver.findElement(By.id("confirmPassword"));
        System.out.println("Found element: " + element6);
        element6.sendKeys("000");
        
        // Identify button 'Create account' and click to submit using Selenium API.
        WebElement element7 = driver.findElement(By.cssSelector("button[data-testid='account-action-btn']"));
        System.out.println("Found element: " + element7);
        element7.click();
    
        // Take screenshot using selenium API.
        takeScreenshot(driver, "/Users/preeyanshivangekar/Documents/SIT707/task2_1P/officeworks_screenshot.png");
        
        // Sleep a while
        sleep(3);
        
        // close chrome driver
        driver.close();    
    }
    
    public static void bunningswarehouse(String url) {
        // Step 1: Locate chrome driver folder in the local drive.
        System.setProperty("webdriver.chrome.driver", "/Users/preeyanshivangekar/Documents/chromedriver-mac-arm64/chromedriver"); // Update the path

        // Step 2: Use the above chrome driver to open up a chromium browser.
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();
        
        System.out.println("Driver info: " + driver);
        
        sleep(2);
    
        // Load a webpage in chromium browser.
        driver.get(url);
        
        WebElement element1 = driver.findElement(By.id("uid"));
        System.out.println("Found element: " + element1);
        element1.sendKeys("Pree@gmail.com");
        
        WebElement element2 = driver.findElement(By.id("password"));
        System.out.println("Found element: " + element2);
        element2.sendKeys("hello");
        
        WebElement element3 = driver.findElement(By.id("firstName"));
        System.out.println("Found element: " + element3);
        element3.sendKeys("Pree");
        
        WebElement element4 = driver.findElement(By.id("lastName"));
        System.out.println("Found element: " + element4);
        element4.sendKeys("Pree");
        
        WebElement element5 = driver.findElement(By.cssSelector("button[data-locator='input_CreateAccount']"));
        System.out.println("Found element: " + element5);
        element5.click();
        // Take screenshot using selenium API.
        takeScreenshot(driver, "/Users/preeyanshivangekar/Documents/SIT707/task2_1P/bunnings_screenshot.png");
        
        // Sleep a while
        sleep(3);
        
        // close chrome driver
        driver.close();    
    }
    
    public static void takeScreenshot(WebDriver driver, String filePath) {
        // Cast the driver to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Capture the screenshot as a file
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Create the destination file
        File destFile = new File(filePath);
        
        // Ensure the directory exists
        destFile.getParentFile().mkdirs();

        // Copy the screenshot file to the destination
        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved to: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }

}