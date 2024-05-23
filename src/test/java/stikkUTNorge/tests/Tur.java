package stikkUTNorge.tests;

import org.testng.annotations.Test;
import stikkUTNorge.pages.LoggInnPage;
import stikkUTNorge.utilities.ConfigReader;
import stikkUTNorge.utilities.ReuseableMethods;

public class Tur {
    LoggInnPage loggInn=new LoggInnPage();
    String telefonnummer= ConfigReader.getProperty("telefonnummer");
    String kode= ConfigReader.getProperty("kode");
    @Test
    public void testTC01(){
        System.out.println("Brukren kan endre mål");
        ReuseableMethods.loggInn(telefonnummer,kode);
    }
}
