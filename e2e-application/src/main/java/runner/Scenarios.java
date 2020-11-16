package runner;

import org.testng.annotations.Test;
import runner_utils.TestBase;

public class Scenarios extends TestBase {

    @Test(description = "Click on all icons and validate url after click", groups = {"Sanity"})
    public void scenario1() {
    }

    @Test(description = "Validate home page url", groups = {"Sanity"})
    public void scenario2() {
    }

    @Test(description = "Validate all headlines and text", groups = {"Sanity"})
    public void scenario3() {
    }

    @Test(description = "In assistance block, match image to text", groups = {"Sanity"})
    public void scenario4() {
    }

    @Test(description = "In example projects, verify that the first purple circle is selected, click right arrow, " +
            "verify that all picture have changed, click right arrow until all former pictures have returned", groups = {"Sanity"})
    public void scenario5() {
    }

    @Test(description = "Change viewport to smaller resolution, verify that images are responsive" , groups = {"Compatibility"})
    public void scenario6() {
    }

    @Test(description = "In Clients, Verify that there are 12 images in each section" , groups = {"Sanity"})
    public void scenario7() {
    }

    @Test(description = "In Clients, Change viewport to smaller resolution," +
            " Verify that there are 9 images in each section and that images are responsive" , groups = {"Compatibility"})
    public void scenario8() {
    }

    @Test(description = "In the bottom form, click the button and verify that all field are mandatory" , groups = {"Sanity"})
    public void scenario9() {
    }

    @Test(description = "In the bottom form, test negative inputs to telephone and email" , groups = {"Negative"})
    public void scenario10() {
    }

    @Test(description = "Verify bottom form footer exists, scroll to the bottom of the page, verify the footer disappears" , groups = {"Sanity"})
    public void scenario11() {
    }

    @Test(description = "Scroll to the bottom of the page, verify the arrow up button leads to the top" , groups = {"Sanity"})
    public void scenario12() {
    }

    @Test(description = "Insert bottom form inputs and click the send button" , groups = {"Sanity"})
    public void scenario13() {
    }

    @Test(description = "Six different users requesting the home page and perform actions simultaneously" , groups = {"Load"})
    public void scenario14() {
    }

}
