package scenarios;

import enums.Url;
import org.testng.annotations.Test;
import scenarios_utils.TestBase;

public class Scenarios extends TestBase {

    @Test(description = "Validate home page url", groups = {"Sanity"})
    public void scenario1() {
        landingPage.verify().thatUrlIsCorrect(Url.URL1.getUrl());
    }

    @Test(description = "Insert text to search input and click 'Google Search' button, verify that search works", groups = {"Sanity"})
    public void scenario2() {

    }

    @Test(description = "Click Gmail Icon, verify the redirection to gmail landing page", groups = {"Sanity"})
    public void scenario3() {

    }

    @Test(description = "Click Gmail Icon, test tabs are working (Primary, Social, Promotions)", groups = {"Sanity"})
    public void scenario4() {

    }

    @Test(description = "Remove text from search input and click 'Google Search button, verify that search doesn't work", groups = {"Negative"})
    public void scenario5() {

    }
}
