package stikkUTNorge.utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import stikkUTNorge.pages.LoggInnPage;

public class ReuseableMethods extends Driver {

    public static void vente(int sekunder) {
        try {
            Thread.sleep(sekunder);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loggInn(String telefonnummer, String kode) {
        LoggInnPage loggInn = new LoggInnPage();
        loggInn.tillatTillatelser();
        loggInn.loggInn(telefonnummer, kode);
        loggInn.bekreftLoggInn();
    }

    public static void swipe(int x, int y, int width, int height, String direction) {
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", x, "top", y, "width", width, "height", height,
                "direction", direction,
                "percent", 1
        ));
    }

    public static void flinge(int x, int y, int width, int height, String direction, int speed) {
        driver.executeScript("mobile: flingGesture", ImmutableMap.of(
                "left", x, "top", y, "width", width, "height", height,
                "direction", direction,
                "speed", speed
        ));
    }

    public static void click(int x, int y) {
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "x", x,
                "y", y
        ));
    }

    public static void doubleClick(int x, int y){
        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "x",x,
                "y",y
        ));
    }
    public static void scroll(int x, int y, int width, int height, String direction, double percent) {
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", x, "top", y, "width", width, "height", height,
                "direction", direction,
                "percent", percent
        ));
    }

    public static void scroll(WebElement element,  String direction, double percent ){
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", percent
        ));

    }


}
