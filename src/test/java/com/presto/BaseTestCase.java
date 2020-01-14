package com.presto;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.presto.LaunchBrowser;
public class BaseTestCase {

    @Parameters({"browserType", "appUrl", "driverPath"})
    @BeforeClass
    public void launchBrowser(String browserType, String appURL, String driverPath) throws InterruptedException {
        LaunchBrowser.setDriverPath(driverPath);
        LaunchBrowser.initializeTestBaseSetup(browserType, appURL);

    }
}