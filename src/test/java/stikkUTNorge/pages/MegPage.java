package stikkUTNorge.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import stikkUTNorge.utilities.Driver;

public class MegPage {
    public MegPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy (accessibility = "Meg")
    private WebElement meg;
    //Min Bedrift
    @AndroidFindBy (accessibility = "Min bedrift\n" +
            "NIVERO/NIMMO")
    private WebElement minBedrift;
    @AndroidFindBy ( accessibility = "Vis flere")
    private WebElement visFlere;
    @AndroidFindBy (accessibility = "Deg")
    private WebElement deg;


}
