package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoginSuccess() {
        System.setProperty(
                "webdriver.chrome.driver",
                "/Users/preeyanshivangekar/Documents/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///Users/preeyanshivangekar/Documents/7.1P-resources-2/webservice1/src/main/resources/pages/login.html");

        sleep(2);
        driver.findElement(By.id("username")).sendKeys("ahsan");
        driver.findElement(By.id("passwd")).sendKeys("ahsan_pass");
        driver.findElement(By.id("dob")).sendKeys("1995-01-01");
        driver.findElement(By.cssSelector("[type=submit]")).submit();

        sleep(2);
        String title = driver.getTitle();
        Assert.assertEquals("success", title);

        driver.quit();
    }

    @Test
    public void testLoginSuccessAlice() {
        System.setProperty(
                "webdriver.chrome.driver",
                "/Users/preeyanshivangekar/Documents/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///Users/preeyanshivangekar/Documents/7.1P-resources-2/webservice1/src/main/resources/pages/login.html");

        sleep(2);
        driver.findElement(By.id("username")).sendKeys("alice");
        driver.findElement(By.id("passwd")).sendKeys("alice456");
        driver.findElement(By.id("dob")).sendKeys("1999-06-15");
        driver.findElement(By.cssSelector("[type=submit]")).submit();

        sleep(2);
        String title = driver.getTitle();
        Assert.assertEquals("success", title);

        driver.quit();
    }

    @Test
    public void testLoginFailInvalidPassword() {
        System.setProperty(
                "webdriver.chrome.driver",
                "/Users/preeyanshivangekar/Documents/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///Users/preeyanshivangekar/Documents/7.1P-resources-2/webservice1/src/main/resources/pages/login.html");

        sleep(2);
        driver.findElement(By.id("username")).sendKeys("john");
        driver.findElement(By.id("passwd")).sendKeys("wrongpass");
        driver.findElement(By.id("dob")).sendKeys("2000-12-12");
        driver.findElement(By.cssSelector("[type=submit]")).submit();

        sleep(2);
        String title = driver.getTitle();
        Assert.assertEquals("fail", title);

        driver.quit();
    }

    @Test
    public void testLoginFailInvalidDob() {
        System.setProperty(
                "webdriver.chrome.driver",
                "/Users/preeyanshivangekar/Documents/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///Users/preeyanshivangekar/Documents/7.1P-resources-2/webservice1/src/main/resources/pages/login.html");

        sleep(2);
        driver.findElement(By.id("username")).sendKeys("alice");
        driver.findElement(By.id("passwd")).sendKeys("alice456");
        driver.findElement(By.id("dob")).sendKeys("2001-01-01"); // Wrong DOB
        driver.findElement(By.cssSelector("[type=submit]")).submit();

        sleep(2);
        String title = driver.getTitle();
        Assert.assertEquals("fail", title);

        driver.quit();
    }
}
