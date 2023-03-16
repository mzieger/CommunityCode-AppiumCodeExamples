package advancedCommands.setAuthenticationReply;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Simulates different authentication responses on applications that request a user fingerprint authentication.
 * This method allows setting the desired response type for later authentication requests.
 * Note: The application must be installed with fingerprint support.
 */
class SetAuthenticationReplyIOSTest {

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
        dc.setCapability("instrumentApp", true);
        dc.setCapability("testName", "Set authentication reply test on iOS device");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.UICatalog");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.UICatalog");
        driver = new IOSDriver<>(new URL(CLOUD_URL), dc);
    }

    @Test
    void setAuthenticationReply()  {
        final HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        try {
            driver.executeScript("mobile:scroll", scrollObject); // swipe faster then scroll
            Thread.sleep(2000); // always allow swipe action to complete
        } catch (Exception e) {
            fail("mobileScrollIOS(): FAILED\n" + e.getMessage());

        }
        driver.findElement(By.xpath("//*[@label='Authentication']")).click();
        driver.executeScript("seetest:client.setAuthenticationReply", "Success", 1000);
        driver.findElementByXPath("//*[@label='Request Touch ID Authentication']").click();

        try {
            driver.findElementByXPath("//*[@label='Success']");
        } catch (NoSuchElementException e) {
            fail("Set authentication failed", e);
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
