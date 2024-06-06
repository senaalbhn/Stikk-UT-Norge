package stikkUTNorge.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import stikkUTNorge.utilities.Driver;
import stikkUTNorge.utilities.ReuseableMethods;

import java.awt.print.PageFormat;

import static stikkUTNorge.utilities.Driver.driver;

public class TurPage  {

    public TurPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }


    @AndroidFindBy(accessibility = "Mine mål")
    public WebElement mineMaal;
    @AndroidFindBy(accessibility = "Du kan justere dine mål når som helst. For å bestille Stikk UT!-kruset trenger du 7 turer.")
    private WebElement textMall;
    @AndroidFindBy(accessibility = "Lagre endringer")
    private WebElement lagreEndringer;
    @AndroidFindBy(accessibility = "Stikk UT! turmål")
    public WebElement stikkutTurmall;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Turer\n" +
            "Sommer\n" +
            "2024\"]/android.widget.ImageView[1]")
    public WebElement stikkutTurmaller;
    @AndroidFindBy(accessibility = "Andre turmål")
    public WebElement andreTurmaal;


    public static void endringMaal(String hvilken, String  verdi) {

        switch (hvilken.toLowerCase()) {
            case "registreringer":
                 driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText["+1+"]")).sendKeys(verdi);
                break;
            case "turmål":
                driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText["+2+"]")).sendKeys(verdi);
                break;
            case "kilometer":
                 driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText["+3+"]")).sendKeys(verdi);
                break;
            case "høydemeter":
                 driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText["+4+"]")).sendKeys(verdi);
                break;
        }

    }

    public void endreTurmaal() {
        KeyEvent delete = new KeyEvent(AndroidKey.DEL);
        mineMaal.click();
        ReuseableMethods.scroll(textMall,"up",1.0,1000);

        ReuseableMethods.doubleClick(859, 566);
        driver.pressKey(delete);
        endringMaal("registreringer","50");
        ReuseableMethods.vente(1);

        ReuseableMethods.doubleClick(859, 1055);
        driver.pressKey(delete);
        endringMaal("turmål","50");
        ReuseableMethods.vente(1);

        ReuseableMethods.doubleClick(859, 1240);
        driver.pressKey(delete);
        endringMaal("kilometer","5000");
        ReuseableMethods.vente(1);

        ReuseableMethods.doubleClick(859, 1412);
        driver.pressKey(delete);
        endringMaal("høydemeter","5000");
        ReuseableMethods.vente(1);
        KeyEvent back= new KeyEvent(AndroidKey.BACK);

        driver.pressKey(back);
        ReuseableMethods.vente(5);
        lagreEndringer.click();
    }


}
