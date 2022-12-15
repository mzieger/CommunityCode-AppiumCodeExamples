package advancedCommands.setLocation;

import advancedCommands.AndroidTestBase;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.html5.Location;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SetLocationAndroidTest extends AndroidTestBase {

    @BeforeEach
    public void before() throws MalformedURLException {
        dc.setCapability("testName", "Set location test on Android device");
        driver = new AndroidDriver<>(new URL(CLOUD_URL), dc);
    }

    @Test
    public void setLocation() {
        driver.setLocation(new Location(32, 24, 24));
        Location loc = driver.location();

        assertEquals(loc.getLatitude(), 32);
        assertEquals(loc.getLongitude(), 24);
    }

}
