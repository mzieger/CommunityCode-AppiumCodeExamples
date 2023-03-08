package advancedCommands.setReportStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Overrides the final report status
 */
class SetReportStatusAndroidTest {

    AndroidDriver<AndroidElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    final String CLOUD_URL = "<CLOUD_URL>" + "/wd/hub";
    final String ACCESS_KEY = "<ACCESS_KEY>";
    final String APPIUM_VERSION = "<APPIUM_VERSION>";


    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("accessKey", ACCESS_KEY);
        dc.setCapability("appiumVersion", APPIUM_VERSION);
        dc.setCapability("deviceQuery", "@os='android'");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,  "UiAutomator2");
        dc.setCapability("testName", "Set Report status test on Android device");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        driver = new AndroidDriver<>(new URL(CLOUD_URL), dc);
    }

    @Test
    void setPassed() {
        driver.executeScript("seetest:client.setReportStatus", "Passed", "passed-message");
    }

    @Test
    void setFailed() {
        driver.executeScript("seetest:client.setReportStatus", "Failed", "failed-message",
                "failure-stacktrace");
    }

    @Test
    void setSkipped() {
        driver.executeScript("seetest:client.setReportStatus", "Skipped", "skipped-message");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
