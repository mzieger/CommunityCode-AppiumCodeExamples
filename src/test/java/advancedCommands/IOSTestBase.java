package advancedCommands;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;


public class IOSTestBase {

    protected IOSDriver<IOSElement> driver = null;
    protected DesiredCapabilities dc = new DesiredCapabilities();
    protected String CLOUD_URL = "<CLOUD_URL>";


    @BeforeEach
    public void baseSetUp() {
        dc.setCapability("accessKey", "<ACCESS_KEY>");
        dc.setCapability("appiumVersion", "<APPIUM_VERSION>");
        dc.setCapability("deviceQuery", "@os='ios'");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
