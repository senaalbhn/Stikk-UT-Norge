package stikkUTNorge.utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import stikkUTNorge.pages.LoggInnPage;
import java.time.Duration;
import java.util.Collections;

import static stikkUTNorge.utilities.Driver.driver;

public class ReuseableMethods {

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

    public static void swipe(WebElement element, String direction) {
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
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
    public static void flingeBoolean(int x, int y, int width, int height, String direction, int speed) {
        boolean canScrollMore = true;
        while (canScrollMore) {
             canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
                    "left", x, "top", y, "width", width, "height", height,
                    "direction", direction,
                    "speed", speed
            ));
        }

    }

    public static void flinge(WebElement element, String direction, int speed) {
        driver.executeScript("mobile: flingGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
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

    public static void click(WebElement element) {
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public static void doubleClick(int x, int y) {
        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "x", x,
                "y", y
        ));
    }

    public static void scroll(int x, int y, int width, int height, String direction, double percent) {
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", x, "top", y, "width", width, "height", height,
                "direction", direction,
                "percent", percent
        ));
    }

    public static void scroll(WebElement element, String direction, double percent, int speed) {
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", percent,
                "speed", speed

        ));

    }

    public static void pointerFlinge(int startX, int startY, int endX, int endY, int pause) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(pause)))
                .addAction(finger.createPointerMove(Duration.ofMillis(80), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));

    }


    public static void pointerFlingeLoops(int rep, int startX, int startY, int endX, int endY, int pause) {

        for (int i = 1; i < rep; i++) {
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence sequence = new Sequence(finger, 1)
                    .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger, Duration.ofMillis(pause)))
                    .addAction(finger.createPointerMove(Duration.ofMillis(80), PointerInput.Origin.viewport(), endX, endY))
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Collections.singletonList(sequence));
        }

    }


}
