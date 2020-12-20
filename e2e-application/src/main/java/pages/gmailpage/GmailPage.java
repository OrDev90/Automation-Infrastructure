package pages.gmailpage;

import bdd_models.TestTarget;
import scenarios_utils.CustomAssert;


public class GmailPage extends TestTarget<GmailPageGetController, GmailPageActController, GmailPageVerifyController> {
    public GmailPage(CustomAssert customAssert) {
        super(new GmailPageGetController(customAssert),
                new GmailPageActController(customAssert),
                new GmailPageVerifyController(customAssert));
    }
}
