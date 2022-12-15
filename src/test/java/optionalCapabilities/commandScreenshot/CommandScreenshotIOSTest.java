package optionalCapabilities.commandScreenshot;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CommandScreenshotIOSTest {

    IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    String accessKey = "<ACCESS_KEY>";
    String appiumVersion = "<APPIUM_VERSION>";
    String cloudUrl = "<CLOUD_URL>" + "/wd/hub";


    @BeforeEach
    public void setUp() throws MalformedURLException {
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("appiumVersion", appiumVersion);
        dc.setCapability("deviceQuery", "@os='ios'");
        dc.setCapability("commandScreenshot", true);
        dc.setCapability("testName", "Command screenshot test on iOS device");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new IOSDriver<>(new URL(cloudUrl), dc);
    }

    @Test
    void runTestWithCommandScreenshotTrue() {
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.findElement(By.xpath("//*[@name='usernameTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@name='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@name='loginButton']")).click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
