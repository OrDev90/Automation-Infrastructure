package pages.landingpage;

import bdd_models.ActController;
import scenarios_utils.CustomAssert;

public class LandingPageActController extends ActController<CustomAssert> {

    public LandingPageActController(CustomAssert customAssert) {
        super(customAssert);
    }

    public void clickGoToTopArrow() {
        customAssert().click(LandingPage.goToTopArrow, "Click the go to top arrow");
    }
}
