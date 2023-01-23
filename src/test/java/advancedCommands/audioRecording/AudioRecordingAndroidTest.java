package advancedCommands.audioRecording;

import advancedCommands.AndroidTestBase;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;

/**
 * Start Recording to a file, from the device.
 */
class AudioRecordingAndroidTest extends AndroidTestBase {

    @BeforeEach
    public void before() throws MalformedURLException {
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

}
