package advancedCommands.startStopStepsGroup;

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

/**
 * StartStepsGroup begins a group marks (and StopStepsGroup ends it).
 * All the steps that appear between those two steps will appear under the same group on the report.
 */
class StartStopStepsGroupAndroidTest {

    AndroidDriver<AndroidElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    String CLOUD_URL = "<CLOUD_URL>" + "/wd/hub";

    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("accessKey", "<ACCESS_KEY>");
        dc.setCapability("appiumVersion", "<APPIUM_VERSION>");
        dc.setCapability("deviceQuery", "@os='android'");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,  "UiAutomator2");
        dc.setCapability("testName", "Start and stop steps group test on Android device");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        driver = new AndroidDriver<>(new URL(CLOUD_URL), dc);
    }

    @Test
    void startAndStopStepsGroup() {
        driver.executeScript("seetest:client.startStepsGroup", "login group");
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");
        driver.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
        driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
        driver.executeScript("seetest:client.stopStepsGroup");
        driver.findElement(By.id("com.experitest.ExperiBank:id/makePaymentButton")).click();
        driver.findElement(By.id("com.experitest.ExperiBank:id/phoneTextField")).sendKeys("0501234567");
        driver.findElement(By.id("com.experitest.ExperiBank:id/nameTextField")).sendKeys("John Snow");
        driver.findElement(By.id("com.experitest.ExperiBank:id/amountTextField")).sendKeys("50");
        driver.findElement(By.id("com.experitest.ExperiBank:id/countryTextField")).sendKeys("'Switzerland'");
        driver.findElement(By.id("com.experitest.ExperiBank:id/sendPaymentButton")).click();
        driver.findElement(By.id("android:id/button1")).click();
    }

    @Test
    void multipleGroups() {
        driver.executeScript("seetest:client.startStepsGroup", "login group");
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");
        driver.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
        driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
        driver.executeScript("seetest:client.stopStepsGroup");
        driver.executeScript("seetest:client.startStepsGroup", "payment group");
        driver.findElement(By.id("com.experitest.ExperiBank:id/makePaymentButton")).click();
        driver.findElement(By.id("com.experitest.ExperiBank:id/phoneTextField")).sendKeys("0501234567");
        driver.findElement(By.id("com.experitest.ExperiBank:id/nameTextField")).sendKeys("John Snow");
        driver.findElement(By.id("com.experitest.ExperiBank:id/amountTextField")).sendKeys("50");
        driver.findElement(By.id("com.experitest.ExperiBank:id/countryTextField")).sendKeys("'Switzerland'");
        driver.findElement(By.id("com.experitest.ExperiBank:id/sendPaymentButton")).click();
        driver.findElement(By.id("android:id/button1")).click();
        driver.executeScript("seetest:client.stopStepsGroup");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
