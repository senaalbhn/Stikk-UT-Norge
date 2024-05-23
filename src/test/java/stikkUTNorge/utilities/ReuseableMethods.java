package stikkUTNorge.utilities;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ReuseableMethods {

     public static void vente(int sekunder) {
        try {
            Thread.sleep(sekunder);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void bekreft(WebElement element){
        Assert.assertTrue(element.isDisplayed(),element.getText()+" vises");
    }
}
