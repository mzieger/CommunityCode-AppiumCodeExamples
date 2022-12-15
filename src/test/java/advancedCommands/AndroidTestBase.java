package advancedCommands;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;


public class AndroidTestBase {

    protected AndroidDriver<AndroidElement> driver = null;
    protected DesiredCapabilities dc = new DesiredCapabilities();
    protected String CLOUD_URL = "https://qacloud.experitest.com/wd/hub";
    static final String ACCESS_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoyNzI4MzkxLCJ4cC5wIjoyLCJ4cC5tIjoxNjA5MzE4NDg4Nzc3LCJleHAiOjE5MjQ2Nzg0ODgsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.66dIstPqaKCgG2rb6cbn9PkT8xxn2wgEZ0PGTBVGMBk";
    static final String APPIUM_VERSION = "1.22.0";


    @BeforeEach
    public void baseSetUp() {
        dc.setCapability("accessKey", ACCESS_KEY);
        dc.setCapability("appiumVersion", APPIUM_VERSION);
        dc.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
