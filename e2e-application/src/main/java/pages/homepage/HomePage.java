package pages.homepage;

import bdd_models.TestTarget;
import driver_utils.CustomBy;
import runner_utils.CustomAssert;

public class HomePage extends TestTarget<HomePageGetController, HomePageActController, HomePageVerifyController> {

    public final static CustomBy logoText = CustomBy.className("logo__Text-tdfmt3-3");

    public HomePage(CustomAssert customAssert) {
        super(new HomePageGetController(customAssert),
                new HomePageActController(customAssert),
                new HomePageVerifyController(customAssert));
    }
}
