package stikkUTNorge.utilities;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stikkUTNorge.pages.LoggInnPage;

public class ReuseableMethods {

     public static void vente(int sekunder) {
        try {
            Thread.sleep(sekunder);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void loggInn(String telefonnummer, String kode){
        LoggInnPage loggInn= new LoggInnPage();
        loggInn.tillatTillatelser();
        loggInn.loggInn(telefonnummer,kode );
        loggInn.bekreftLoggInn();

    }


}
