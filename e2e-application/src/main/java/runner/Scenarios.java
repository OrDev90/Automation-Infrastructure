package runner;

import org.testng.annotations.Test;
import runner_utils.TestBase;

public class Scenarios extends TestBase {

    @Test(description = "scenario1")
    public void scenario1() {
        System.out.println(homePage.get().getLogoText());
    }
}
