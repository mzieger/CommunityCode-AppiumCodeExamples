package advancedCommands.installApp;

import advancedCommands.IOSTestBase;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class InstallAppIOSTest extends IOSTestBase {

    private static final String APP_NAME = "com.experitest.ExperiBank";
    private String APP_BUILD_VERSION = "<APPLICATION_BUILD_VERSION>";
    private String APP_RELEASE_VERSION = "<APPLICATION_RELEASE_VERSION>";
    private String APP_UNIQUE_NAME = "<APPLICATION_UNIQUE_NAME>";

    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("testName", "Install application test on iOS device");
        dc.setCapability(MobileCapabilityType.APP, "cloud:" + APP_NAME);
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, APP_NAME);
        driver = new IOSDriver<>(new URL(CLOUD_URL), dc);
    }

    @Test
    public void installAppByName() {
        assertNotInstalled();
        driver.installApp("cloud:" + APP_NAME);
        assertInstalled();
    }

    @Test
    public void installAppByUniqueName() {
        assertNotInstalled();
        driver.installApp("cloud:uniqueName=" + APP_UNIQUE_NAME);
        assertInstalled();
    }

    @Test
    public void installAppByBuildVersion() {
        assertNotInstalled();
        driver.installApp(
                "cloud:" + APP_NAME +
                        ":buildVersion=" + APP_BUILD_VERSION);
        assertInstalled();
    }

    @Test
    public void installAppByReleaseVersion() {
        assertNotInstalled();
        driver.installApp(
                "cloud:" + APP_NAME +
                        ":releaseVersion=" + APP_RELEASE_VERSION);
        assertInstalled();
    }


    @Test
    public void installAppByReleaseVersionAndBuildVersion() {
        assertNotInstalled();
        driver.installApp(
                "cloud:" + APP_NAME +
                        ":releaseVersion=" + APP_RELEASE_VERSION +
                        ":buildVersion=" + APP_BUILD_VERSION);
        assertInstalled();

    }

    private void assertNotInstalled() {
        driver.removeApp(APP_NAME);
        assertFalse(driver.isAppInstalled(APP_NAME));
    }

    private void assertInstalled() {
        assertTrue(driver.isAppInstalled(APP_NAME));
    }
}
