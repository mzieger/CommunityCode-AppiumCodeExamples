package advancedCommands.performanceTransactionForApplication;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Start Performance Transaction collects data on Duration, CPU, Battery, Memory of the specified application on the device.
 * The Network traffic will be measured for the device, and not per application.
 * The command must be used with the following EndPerformanceTransaction
 */
class PerformanceTransactionForApplicationAndroidTest {

    AndroidDriver<AndroidElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    String CLOUD_URL = "<CLOUD_URL>" + "/wd/hub";

    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("accessKey", "<ACCESS_KEY>");
        dc.setCapability("appiumVersion", "<APPIUM_VERSION>");
        dc.setCapability("deviceQuery", "@os='android'");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,  "UiAutomator2");
        dc.setCapability("instrumentApp", true);
        dc.setCapability("testName", "Performance transaction for application test on Android device");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        driver = new AndroidDriver<>(new URL(CLOUD_URL), dc);
    }

    @Test
    void performPerformanceTransaction() {
        driver.executeScript("seetest:client.startPerformanceTransactionForApplication", "com.experitest.ExperiBank", "Monitor");
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");
        driver.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
        driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
        driver.executeScript("seetest:client.endPerformanceTransaction", "Transaction Test");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}
