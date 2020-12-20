package pages.landingpage;

import bdd_models.TestTarget;
import driver_utils.CustomBy;
import scenarios_utils.CustomAssert;

public class LandingPage extends TestTarget<LandingPageGetController, LandingPageActController, LandingPageVerifyController> {

    /**
     *  General
     */
    public final static CustomBy goToTopArrow = CustomBy.className("huPgzm");

    public LandingPage(CustomAssert customAssert) {
        super(new LandingPageGetController(customAssert),
                new LandingPageActController(customAssert),
                new LandingPageVerifyController(customAssert));
    }
}
