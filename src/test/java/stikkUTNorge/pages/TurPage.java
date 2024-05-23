package stikkUTNorge.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import stikkUTNorge.utilities.Driver;
import stikkUTNorge.utilities.ReuseableMethods;

import java.awt.print.PageFormat;

public class TurPage extends Driver {

    public TurPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }


    @AndroidFindBy(accessibility = "Mine mål")
    private WebElement mineMaal;
    @AndroidFindBy(accessibility = "Du kan justere dine mål når som helst. For å bestille Stikk UT!-kruset trenger du 7 turer.")
    private WebElement textMall;
    @AndroidFindBy(accessibility = "Lagre endringer")
    private WebElement lagreEndringer;
    @AndroidFindBy(accessibility = "Stikk UT! turmål")
    public WebElement stikkutTurmall;
    @AndroidFindBy(accessibility = "Andre turmål")
    public WebElement andreTurmaal;


    public void endringMaal(String hvilken, String  verdi) {

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
        ReuseableMethods.scroll(textMall,"up",1.0);

        ReuseableMethods.doubleClick(859, 566);
        driver.pressKey(delete);
        endringMaal("registreringer","50");

        ReuseableMethods.doubleClick(859, 740);
        driver.pressKey(delete);
        endringMaal("turmål","50");

        ReuseableMethods.doubleClick(859, 923);
        driver.pressKey(delete);
        endringMaal("kilometer","5000");

        ReuseableMethods.doubleClick(859, 1119);
        driver.pressKey(delete);
        endringMaal("høydemeter","5000");

        lagreEndringer.click();
    }


}
