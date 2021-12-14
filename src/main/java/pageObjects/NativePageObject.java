package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import service.PropertyReader;

public class NativePageObject  {

    private static final String BASE_LOCATOR = "platkovsky.alexey.epamtestapp:id/";

    @AndroidFindBy(id = BASE_LOCATOR + "email_sign_in_button")
    WebElement signInBtn;


    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }


}
