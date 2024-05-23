package stikkUTNorge.pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import stikkUTNorge.utilities.Driver;
import stikkUTNorge.utilities.ReuseableMethods;

import java.net.MalformedURLException;

public class LoggInnPage extends Driver {
    public LoggInnPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    private WebElement tillatLocation;
    @AndroidFindBy(accessibility = "Ok")
    private WebElement tillatelser;
    @AndroidFindBy(accessibility = "Back")
    private WebElement backToStikkUT;
    @AndroidFindBy(accessibility = "Close")
    private WebElement close;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[5]")
    public WebElement sisteSide;
    @AndroidFindBy(accessibility = "Logg inn")
    public WebElement loggInn;
    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement telefonnummer;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Logg inn\"])[2]")
    public WebElement loggInn2;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View[5]/android.widget.EditText[1]")
    private WebElement kode;
    @AndroidFindBy(accessibility = "Bekreft kode")
    private WebElement bekreftKode;
    @AndroidFindBy(accessibility = "Meg")
    private WebElement meg;
    @AndroidFindBy(accessibility = "Koden er ikke gyldig")
    private WebElement ungydigKode;
    @AndroidFindBy(accessibility = "Ny bruker")
    public WebElement nyBruker;
    @AndroidFindBy(accessibility = "Lagre turen\n" +
            "Hvis du vil kan du spore turene dine og se hvor du har gått, distanse og høydemeter.")
    public WebElement left;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]")
    public WebElement right;
    @AndroidFindBy (xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[3]")
    public WebElement lukkeButton;
    @AndroidFindBy (xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")
    public WebElement tilbakeButton;


    public void tillatTillatelser() {
        System.out.println("Stikk UT! Norge-app åpnet");
        tillatLocation.click();
        tillatelser.click();
        backToStikkUT.click();
        close.click();
        System.out.println("Alle tillatelser tillatt");
        sisteSide.click();
    }

    public void loggInn(String telefonnumerStr, String kodeStr) {
        loggInn.click();
        System.out.println("Logg inn-knappen trykket");
        telefonnummer.sendKeys(telefonnumerStr);
        loggInn2.click();
        System.out.println("Telefonnummer skrevet og Logg inn-knappen trykket");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        kode.sendKeys(kodeStr);
        bekreftKode.click();
        System.out.println("Kode skrevet og Bekreft kode-knappen trykket");
    }

    public void loggInn(String telefonnumerStr) {
        loggInn.click();
        System.out.println("Logg inn-knappen trykket");
        telefonnummer.sendKeys(telefonnumerStr);
        loggInn2.click();
        System.out.println("Telefonnummer skrevet og Logg inn-knappen trykket");
    }

    public void skrivKode(String kodeStr) {
        kode.click();
        kode.sendKeys(kodeStr);
        bekreftKode.click();
        System.out.println("Kode skrevet og Bekreft kode-knappen trykket");
    }

    public void bekreftLoggInn() {
        Assert.assertTrue(meg.isEnabled(), "Vellykket innlogging");
    }

    public void bekreftLUgydigKode() {
        Assert.assertTrue(ungydigKode.isDisplayed(), "Koden er ikke gyldig");
    }

    public void nyBruker(String telefonnumerStr, String kodeStr) {
        nyBruker.click();
        System.out.println("Ny bruker-knappen trykket");
        telefonnummer.sendKeys(telefonnumerStr);
        loggInn2.click();
        System.out.println("Telefonnummer skrevet og Logg inn-knappen trykket");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        kode.sendKeys(kodeStr);
        bekreftKode.click();
        System.out.println("Kode skrevet og Bekreft kode-knappen trykket");
    }

    public void nyBruker(String telefonnumerStr) {
        nyBruker.click();
        System.out.println("Ny bruker-knappen trykket");
        telefonnummer.sendKeys(telefonnumerStr);
        loggInn2.click();
    }

    public void swipe(int x, int y, int width, String direction){
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", x, "top", y, "width", width, "height", 0,
                "direction",  direction ,
                "percent", 1
        ));
    }

    public void bekreftSwipe(WebElement webElement){
        Assert.assertTrue(webElement.isDisplayed());
    }

    public void reiseGjennomLoginSider(int first, int second, int third, int fourth){
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View["+first+"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View["+second+"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View["+third+"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View["+fourth+"]")).click();
    }



}
