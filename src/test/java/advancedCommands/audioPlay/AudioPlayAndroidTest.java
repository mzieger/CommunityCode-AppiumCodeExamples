package advancedCommands.audioPlay;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Start playing an audio file.
 */
class AudioPlayAndroidTest {

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
        dc.setCapability("testName", "Performance audio play test on Android device");
        driver = new AndroidDriver<>(new URL(CLOUD_URL), dc);
    }

    @Test
    void performAudioPlaying() throws InterruptedException {
        // add commands that open the voice application in the device
        // File with unique name <FILE_UNIQUE_NAME> must exist in file repository
        driver.executeScript("seetest:client.startAudioPlay", "cloud:<FILE_UNIQUE_NAME>");
        Thread.sleep(10000);
        driver.executeScript("seetest:client.stopAudioPlay");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
