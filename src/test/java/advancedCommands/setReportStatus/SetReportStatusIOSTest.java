package advancedCommands.setReportStatus;

import advancedCommands.IOSTestBase;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SetReportStatusIOSTest extends IOSTestBase {

    private static final String SEETEST_CLIENT_SET_REPORT_STATUS = "seetest:client.setReportStatus";

    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("testName", "Set Report status test on iOS device");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new IOSDriver<>(new URL(CLOUD_URL), dc);
    }

    @Test
    public void changeFailedToPassed() {
        stepWhichFails();
        driver.executeScript(SEETEST_CLIENT_SET_REPORT_STATUS, "Passed", "passed-message");
    }

    @Test
    public void setFailed() {
        driver.executeScript(SEETEST_CLIENT_SET_REPORT_STATUS, "Failed", "failed-message",
                "failure-stacktrace");
    }

    @Test
    public void setSkipped() {
        driver.executeScript(SEETEST_CLIENT_SET_REPORT_STATUS, "Skipped", "skipped-message");
    }


    private void stepWhichFails() {
        NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> driver.findElementById("some-not-existing-id"));
        assertEquals("NoSuchElementException", e.getClass().getSimpleName());
    }

}
