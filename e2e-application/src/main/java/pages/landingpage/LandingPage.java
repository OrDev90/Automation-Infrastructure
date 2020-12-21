package pages.landingpage;

import bdd_models.TestTarget;
import driver_utils.CustomBy;
import scenarios_utils.CustomAssert;

public class LandingPage extends TestTarget<LandingPageGetController, LandingPageActController, LandingPageVerifyController> {

    /**
     *  General
     */
    public final static CustomBy searchField = CustomBy.cssSelector("div[id='searchform'] > form > div:nth-of-type(2) > div > div > div > div:nth-of-type(2) > input");
    public final static CustomBy googleSearchButton = CustomBy.cssSelector("div[id='searchform'] > form > div:nth-of-type(2) > div > div:nth-of-type(3) input:nth-of-type(1)");
    public final static CustomBy gmailIcon = CustomBy.cssSelector("div[id='gbw'] > div > div > div > div:nth-of-type(1) > a");

    public LandingPage(CustomAssert customAssert) {
        super(new LandingPageGetController(customAssert),
                new LandingPageActController(customAssert),
                new LandingPageVerifyController(customAssert));
    }
}
