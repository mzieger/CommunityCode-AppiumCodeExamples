package advancedCommands.setReportStatus;

import advancedCommands.IOSTestBase;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;

/**
 * Overrides the final report status
 */
class SetReportStatusIOSTest extends IOSTestBase {


    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("testName", "Set Report status test on iOS device");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new IOSDriver<>(new URL(CLOUD_URL), dc);
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
