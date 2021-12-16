package scenarios;

import entities.User;
import org.testng.annotations.*;
import pageObjects.NativePageObject;
import service.UserCreator;
import setup.BaseTest;


public class nativeMobileTests extends BaseTest {

    NativePageObject nativePageObject;
    User randomUser;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        nativePageObject = (NativePageObject) getPo().getPageObject();
        randomUser = UserCreator.createNewRandomUser();
    }

    @Test(groups = {"native"}, description = "Registering and logging into the app as a random user to make sure the BudgetActivity page is opened.")
    public void budgetActivityPageNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        nativePageObject.register(randomUser)
                .login(randomUser)
                .checkAddExpenseButtonPresence()
                .checkAddExpenseButtonFunctionality()
                .checkAddExpenseButtonPresence();

        System.out.println("budgetActivityPageNativeTest done");

    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        nativePageObject = null;
        randomUser = null;
    }

}
