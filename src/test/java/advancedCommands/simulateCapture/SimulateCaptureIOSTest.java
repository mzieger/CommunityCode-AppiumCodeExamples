package advancedCommands.simulateCapture;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * The command allows users to test applications that use the camera on a mobile device.
 * The command injects an image file to the camera preview screen.
 * The command can run using file with unique name in file repository or with file URL.
 * Note: The application must be installed with simulate capture support
 */
class SimulateCaptureIOSTest {

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
        dc.setCapability("testName", "Run simulate capture test on iOS device");
        dc.setCapability("autoGrantPermissions", true);
        dc.setCapability("instrumentApp", true);
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.UICatalog");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.UICatalog");
        driver = new IOSDriver<>(new URL(CLOUD_URL), dc);
    }


    private void runSimulateCapture(boolean fromURL) throws InterruptedException {
        driver.findElement(By.xpath("//*[@text='CameraAVTitle']")).click();

        Thread.sleep(10000); // time to wait until the image will be shown
        if (fromURL) {
            driver.executeScript("seetest:client.simulateCapture", "<FILE_URL>");
        } else {
            // File with unique name <FILE_UNIQUE_NAME> must exist in file repository
            driver.executeScript("seetest:client.simulateCapture", "cloud:<FILE_UNIQUE_NAME>");
        }
        Thread.sleep(5000); // time to wait until the image will be shown
    }


    @Test
    void simulateCaptureFromURL() throws InterruptedException {
        runSimulateCapture(true);
    }

    @Test
    void simulateCaptureFromFileRepository() throws Exception {
     runSimulateCapture(false);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}
