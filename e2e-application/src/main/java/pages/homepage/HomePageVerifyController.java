package pages.homepage;

import bdd_models.VerifyController;
import driver_utils.CustomBy;
import enums.Headline;
import enums.Text;
import scenarios_utils.CustomAssert;

public class HomePageVerifyController extends VerifyController<CustomAssert> {

    public HomePageVerifyController(CustomAssert customAssert) {
        super(customAssert);
    }

    public void thatUrlIsCorrectInNewTab(String url) {
        customAssert().verifyUrlInNewTab(url, "Verify that the current URL is: " + url);
    }

    public void thatUrlIsCorrect(String url) {
        customAssert().verifyUrl(url, "Verify that the current URL is: " + url);
    }

    public void thatAllHeadlinesAreValid() {
        CustomBy selectedCustomBy;
        String message;
        for(int i = 0 ; i < HomePage.headlines.length ; i++) {
            selectedCustomBy = HomePage.headlines[i];
            message = "Verify that " + HomePageUtils.getPositionByIndex(i + 1) + " headline is valid";
            customAssert().verifyString(selectedCustomBy, Headline.HEADLINES.getHeadlineByIndex(i), message);
        }
    }

    public void thatAllTextsAreValid() {
        CustomBy selectedCustomBy;
        String message;
        for(int i = 0 ; i < HomePage.texts.length ; i++) {
            selectedCustomBy = HomePage.texts[i];
            message = "Verify that " + HomePageUtils.getPositionByIndex(i + 1) + " text is valid";
            customAssert().verifyString(selectedCustomBy, Text.TEXTS.getTextByIndex(i), message);
        }
    }

    public void thatSlickDotIsActive(int position) {
        customAssert().verifyClassNameOfElementInPosition(HomePage.exampleSlickDots,
                position, "slick-active",
                "Verify slick dot at position " + (position + 1) + " is active");
    }

    public void thatSliderShowCorrectImages(int position) {
        customAssert().verifyClassNameOfElementInPositionByAttribute(HomePage.exampleSlickSlides, "data-index", position,
                "slick-current",
                "Verify slider show correct images in position " + (position + 1));
    }

    public void thatErrorMessageHasAppearedForNameField() {
        customAssert().verifyElementExists(HomePage.nameFieldErrorMessage, "Verify that error message for the name field");
    }

    public void thatErrorMessageHasAppearedForCompanyField() {
        customAssert().verifyElementExists(HomePage.companyFieldErrorMessage, "Verify that error message for the company field");
    }

    public void thatErrorMessageHasAppearedForEmailField() {
        customAssert().verifyElementExists(HomePage.emailFieldErrorMessage, "Verify that error message for the email field");
    }

    public void thatErrorMessageHasAppearedForPhoneField() {
        customAssert().verifyElementExists(HomePage.phoneFieldErrorMessage, "Verify that error message for the phone field");
    }

    public void thatPageYOffsetIs(String offset) {
        customAssert().runJsScript("window.pageYOffset", offset, "Verify that page Y offset is " + offset);
    }
}
