package advancedCommands.installApp;

import advancedCommands.AndroidTestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Install the application with given:
 * 1. Name
 * 2. Unique name
 * 3. Build version or release version or both
 */
class InstallAppAndroidTest extends AndroidTestBase {

    private static final String APP_PACKAGE = "com.experitest.ExperiBank";
    private String APP_BUILD_VERSION = "<APPLICATION_BUILD_VERSION>";
    private String APP_RELEASE_VERSION = "<APPLICATION_RELEASE_VERSION>";
    private String APP_UNIQUE_NAME = "<APPLICATION_UNIQUE_NAME>";


    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("testName", "Install application test on Android device");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        driver = new AndroidDriver<>(new URL(CLOUD_URL), dc);
    }

    @Test
    void installAppByName() {
        assertNotInstalled();
        driver.installApp("cloud:" + APP_PACKAGE);
        assertInstalled();
    }

    @Test
    void installAppByUniqueName() {
        assertNotInstalled();
        driver.installApp("cloud:uniqueName=" + APP_UNIQUE_NAME);
        assertInstalled();
    }

    @Test
    void installAppByBuildVersion() {
        assertNotInstalled();
        driver.installApp(
                "cloud:" + APP_PACKAGE +
                        ":buildVersion=" + APP_BUILD_VERSION);
        assertInstalled();
    }

    @Test
    void installAppByReleaseVersion() {
        assertNotInstalled();
        driver.installApp(
                "cloud:" + APP_PACKAGE +
                        ":releaseVersion=" + APP_RELEASE_VERSION);
        assertInstalled();
    }


    @Test
    void installAppByReleaseVersionAndBuildVersion() {
        assertNotInstalled();
        driver.installApp(
                "cloud:" + APP_PACKAGE +
                        ":releaseVersion=" + APP_RELEASE_VERSION +
                        ":buildVersion=" + APP_BUILD_VERSION);
        assertInstalled();

    }

    private void assertNotInstalled() {
        driver.removeApp(APP_PACKAGE);
        assertFalse(driver.isAppInstalled(APP_PACKAGE));
    }

    private void assertInstalled() {
        assertTrue(driver.isAppInstalled(APP_PACKAGE));
    }
}
