package pageObjects;

import entities.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NativePageObject  {

    private static final String BASE_LOCATOR = "platkovsky.alexey.epamtestapp:id/";

    @AndroidFindBy(id = BASE_LOCATOR + "register_button")
    private WebElement registerButton;
    @AndroidFindBy(id = BASE_LOCATOR + "registration_email")
    private WebElement emailRegistrationField;
    @AndroidFindBy(id = BASE_LOCATOR + "registration_username")
    private WebElement loginRegistrationField;
    @AndroidFindBy(id = BASE_LOCATOR + "registration_password")
    private WebElement passwordRegistrationField;
    @AndroidFindBy(id = BASE_LOCATOR + "registration_confirm_password")
    private WebElement passwordConfirmationField;
    @AndroidFindBy(id = BASE_LOCATOR + "register_new_account_button")
    private WebElement registerNewAccountButton;
    @AndroidFindBy(id = BASE_LOCATOR + "email_sign_in_button")
    WebElement signInButton;
    @AndroidFindBy(id = BASE_LOCATOR + "login_email")
    private WebElement emailField;
    @AndroidFindBy(id = BASE_LOCATOR + "login_pwd")
    private WebElement passwordField;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BudgetActivity']")
    private WebElement budgetActivityActionBarText;
    @AndroidFindBy(id = BASE_LOCATOR + "add_new_expense")
    private WebElement addExpenseButton;
    @AndroidFindBy(id = BASE_LOCATOR + "cancel_new_expense")
    private WebElement cancelNewExpenseButton;

    public NativePageObject register(User user) {
        registerButton.click();
        emailRegistrationField.sendKeys(user.getMail());
        loginRegistrationField.sendKeys(user.getLogin());
        passwordRegistrationField.sendKeys(user.getPassword());
        passwordConfirmationField.sendKeys(user.getPassword());
        registerNewAccountButton.click();
        return this;
    }

    public NativePageObject login(User user) {
        emailField.sendKeys(user.getMail());
        passwordField.sendKeys(user.getPassword());
        signInButton.click();
        return this;
    }

    public NativePageObject checkAddExpenseButtonPresence() {
        Assert.assertTrue(addExpenseButton.isDisplayed());
        return this;
    }

    public NativePageObject checkAddExpenseButtonFunctionality() {
        addExpenseButton.click();
        cancelNewExpenseButton.click();
        return this;
    }

    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

}
