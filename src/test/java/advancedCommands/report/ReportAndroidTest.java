package advancedCommands.report;

import advancedCommands.AndroidTestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;


public class ReportAndroidTest extends AndroidTestBase {


    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("testName", "Report test on Android device");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        driver = new AndroidDriver<>(new URL(CLOUD_URL), dc);
    }


    @Test
    public void addPassedStep() {
        loginToEriBank();
        driver.executeScript("seetest:client.report(\"step should be passed\",\"true\")");
    }

    @Test
    public void addFailedStep() {
        loginToEriBank();
        driver.executeScript("seetest:client.report(\"step should be failed\",\"false\")");
    }

    private void loginToEriBank() {
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");
        driver.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
        driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
    }

}
