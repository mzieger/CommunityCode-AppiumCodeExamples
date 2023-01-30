package advancedCommands.setLocation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Set the current geo location
 */
class SetLocationAndroidTest {

    AndroidDriver<AndroidElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    String CLOUD_URL = "<CLOUD_URL>" + "/wd/hub";

    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("accessKey", "<ACCESS_KEY>");
        dc.setCapability("appiumVersion", "<APPIUM_VERSION>");
        dc.setCapability("deviceQuery", "@os='android'");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,  "UiAutomator2");
        dc.setCapability("testName", "Set location test on Android device");
        driver = new AndroidDriver<>(new URL(CLOUD_URL), dc);
    }

    @Test
    void setLocation() {
        driver.setLocation(new Location(32, 24, 24));
        Location loc = driver.location();

        assertEquals(32, loc.getLatitude());
        assertEquals(24, loc.getLongitude());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}
