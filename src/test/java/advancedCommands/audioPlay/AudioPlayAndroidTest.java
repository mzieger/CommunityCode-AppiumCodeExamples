package advancedCommands.audioPlay;

import advancedCommands.AndroidTestBase;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;

/**
 * Start playing an audio file.
 */
class AudioPlayAndroidTest extends AndroidTestBase {

    @BeforeEach
    public void before() throws MalformedURLException {
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

}
