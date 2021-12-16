package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.WebPageObject;
import service.PropertyReader;
import setup.BaseTest;

import java.util.List;

public class webMobileTests extends BaseTest {

    public static final String GOOGLE_URL = PropertyReader.URL();
    public static final String EPAM_REQUEST = PropertyReader.searchRequest();
    WebPageObject webPageObject;

    @Test(groups = {"web"}, description = "Make sure that there are some relevant results after searching by keyword 'EPAM'")
    public void epamSearchTest() throws InterruptedException {

        webPageObject = (WebPageObject) getPo().getPageObject();
        webPageObject.navigateToURL(GOOGLE_URL);
        webPageObject.enterRequestAndClickSearch(EPAM_REQUEST);
        List<String> results = webPageObject.getSearchResultsTextList();
        Assert.assertTrue(results.stream().anyMatch(result -> result.contains(EPAM_REQUEST)));

        System.out.println("epamSearchTest done");
    }

}
