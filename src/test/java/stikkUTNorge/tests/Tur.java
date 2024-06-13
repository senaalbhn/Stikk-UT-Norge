package stikkUTNorge.tests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import stikkUTNorge.pages.LoggInnPage;
import stikkUTNorge.pages.TurPage;
import stikkUTNorge.utilities.ConfigReader;
import stikkUTNorge.utilities.ReuseableMethods;
import static stikkUTNorge.utilities.Driver.driver;

public class Tur extends TurPage    {
    TurPage turPage = new TurPage();
    String telefonnummer = ConfigReader.getProperty("telefonnummer");
    String kode = ConfigReader.getProperty("kode");

    @Test
    public void testTC01() throws InterruptedException {
        System.out.println("Brukren kan endre mål");
        ReuseableMethods.loggInn(telefonnummer, kode);
        Thread.sleep(5000);

        ReuseableMethods.pointerFlingeLoops(8,800,2000,142,2000,200);
        System.out.println("flinge ok");
        Thread.sleep(2000);
        ReuseableMethods.vente(2);

        WebElement mineMaal= driver.findElement(AppiumBy.accessibilityId("Mine mål"));

        KeyEvent delete = new KeyEvent(AndroidKey.DEL);
        mineMaal.click();
        WebElement textMall= driver.findElement(AppiumBy.accessibilityId("Du kan justere dine mål når som helst. For å bestille Stikk UT!-kruset trenger du 7 turer."));
        ReuseableMethods.scroll(textMall,"down",1.0,1000);

        ReuseableMethods.doubleClick(859, 566);
        driver.pressKey(delete);
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[1]")).sendKeys("50");

        ReuseableMethods.doubleClick(859, 1055);
        driver.pressKey(delete);
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[2]")).sendKeys("50");

        ReuseableMethods.doubleClick(859, 1240);
        driver.pressKey(delete);
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[3]")).sendKeys("500");

        ReuseableMethods.doubleClick(859, 1412);
        driver.pressKey(delete);
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[4]")).sendKeys("500");

        KeyEvent back= new KeyEvent(AndroidKey.BACK);
        driver.pressKey(back);
        Thread.sleep(2000);
        WebElement lagreEndringer= driver.findElement(AppiumBy.accessibilityId("Lagre endringer"));
        lagreEndringer.click();
    }
    @Test
    public void testTC01a() throws InterruptedException {
        System.out.println("Brukren kan endre mål");
        ReuseableMethods.loggInn(telefonnummer, kode);
        Thread.sleep(5000);
        ReuseableMethods.pointerFlingeLoops(12,800,2000,142,2000,200);
        Thread.sleep(2000);
        endreTurmaal("50","50","500","500");




    }

    @Test
    public void testTC02() throws InterruptedException {
        System.out.println("Brukren kan endre mål en og en ");
        /*
        ReuseableMethods.loggInn(telefonnummer, kode);
        Thread.sleep(5000);
         */

        ReuseableMethods.pointerFlingeLoops(8,800,2000,142,2000,200);

        Thread.sleep(2000);
        ReuseableMethods.vente(2);

        WebElement mineMaal= driver.findElement(AppiumBy.accessibilityId("Mine mål"));
        KeyEvent delete = new KeyEvent(AndroidKey.DEL);

        mineMaal.click();

        //registreringer
        ReuseableMethods.doubleClick(859, 566);
        driver.pressKey(delete);
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[1]")).sendKeys("25");

        KeyEvent back= new KeyEvent(AndroidKey.BACK);
        driver.pressKey(back);
        Thread.sleep(2000);
        WebElement lagreEndringer= driver.findElement(AppiumBy.accessibilityId("Lagre endringer"));
        lagreEndringer.click();

        //turmål
        mineMaal.click();

        ReuseableMethods.doubleClick(859, 1055);
        driver.pressKey(delete);
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[2]")).sendKeys("25");

        driver.pressKey(back);
        Thread.sleep(2000);
        lagreEndringer.click();

        //kilometer
        mineMaal.click();

        ReuseableMethods.doubleClick(859, 1240);
        driver.pressKey(delete);
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[3]")).sendKeys("250");

        driver.pressKey(back);
        Thread.sleep(2000);
        lagreEndringer.click();

        //endringMaal("høydemeter","5000");
        mineMaal.click();

        ReuseableMethods.doubleClick(859, 1412);
        driver.pressKey(delete);
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[4]")).sendKeys("250");

        driver.pressKey(back);
        Thread.sleep(2000);
        lagreEndringer.click();
    }
    @Test
    public void testTC03() throws InterruptedException {
        TurPage turPage = new TurPage();
        ReuseableMethods.loggInn(telefonnummer, kode);
        Thread.sleep(5000);
        System.out.println("Brukren kan søke Kommune på søkefelt og se turer på denne kommune");

        turPage.skriveKommuneNavnPoSokefelt("Molde");
        turPage.klikkPoKommune("Molde");
        turPage.bekreftAtAlleTurerErPoRiktigKommune("molde");

    }

    @Test
    public void testTC04() throws InterruptedException {
        TurPage turPage = new TurPage();
        ReuseableMethods.loggInn(telefonnummer, kode);
        Thread.sleep(5000);
        System.out.println("Hvis en kommune ikke med i SikkUT! Må ses på både søkefelt og StikkUT! Turmål");

        turPage.skriveKommuneNavnPoSokefelt("Oslo");
        turPage.bekreftAtKommuneErIkkePoStikkUtEnda("oslo");

    }

    @Test
    public void test() throws InterruptedException {
        System.out.println("først");
        Thread.sleep(3000);
        System.out.println("sekund");
        ReuseableMethods.vente(3);
        System.out.println("tredje");

    }


}
