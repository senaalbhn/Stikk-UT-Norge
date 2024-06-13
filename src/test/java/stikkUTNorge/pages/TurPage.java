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
import java.util.ArrayList;
import java.util.List;

import static stikkUTNorge.utilities.Driver.driver;

public class TurPage extends ReuseableMethods  {

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
    @AndroidFindBy(accessibility = "Turer\n" +
            "Sommer\n" +
            "2024")
    public WebElement stikkutTurmaller;
    @AndroidFindBy(accessibility = "Andre turmål")
    public WebElement andreTurmaal;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"© Kartverket\n" +
            "© Kartverket\n" +
            "Min Stikk UT!-statistikk\n" +
            "Min bedrift-statistikk\n" +
            "Hva er StikkUT?\"]/android.widget.ImageView")
    public WebElement sokefelt;
    @AndroidFindBy (className = "android.widget.EditText")
    public WebElement editText;
    @AndroidFindBy (accessibility = "Molde\n" +
            "Kommune")
    public WebElement moldeKommune;
    @AndroidFindBy (xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[9]/android.view.View//child::android.view.View")
    public List<WebElement> turer;




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

    public void endreTurmaal(String registreringer,String turmol, String kilometer, String hoydemeter) throws InterruptedException {
        KeyEvent delete = new KeyEvent(AndroidKey.DEL);
        KeyEvent back= new KeyEvent(AndroidKey.BACK);

        mineMaal.click();

        ReuseableMethods.scroll(textMall,"down",1.0,5000);

        ReuseableMethods.doubleClick(859, 566);
        driver.pressKey(delete);
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[1]")).sendKeys("50");

        ReuseableMethods.doubleClick(859, 1055);
        driver.pressKey(delete);
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[2]")).sendKeys(turmol);

        ReuseableMethods.doubleClick(859, 1240);
        driver.pressKey(delete);
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[3]")).sendKeys(kilometer);

        ReuseableMethods.doubleClick(859, 1412);
        driver.pressKey(delete);
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[4]")).sendKeys(hoydemeter);

        driver.pressKey(back);
        Thread.sleep(2000);
        lagreEndringer.click();
    }

    public void skriveKommuneNavnPoSokefelt(String kommuneNavn){

        String kommuneNavnEdit= kommuneNavn.substring(0,1).toUpperCase()+kommuneNavn.substring(1,kommuneNavn.length());
        sokefelt.click();
        editText.sendKeys(kommuneNavnEdit);
    }

    public void klikkPoKommune(String kommuneNavn){
        String kommuneNavnEdit= kommuneNavn.substring(0,1).toUpperCase()+kommuneNavn.substring(1,kommuneNavn.length());
        WebElement kommune= driver.findElement(AppiumBy.xpath("(//android.widget.EditText[@text=\""+kommuneNavnEdit+"\"]//following-sibling::android.widget.ImageView[contains(@content-desc,\""+kommuneNavnEdit+"\")])[1]"));
        kommune.click();
    }

    public void bekreftAtAlleTurerErPoRiktigKommune(String kommuneNavn) throws InterruptedException {
        String kommuneNavnEdit= kommuneNavn.substring(0,1).toUpperCase()+kommuneNavn.substring(1,kommuneNavn.length());
        stikkutTurmaller.click();
        Thread.sleep(3000);
        int counter=0;
        for (WebElement w : turer){
            if (w.getAttribute("content-desc").contains(kommuneNavnEdit)){
               System.out.println(w.getAttribute("content-desc").split("\n")[1] + " er i "+kommuneNavnEdit);
               counter++;
            }
        }
        Assert.assertEquals(turer.size(),counter);
    }
    public void bekreftAtKommuneErIkkePoStikkUtEnda(String kommuneNavn) throws InterruptedException {
        String kommuneNavnEdit= kommuneNavn.substring(0,1).toUpperCase()+kommuneNavn.substring(1,kommuneNavn.length());
        WebElement kommune= driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[contains(@content-desc,\""+kommuneNavnEdit+"\")])[1]"));
        String text=kommune.getAttribute("content-desc");
        Assert.assertEquals(text,kommuneNavnEdit+"\n" +
                "Ikke med i StikkUT! ennå\n" +
                "Kommune");

    }



}
