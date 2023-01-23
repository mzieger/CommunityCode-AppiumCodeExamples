package advancedCommands.installApp;

import advancedCommands.AndroidTestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;

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
        driver.installApp("cloud:" + APP_PACKAGE);
    }

    @Test
    void installAppByUniqueName() {
        driver.installApp("cloud:uniqueName=" + APP_UNIQUE_NAME);
    }

    @Test
    void installAppByBuildVersion() {
        driver.installApp(
                "cloud:" + APP_PACKAGE +
                        ":buildVersion=" + APP_BUILD_VERSION);
    }

    @Test
    void installAppByReleaseVersion() {
        driver.installApp(
                "cloud:" + APP_PACKAGE +
                        ":releaseVersion=" + APP_RELEASE_VERSION);
    }


    @Test
    void installAppByReleaseVersionAndBuildVersion() {
        driver.installApp(
                "cloud:" + APP_PACKAGE +
                        ":releaseVersion=" + APP_RELEASE_VERSION +
                        ":buildVersion=" + APP_BUILD_VERSION);
    }
}
