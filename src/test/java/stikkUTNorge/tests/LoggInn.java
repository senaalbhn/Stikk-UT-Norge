package stikkUTNorge.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import stikkUTNorge.pages.LoggInnPage;
import stikkUTNorge.utilities.ConfigReader;
import stikkUTNorge.utilities.Driver;
import stikkUTNorge.utilities.ReuseableMethods;

public class LoggInn extends Driver {
    String rigtigTelefonnummer = ConfigReader.getProperty("telefonnummer");
    String feilTelefonnummer = "11111111";
    String telefonnummerMed7Sifre = ConfigReader.getProperty("telefonnummerMed7Sifre");
    String telefonnummerMed11Sifre = ConfigReader.getProperty("telefonnummerMed11Sifre");
    String riktigKode = ConfigReader.getProperty("kode");
    String feilKode = "0000";


    @Test
    public void testTC01() {
        //Brukeren kunne logg inn med riktig telefonnummer og riktig kode
        System.out.println("Brukeren kunne logg inn med riktig telefonnummer og riktig kode");
        LoggInnPage loggInn = new LoggInnPage();
        loggInn.tillatTillatelser();
        loggInn.loggInn(rigtigTelefonnummer, riktigKode);
        loggInn.bekreftLoggInn();
    }

    @Test
    public void testTC02() {
        //Brukeren kunne ikke logg inn med feil telefonnummer
        System.out.println("Brukeren kunne ikke logg inn med feil telefonnummer ");
        LoggInnPage loggInn = new LoggInnPage();
        loggInn.tillatTillatelser();
        loggInn.loggInn(feilTelefonnummer);
        Assert.assertTrue(loggInn.loggInn2.isDisplayed(), "Det er ikke mulig at logg inn med feil telefonnummer");
    }

    @Test
    public void testTC03() {
        //Brukeren kunne ikke logg inn med telefonnummer som har antall nummer mindre enn 8
        System.out.println("Brukeren kunne ikke logg inn med telefonnummer som har antall nummer mindre enn 8 ");
        LoggInnPage loggInn = new LoggInnPage();
        loggInn.tillatTillatelser();
        loggInn.loggInn(telefonnummerMed7Sifre);
        Assert.assertTrue(loggInn.loggInn2.isDisplayed(), "Det er ikke mulig at logg inn med 7-sifret telefonnummer");
    }

    @Test
    public void testTC04() {
        //Brukeren kunne ikke logg inn med telefonnummer som har antall nummer mer enn 8
        System.out.println("Brukeren kunne ikke logg inn med telefonnummer som har antall nummer mer enn 8 ");
        LoggInnPage loggInn = new LoggInnPage();
        loggInn.tillatTillatelser();
        loggInn.loggInn(telefonnummerMed11Sifre);
        Assert.assertTrue(loggInn.loggInn2.isDisplayed(), "Det er ikke mulig at logg inn med 11-sifret telefonnummer");
    }

    @Test
    public void testTC05() {
        //Brukeren kunne ikke logg inn med riktig telefonnummer og feil kode
        System.out.println("Brukeren kunne ikke logg inn med riktig telefonnummer og feil kode");
        LoggInnPage loggInn = new LoggInnPage();
        loggInn.tillatTillatelser();
        loggInn.loggInn(rigtigTelefonnummer, feilKode);
        loggInn.bekreftLUgydigKode();
    }

    @Test
    public void testTC06() {
        //Brukeren kunne logg inn med riktig telefonnummer og først feil kode etter riktig kode
        System.out.println("Brukeren kunne logg inn med riktig telefonnummer og først feil kode etter riktig kode");
        LoggInnPage loggInn = new LoggInnPage();
        loggInn.tillatTillatelser();
        loggInn.loggInn(rigtigTelefonnummer, feilKode);
        loggInn.bekreftLUgydigKode();
        loggInn.skrivKode(riktigKode);
        loggInn.bekreftLoggInn();
    }

    @Test
    public void testTC07() {
        //Brukeren som har et konto allerede kunne logg inn med å klikke "Ny Bruker"
        System.out.println("Brukeren som har et konto allerede kunne logg inn med å klikke Ny Bruker");
        LoggInnPage loggInn = new LoggInnPage();
        loggInn.tillatTillatelser();
        loggInn.nyBruker(rigtigTelefonnummer, riktigKode);
        loggInn.bekreftLoggInn();
    }

    @Test
    public void testTC08() {
        //Brukeren som har et konto allerede kunne ikke logg inn med feil telefonnummer med å klikke "Ny Bruker"
        System.out.println("Brukeren kunne ikke logg inn med feil telefonnummer ");
        LoggInnPage loggInn = new LoggInnPage();
        loggInn.tillatTillatelser();
        loggInn.nyBruker(feilTelefonnummer);
        Assert.assertTrue(loggInn.loggInn2.isDisplayed(), "Det er ikke mulig at logg inn med feil telefonnummer");
    }

    @Test
    public void testTC09() {
        //Brukeren som har et konto allerede kunne ikke logg inn med rigtig telefonnummer og feil kode  med å klikke "Ny Bruker"
        System.out.println("Brukeren som har et konto allerede kunne ikke logg inn med rigtig telefonnummer og feil kode  med å klikke Ny Bruker");
        LoggInnPage loggInn = new LoggInnPage();
        loggInn.tillatTillatelser();
        loggInn.nyBruker(rigtigTelefonnummer, feilKode);
        loggInn.bekreftLUgydigKode();
    }

    @Test
    public void testTC010() {
        //Brukeren som har et konto allerede kunne ikke logg inn med rigtig telefonnummer og feil kode  med å klikke "Ny Bruker"
        System.out.println("Brukeren som har et konto allerede kunne ikke logg inn med rigtig telefonnummer og feil kode  med å klikke Ny Bruker");
        LoggInnPage loggInn = new LoggInnPage();
        loggInn.tillatTillatelser();
        loggInn.nyBruker(rigtigTelefonnummer, feilKode);
        loggInn.bekreftLUgydigKode();
        loggInn.skrivKode(riktigKode);
        loggInn.bekreftLoggInn();
    }

    @Test
    public void testTC011() {
        //Brukeren kan swipe side til høyre og venstre for å se informasjon før logge inn "
        System.out.println("Brukeren kan swipe side til høyre og venstre for å se informasjon før logge inn ");
        LoggInnPage loggInn = new LoggInnPage();
        loggInn.tillatTillatelser();
        ReuseableMethods.swipe(800, 1000, 6000,0, "left");
        ReuseableMethods.swipe(800, 1000, 6000,0,"left");
        ReuseableMethods.swipe(800, 1000, 6000,0,"left");
        ReuseableMethods.swipe(800, 1000, 6000,0, "left");
        System.out.println("Swipe 4 ganger til venstre");
        ReuseableMethods.vente(2);
        loggInn.bekreftSwipe(loggInn.left);
        ReuseableMethods.swipe(200, 1000, 6000, 0,"right");
        ReuseableMethods.swipe(200, 1000, 6000, 0,"right");
        ReuseableMethods.swipe(200, 1000, 6000, 0,"right");
        ReuseableMethods.swipe(200, 1000, 6000, 0,"right");
        loggInn.bekreftSwipe(loggInn.right);
        System.out.println("Swipe 4 ganger til høyre");
    }

    @Test
    public void testTC012() {
        //Brukeren kan klikke puntumer for å reise til høyre og venstre for å se informasjon før logge inn "
        System.out.println("Brukeren kan swipe side til høyre og venstre for å se informasjon før logge inn ");
        LoggInnPage loggInn = new LoggInnPage();
        loggInn.tillatTillatelser();
        loggInn.reiseGjennomLoginSider(2, 3, 4, 5);
        System.out.println("Reiste 4 ganger til venstre");
        ReuseableMethods.vente(2);
        loggInn.bekreftSwipe(loggInn.left);
        loggInn.reiseGjennomLoginSider(4, 3, 2, 1);
        loggInn.bekreftSwipe(loggInn.right);
        System.out.println("Reiste 4 ganger til høyre");
    }

    @Test
    public void testTC013() {
        //Brukeren kan klikke lukke button (X) og tilbake button (<) på Logg inn og Ny bruker"
        System.out.println("Brukeren kan klikke lukke button (X) og tilbake button (<) på Logg inn og Ny bruker");
        LoggInnPage loggInn = new LoggInnPage();
        loggInn.tillatTillatelser();
        loggInn.sisteSide.click();
        loggInn.nyBruker.click();
        System.out.println("Klikket Ny bruker");
        loggInn.lukkeButton.click();
        loggInn.bekreftSwipe(loggInn.left);
        System.out.println("Klikket Lukke button på Ny bruker");
        loggInn.nyBruker.click();
        System.out.println("Klikket Ny bruker");
        loggInn.tilbakeButton.click();
        loggInn.bekreftSwipe(loggInn.left);
        System.out.println("Klikket Tilbake button på Ny bruker");
        ReuseableMethods.vente(2);
        loggInn.loggInn.click();
        System.out.println("Klikket Logg inn");
        loggInn.lukkeButton.click();
        loggInn.bekreftSwipe(loggInn.left);
        System.out.println("Klikket Lukke button på Logg inn");
        loggInn.loggInn.click();
        System.out.println("Klikket Logg inn");
        loggInn.tilbakeButton.click();
        System.out.println("Klikket Tilbake button på Logg inn");
        loggInn.bekreftSwipe(loggInn.left);

    }

}
