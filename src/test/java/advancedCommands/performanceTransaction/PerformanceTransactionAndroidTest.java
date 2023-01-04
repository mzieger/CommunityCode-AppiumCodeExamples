package advancedCommands.performanceTransaction;

import advancedCommands.AndroidTestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


/**
 * Start Performance Transaction collects data on Duration, CPU, Battery, Memory, and Network traffic of the device.
 * The command must be used with the following EndPerformanceTransaction
 */
class PerformanceTransactionAndroidTest extends AndroidTestBase {

    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("testName", "Performance transaction test on Android device");
        dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        driver = new AndroidDriver<>(new URL(CLOUD_URL), dc);
    }

    @Test
    void performPerformanceTransaction() {
        driver.executeScript("seetest:client.startPerformanceTransaction",  "Monitor");
        driver.get("https://google.com");
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.click();
        searchBar.sendKeys("Experitest");
        searchBar.sendKeys(Keys.ENTER);
        driver.executeScript("seetest:client.endPerformanceTransaction", "Transaction Test");
    }
}
