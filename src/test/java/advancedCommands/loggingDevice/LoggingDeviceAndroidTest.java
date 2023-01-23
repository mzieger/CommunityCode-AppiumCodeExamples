package advancedCommands.loggingDevice;

import advancedCommands.AndroidTestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

/**
 * StartLoggingDevice and StopLoggingDevice commands are used to start and stop device log will be written to the path provided by the user.
 */
class LoggingDeviceAndroidTest extends AndroidTestBase {

    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("testName", "Logging device test on Android device");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        driver = new AndroidDriver<>(new URL(CLOUD_URL), dc);
    }

    @Test
    void performLoggingDevice() {
        // File with unique name <FILE_UNIQUE_NAME> must not exist in file repository
        driver.executeScript("seetest:client.startLoggingDevice",  "cloud:<FILE_UNIQUE_NAME>.log");
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");
        driver.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
        driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
        driver.executeScript("seetest:client.stopLoggingDevice");
    }
}
