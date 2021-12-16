package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class WebPageObject {

    public static final Integer WAIT = 30;

    AppiumDriver appiumDriver;

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchField;
    @FindBy(xpath = "//*[@id='rso']/div")
    List<WebElement> searchResultsList;

    public WebPageObject(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public WebPageObject navigateToURL(String url) {
        appiumDriver.navigate().to(url);
        new WebDriverWait(appiumDriver, WAIT).until(wd -> ((JavascriptExecutor) wd)
                .executeScript("return document.readyState")
                .equals("complete")
        );
        return this;
    }

    public WebPageObject enterRequestAndClickSearch(String request) {
        searchField.sendKeys(request);
        searchField.sendKeys(Keys.ENTER);
        new WebDriverWait(appiumDriver, WAIT).until(
                wd -> ((JavascriptExecutor) wd)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
        return this;
    }

    public List<String> getSearchResultsTextList() {
        return searchResultsList
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


}
