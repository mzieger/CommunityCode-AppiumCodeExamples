package advancedCommands.audioRecording;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Start Recording to a file, from the device.
 */
class AudioRecordingAndroidTest {

    AndroidDriver<AndroidElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    String CLOUD_URL = "<CLOUD_URL>" + "/wd/hub";

    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("accessKey", "<ACCESS_KEY>");
        dc.setCapability("appiumVersion", "<APPIUM_VERSION>");
        dc.setCapability("deviceQuery", "@os='android'");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,  "UiAutomator2");
        dc.setCapability("testName", "Performance audio recording test on Android device");
        driver = new AndroidDriver<>(new URL(CLOUD_URL), dc);
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
