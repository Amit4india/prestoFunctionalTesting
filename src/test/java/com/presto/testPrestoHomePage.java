package com.presto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.ie.InternetExplorerDriver;
        import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class testPrestoHomePage {
    private WebDriver driver;

  @Test (priority = 0)
    public void PrestoHomePage() throws InterruptedException, MalformedURLException {
      System.out.println("Verifying the Login page");
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\amit5india\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
        driver.get("https://almsmart.demos.hclets.com/Presto/login-portal.jsp");
        String classname = driver.findElement(By.className("well")).getText();
      System.out.println("Getting Text from the Presto Login page for Jenkins Manual Verification >>>");
        System.out.println(classname);
        Assert.assertTrue(classname.contains("Welcome to Secure Login Portal"));
        System.out.println("Successfully verify the Presto Login page");
    }

    @Test (priority = 1)
    public void PrescottPage() throws InterruptedException, MalformedURLException {
        System.out.println("Verifying the Presto About section");
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        System.out.println("Navigating the Presto home page. Verifying the element");
//
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\amit5india\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
        driver.get("https://almsmart.demos.hclets.com/Presto/about-us.jsp");
        String classname = driver.findElement(By.className("well")).getText();
        System.out.println("Getting Text from the Presto About page for Jenkins Manual Verification");
        System.out.println(classname);
        Assert.assertTrue(classname.contains("Our Profile"));
        System.out.println("Successfully verified the Tab >About page");
    }
}

