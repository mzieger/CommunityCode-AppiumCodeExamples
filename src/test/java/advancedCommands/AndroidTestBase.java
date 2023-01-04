package advancedCommands;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;


public class AndroidTestBase {

    protected AndroidDriver<AndroidElement> driver = null;
    protected DesiredCapabilities dc = new DesiredCapabilities();
    protected String CLOUD_URL = "<CLOUD_URL>" + "/wd/hub";


    @BeforeEach
    public void baseSetUp() {
        dc.setCapability("accessKey", "<ACCESS_KEY>");
        dc.setCapability("appiumVersion", "<APPIUM_VERSION>");
        dc.setCapability("deviceQuery", "@os='android'");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,  "UiAutomator2");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
