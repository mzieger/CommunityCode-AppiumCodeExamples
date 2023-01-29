package advancedCommands.adbPushAndPullFile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 * ADB push File to device command and ADB pull File from device command.
 */
class ADBPushAndPullFileAndroidTest {

    AndroidDriver<AndroidElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    String CLOUD_URL = "<CLOUD_URL>" + "/wd/hub";
    String devicePath = "<DEVICE_PATH>"; // for example, devicePath = "/sdcard/DCIM/Camera/hello/myPic.PNG"

    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("accessKey", "<ACCESS_KEY>");
        dc.setCapability("appiumVersion", "<APPIUM_VERSION>");
        dc.setCapability("deviceQuery", "@os='android'");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,  "UiAutomator2");
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

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}
