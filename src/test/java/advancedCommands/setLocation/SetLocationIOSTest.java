package advancedCommands.setLocation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Set the current geo location
 */
class SetLocationIOSTest {


    IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    String CLOUD_URL = "<CLOUD_URL>" + "/wd/hub";


    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("accessKey", "<ACCESS_KEY>");
        dc.setCapability("appiumVersion", "<APPIUM_VERSION>");
        dc.setCapability("deviceQuery", "@os='ios'");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        dc.setCapability("testName", "Set location test on iOS device");
        dc.setCapability("bundleId", "com.apple.Preferences");
        driver = new IOSDriver<>(new URL(CLOUD_URL), dc);
    }


    @Test
    void setLocation() {
        driver.launchApp();
        driver.setLocation(new Location(32, 24, 24));
        Location loc;

        try {
            loc = driver.location();
        } catch (WebDriverException e) {
            // need to configure location permissions for ios
            if (e.getMessage().contains("Location service must be set to 'Always'")) {
                configureIosLocationPermission();
                loc = driver.location();
            } else {
                throw e;
            }
        }

        assertEquals(32.0, loc.getLatitude());
        assertEquals(24.0, loc.getLongitude());
    }

    private void configureIosLocationPermission() {
        driver.executeScript("mobile: scroll", Map.of(
                "direction", "down",
                "label", "Privacy"));
        driver.findElementByXPath("//*[@label='Privacy']").click();
        driver.findElementByXPath("//*[@label='Location Services']").click();
        driver.findElementByXPath("//*[@label='WebDriverAgentRunner-Runner']").click();
        driver.findElementByXPath("//*[@label='Always']").click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
