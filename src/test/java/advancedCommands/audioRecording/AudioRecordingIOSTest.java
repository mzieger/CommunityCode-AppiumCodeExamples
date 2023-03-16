package advancedCommands.audioRecording;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Start Recording to a file, from the device.
 */
class AudioRecordingIOSTest {

    IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    final String CLOUD_URL = "<CLOUD_URL>" + "/wd/hub";
    final String ACCESS_KEY = "<ACCESS_KEY>";
    final String APPIUM_VERSION = "<APPIUM_VERSION>";

    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("accessKey", ACCESS_KEY);
        dc.setCapability("appiumVersion", APPIUM_VERSION);
        dc.setCapability("deviceQuery", "@os='ios'");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,  "XCUITest");
        dc.setCapability("instrumentApp", true);
        dc.setCapability("testName", "Performance audio recording test on iOS device");
        driver = new IOSDriver<>(new URL(CLOUD_URL), dc);
    }

    @Test
    void performAudioRecording() throws InterruptedException {
        // File with unique name <FILE_UNIQUE_NAME> must not exist in file repository
        driver.executeScript("seetest:client.startAudioRecording",  "cloud:<FILE_UNIQUE_NAME>");
        // commands that play audio on. For example, open youtube application and play a video
        Thread.sleep(10000);
        driver.executeScript("seetest:client.stopAudioRecording");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}
