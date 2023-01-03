package advancedCommands.setReportStatus;

import advancedCommands.AndroidTestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;

/**
 * Overrides the final report status
 */
class SetReportStatusAndroidTest extends AndroidTestBase {


    @BeforeEach
    public void before() throws MalformedURLException {
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
}
