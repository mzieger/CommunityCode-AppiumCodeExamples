package advancedCommands.startStopStepsGroup;

import advancedCommands.IOSTestBase;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

public class StartStopStepsGroupIOSTest extends IOSTestBase {

    public static final String START_STEPS_GROUP = "seetest:client.startStepsGroup";
    public static final String STOP_STEPS_GROUP = "seetest:client.stopStepsGroup";

    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("testName", "Start and stop steps group test on iOS device");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new IOSDriver<>(new URL(CLOUD_URL), dc);
    }


    @Test
    public void startAndStopStepsGroup() {
        driver.executeScript(START_STEPS_GROUP, "login group");
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.findElement(By.xpath("//*[@name='usernameTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@name='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@name='loginButton']")).click();
        driver.executeScript(STOP_STEPS_GROUP);
        driver.findElement(By.xpath("//*[@name='makePaymentButton']")).click();
        driver.findElement(By.xpath("//*[@name='phoneTextField']")).sendKeys("0501234567");
        driver.findElement(By.xpath("//*[@name='nameTextField']")).sendKeys("John Snow");
        driver.findElement(By.xpath("//*[@name='amountTextField']")).sendKeys("50");
        driver.findElement(By.xpath("//*[@name='countryButton']")).click();
        driver.findElement(By.xpath("//*[@name='Switzerland']")).click();
        driver.findElement(By.xpath("//*[@name='sendPaymentButton']")).click();
        driver.findElement(By.xpath("//*[@name='Yes']")).click();
    }

    @Test
    public void multipleGroups() {
        driver.executeScript(START_STEPS_GROUP, "login group");
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.findElement(By.xpath("//*[@name='usernameTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@name='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@name='loginButton']")).click();
        driver.executeScript(STOP_STEPS_GROUP);
        driver.executeScript(START_STEPS_GROUP, "payment group");
        driver.findElement(By.xpath("//*[@name='makePaymentButton']")).click();
        driver.findElement(By.xpath("//*[@name='phoneTextField']")).sendKeys("0501234567");
        driver.findElement(By.xpath("//*[@name='nameTextField']")).sendKeys("John Snow");
        driver.findElement(By.xpath("//*[@name='amountTextField']")).sendKeys("50");
        driver.findElement(By.xpath("//*[@name='countryButton']")).click();
        driver.findElement(By.xpath("//*[@name='Switzerland']")).click();
        driver.findElement(By.xpath("//*[@name='sendPaymentButton']")).click();
        driver.findElement(By.xpath("//*[@name='Yes']")).click();
        driver.executeScript(STOP_STEPS_GROUP);
    }
}
