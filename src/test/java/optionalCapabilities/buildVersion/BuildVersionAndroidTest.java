package optionalCapabilities.buildVersion;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BuildVersionAndroidTest {

    AndroidDriver<AndroidElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    String accessKey = "<ACCESS_KEY>";
    String appiumVersion = "<APPIUM_VERSION>";
    String cloudUrl = "<CLOUD_URL>" + "/wd/hub";
    String appBuildVersion = "<APP_BUILD_VERSION>";


    @BeforeEach
    public void setUp() throws MalformedURLException {
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("appiumVersion", appiumVersion);
        dc.setCapability("deviceQuery", "@os='android'");
        dc.setCapability("testName", "Build version test on Android device");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability("appBuildVersion", appBuildVersion);
        driver = new AndroidDriver<>(new URL(cloudUrl), dc);
    }

    @Test
    void runTestWithBuildVersion() {
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");
        driver.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
        driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
