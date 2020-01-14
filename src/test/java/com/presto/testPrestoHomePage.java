package com.presto;
import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.ie.InternetExplorerDriver;
        import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Parameters;
        import org.testng.annotations.Test;

public class testPrestoHomePage
{
    @Test
       public void PrestoHomePage() throws InterruptedException {
       // System.setProperty("webdriver.chrome.driver", "C:\\Users\\amit5india\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://almsmart.demos.hclets.com/Presto/");

}

}