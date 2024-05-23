package stikkUTNorge.tests;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import stikkUTNorge.pages.LoggInnPage;
import stikkUTNorge.pages.TurPage;
import stikkUTNorge.utilities.ConfigReader;
import stikkUTNorge.utilities.Driver;
import stikkUTNorge.utilities.ReuseableMethods;

public class Tur extends Driver {
    LoggInnPage loggInn=new LoggInnPage();
    TurPage turPage= new TurPage();
    String telefonnummer= ConfigReader.getProperty("telefonnummer");
    String kode= ConfigReader.getProperty("kode");
    @Test
    public void testTC01(){
        System.out.println("Brukren kan endre mål");
        ReuseableMethods.loggInn(telefonnummer,kode);
        ReuseableMethods.vente(2);
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) turPage.stikkutTurmall).getId(),
                "direction", "up",
                "percent", 1.0
        ));


       // ReuseableMethods.scroll(turPage.stikkutTurmall,"up",1.0);

        driver.executeScript("mobile: flingGesture", ImmutableMap.of(
                "left", 800, "top", 2000, "width", 700, "height", 0,
                "direction", "left",
                "speed", 1000
        ));
        //ReuseableMethods.flinge(800,2000,700,0,"left",1000);
        turPage.endreTurmaal();

    }
}
