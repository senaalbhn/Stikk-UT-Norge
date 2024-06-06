package stikkUTNorge.tests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import stikkUTNorge.pages.LoggInnPage;
import stikkUTNorge.pages.TurPage;
import stikkUTNorge.utilities.ConfigReader;
import stikkUTNorge.utilities.Driver;
import stikkUTNorge.utilities.ReuseableMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import static stikkUTNorge.pages.TurPage.endringMaal;
import static stikkUTNorge.utilities.Driver.driver;

public class Tur   {
    LoggInnPage loggInn = new LoggInnPage();
    TurPage turPage = new TurPage();
    String telefonnummer = ConfigReader.getProperty("telefonnummer");
    String kode = ConfigReader.getProperty("kode");

    @Test
    public void testTC01() throws InterruptedException {
        System.out.println("Brukren kan endre mål");
        ReuseableMethods.loggInn(telefonnummer, kode);
        Thread.sleep(5000);

        ReuseableMethods.pointerFlinge(800,2000,142,2000,200);
        ReuseableMethods.pointerFlinge(800,2000,142,2000,200);
        ReuseableMethods.pointerFlinge(800,2000,142,2000,200);
        ReuseableMethods.pointerFlinge(800,2000,142,2000,200);
        ReuseableMethods.pointerFlinge(800,2000,142,2000,200);
        ReuseableMethods.pointerFlinge(800,2000,142,2000,200);
        System.out.println("flinge ok");
        Thread.sleep(2000);
        ReuseableMethods.vente(2);

        turPage.endreTurmaal();


        /*
        WebElement mineMaal= driver.findElement(AppiumBy.accessibilityId("Mine mål"));

        KeyEvent delete = new KeyEvent(AndroidKey.DEL);
        mineMaal.click();
        WebElement textMall= driver.findElement(AppiumBy.accessibilityId("Du kan justere dine mål når som helst. For å bestille Stikk UT!-kruset trenger du 7 turer."));
        ReuseableMethods.scroll(textMall,"down",1.0,1000);

        ReuseableMethods.doubleClick(859, 566);
        driver.pressKey(delete);
        //endringMaal("registreringer","50");
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[1]")).sendKeys("50");

        ReuseableMethods.doubleClick(859, 1055);
        driver.pressKey(delete);
        //endringMaal("turmål","50");
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[2]")).sendKeys("50");

        ReuseableMethods.doubleClick(859, 1240);
        driver.pressKey(delete);
        //endringMaal("kilometer","5000");
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[3]")).sendKeys("50");

        ReuseableMethods.doubleClick(859, 1412);
        driver.pressKey(delete);
        //endringMaal("høydemeter","5000");
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[4]")).sendKeys("50");
        KeyEvent back= new KeyEvent(AndroidKey.BACK);
        driver.pressKey(back);
        Thread.sleep(2000);
        WebElement lagreEndringer= driver.findElement(AppiumBy.accessibilityId("Lagre endringer"));
        lagreEndringer.click();

         */

    }
}
