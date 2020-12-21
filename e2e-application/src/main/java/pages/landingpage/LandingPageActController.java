package pages.landingpage;

import bdd_models.ActController;
import scenarios_utils.CustomAssert;

public class LandingPageActController extends ActController<CustomAssert> {

    public LandingPageActController(CustomAssert customAssert) {
        super(customAssert);
    }

    public void insertTextToSearchField(String text) {
        customAssert().sendText(LandingPage.searchField, text, "Insert " + text + " to the search input field");
    }

    public void clickGoogleSearchButton() {
        customAssert().click(LandingPage.googleSearchButton, "Click 'Google Search' button");
    }

    public void clickGmailIcon() {
        customAssert().click(LandingPage.gmailIcon, "Click Gmail Icon");
    }

    public void clearTextFromSearchField() {
        customAssert().clearText(LandingPage.searchField, "Clear text to the search input field");
    }
}
