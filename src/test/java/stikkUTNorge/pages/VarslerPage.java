package stikkUTNorge.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import stikkUTNorge.utilities.Driver;

public class VarslerPage {
    public VarslerPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }
}
