package pages.landingpage;

import bdd_models.VerifyController;
import scenarios_utils.CustomAssert;

public class LandingPageVerifyController extends VerifyController<CustomAssert> {

    public LandingPageVerifyController(CustomAssert customAssert) {
        super(customAssert);
    }

    public void thatUrlIsCorrect(String url) {
        customAssert().verifyUrl(url, "Verify that the current URL is: " + url);
    }

    public void thatSearchWorks() {
        customAssert().verifyUrlContains("search", "Verify that search works");
    }

    public void thatSearchIsDisabled() {
        customAssert().verifyUrlNotContains("search", "Verify that search is disabled");
    }
}
