package stikkUTNorge.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import stikkUTNorge.utilities.Driver;

import java.awt.print.PageFormat;

public class TurPage {

    public TurPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }


}
