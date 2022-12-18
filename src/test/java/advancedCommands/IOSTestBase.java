package advancedCommands;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import java.net.MalformedURLException;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;


public class IOSTestBase {

    protected IOSDriver<IOSElement> driver = null;
    protected DesiredCapabilities dc = new DesiredCapabilities();
    protected String CLOUD_URL = "<CLOUD_URL>";
    static final String ACCESS_KEY = "<ACCESS_KEY>";
    static final String APPIUM_VERSION = "<APPIUM_VERSION>";


    @BeforeEach
    public void baseSetUp() {
        dc.setCapability("accessKey", ACCESS_KEY);
        dc.setCapability("appiumVersion", APPIUM_VERSION);
        dc.setCapability("deviceQuery", "@os='ios' and @category='PHONE'");
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
