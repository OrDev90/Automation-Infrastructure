package scenarios;

import enums.Url;
import org.testng.annotations.Test;
import scenarios_utils.TestBase;

public class Scenarios extends TestBase {

    @Test(description = "Validate landing page url", groups = {"Sanity"})
    public void scenario1() {
        landingPage.verify().thatUrlIsCorrect(Url.URL1.getUrl());
    }

    @Test(description = "Insert text to search input and click 'Google Search' button, verify that search works", groups = {"Sanity"})
    public void scenario2() {
        landingPage.act().insertTextToSearchField("Google");
        landingPage.act().clickGoogleSearchButton();
        landingPage.verify().thatSearchWorks();
    }

    @Test(description = "Click Gmail Icon, verify the redirection to gmail landing page", groups = {"Sanity"})
    public void scenario3() {
        landingPage.act().clickGmailIcon();
        landingPage.verify().thatUrlIsCorrect(Url.URL2.getUrl());
    }

    @Test(description = "Remove text from search input and click 'Google Search button, verify that search doesn't work", groups = {"Negative"})
    public void scenario4() {
        landingPage.act().clearTextFromSearchField();
        landingPage.act().clickGoogleSearchButton();
        landingPage.verify().thatSearchIsDisabled();
    }
}
