package advancedCommands.harRecording;

import advancedCommands.AndroidTestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;

/**
 * Start/Stop capture HAR during specific transactions for a cloud device. The capture will start when startHarRecording is executed.
 * The capture will stop when stopHarRecording is executed or the device is released.
 */
class HarRecordingAndroidTest extends AndroidTestBase {

    @BeforeEach
    public void before() throws MalformedURLException {

        dc.setCapability("testName", "Har recording test on Android device");
        dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        driver = new AndroidDriver<>(new URL(CLOUD_URL), dc);
    }

    @Test
    void performHarRecording() {
        driver.executeScript("seetest:client.startHarRecording",  "cloud:<FILE_UNIQUE_NAME>" + ".HAR");
        driver.get("https://google.com");
        driver.executeScript("seetest:client.stopHarRecording");
    }

}
