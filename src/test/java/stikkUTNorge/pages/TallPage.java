package stikkUTNorge.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import stikkUTNorge.utilities.Driver;

public class TallPage {
    public TallPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }
}
