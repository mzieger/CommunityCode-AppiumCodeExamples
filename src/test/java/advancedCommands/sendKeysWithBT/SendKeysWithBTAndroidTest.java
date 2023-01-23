package advancedCommands.sendKeysWithBT;

import advancedCommands.AndroidTestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;

/**
 * This command sends keyboard events to the Bluetooth keyboard on the device.
 */
class SendKeysWithBTAndroidTest extends AndroidTestBase {

    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("testName", "Send key with BT test on Android device");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        driver = new AndroidDriver<>(new URL(CLOUD_URL), dc);
    }

    @Test
    void sendKeiWithBT()  {
        driver.executeScript("seetest:client.sendKeysWithBT", "" + Keys.CONTROL+ Keys.ALT + "I");
    }
}
