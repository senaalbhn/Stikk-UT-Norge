package stikkUTNorge.utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {

    public static AndroidDriver driver;

    @BeforeTest
    public static AndroidDriver getDriver() {

        UiAutomator2Options options= new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("uiautomator2")
                .setUdid("emulator-5554")
                .setAppPackage("no.nivero.stikkut")
                .setAppActivity("no.nivero.stikkut.MainActivity")
                ;

        URL url = null;
        try {
            url = new URL("http://0.0.0.0:4723");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            return driver;
    }

}
