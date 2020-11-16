package pages.homepage;

import bdd_models.GetController;
import runner_utils.CustomAssert;

public class HomePageGetController extends GetController<CustomAssert> {

    public HomePageGetController(CustomAssert customAssert) {
        super(customAssert);
    }

    public String getLogoText() {
        String message = "Get logo text";
        return customAssert().getText(message, HomePage.logoText);
    }
}
