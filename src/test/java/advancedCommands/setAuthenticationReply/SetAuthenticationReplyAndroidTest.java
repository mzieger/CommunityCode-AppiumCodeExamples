package advancedCommands.setAuthenticationReply;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Simulates different authentication responses on applications that request a user fingerprint authentication.
 * This method allows setting the desired response type for later authentication requests.
 * Note: The application must be installed with fingerprint support.
 */
class SetAuthenticationReplyAndroidTest {

    AndroidDriver<AndroidElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    final String CLOUD_URL = "<CLOUD_URL>" + "/wd/hub";
    final String ACCESS_KEY = "<ACCESS_KEY>";
    final String APPIUM_VERSION = "<APPIUM_VERSION>";

    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("accessKey", ACCESS_KEY);
        dc.setCapability("appiumVersion", APPIUM_VERSION);
        dc.setCapability("deviceQuery", "@os='android'");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,  "UiAutomator2");
        dc.setCapability("instrumentApp", true);
        dc.setCapability("testName", "Set authentication reply test on Android device");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.uicatalog/.MainActivity");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.uicatalog");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
        driver = new AndroidDriver<>(new URL(CLOUD_URL), dc);
    }

    @Test
    void setAuthenticationReply()  {
        try {
            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
        } catch (NoSuchElementException e) {
            // ignore
        }
        driver.findElementByXPath("//*[@text='Fingerprint Authentication']").click();
        driver.executeScript("seetest:client.setAuthenticationReply", "AUTHENTICATION_SUCCEEDED", "10000");
        driver.findElementByXPath("//*[@text='Symmetric Authentication']").click();
        driver.findElementByXPath("//*[@text='Start']").click();
        WebElement element = driver.findElementByXPath("//*[@id='fingerprint_status']");
        boolean fingerprintRecognizedIsDisplay = element.getText().contains("Fingerprint recognized");
        assertTrue(fingerprintRecognizedIsDisplay);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
