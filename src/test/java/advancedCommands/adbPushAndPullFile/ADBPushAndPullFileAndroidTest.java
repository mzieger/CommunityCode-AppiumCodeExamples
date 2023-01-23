package advancedCommands.adbPushAndPullFile;

import advancedCommands.AndroidTestBase;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;


/**
 * ADB push File to device command and ADB pull File from device command.
 */
class ADBPushAndPullFileAndroidTest extends AndroidTestBase {

    String devicePath = "<DEVICE_PATH>";
    // for example, devicePath = "/sdcard/DCIM/Camera/hello/myPic.PNG"

    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("testName", "ADB push and pull file test on Android device");
        driver = new AndroidDriver<>(new URL(CLOUD_URL), dc);
    }


    @Test
    void performPushFile() {
        // File with unique name <FILE_UNIQUE_NAME> must exist in file repository
        // File from repository will be uploaded to provided path on device.
        driver.executeScript("seetest:client.pushFile", devicePath, "cloud:<FILE_UNIQUE_NAME>");
    }

    @Test
    void performPullFile() {
        // File with unique name <FILE_UNIQUE_NAME> must NOT exist in file repository
        // File downloaded from device will be stored in file repository with given unique name.
        driver.executeScript("seetest:client.pullFile", devicePath, "cloud:<FILE_UNIQUE_NAME>");
    }

}
