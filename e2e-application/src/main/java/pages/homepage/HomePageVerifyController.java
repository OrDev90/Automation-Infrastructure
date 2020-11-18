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

    public void thatHeadlineIsValid(Headline headline) {
        CustomBy selectedCustomBy;
        String message;
        switch (headline) {
            case HEADLINE1 -> {
                selectedCustomBy = HomePage.headline1;
                message = "Verify 1st headline is valid";
            }
            case HEADLINE2 -> {
                selectedCustomBy = HomePage.headline2;
                message = "Verify 2nd headline is valid";
            }
            case HEADLINE3 -> {
                selectedCustomBy = HomePage.headline3;
                message = "Verify 3rd headline is valid";
            }
            case HEADLINE4 -> {
                selectedCustomBy = HomePage.headline4;
                message = "Verify 4th headline is valid";
            }
            case HEADLINE5 -> {
                selectedCustomBy = HomePage.headline5;
                message = "Verify 5th headline is valid";
            }
            case HEADLINE6 -> {
                selectedCustomBy = HomePage.headline6;
                message = "Verify 6th headline is valid";
            }
            case HEADLINE7 -> {
                selectedCustomBy = HomePage.headline7;
                message = "Verify 7th headline is valid";
            }
            case HEADLINE8 -> {
                selectedCustomBy = HomePage.headline8;
                message = "Verify 8th headline is valid";
            }
            case HEADLINE9 -> {
                selectedCustomBy = HomePage.headline9;
                message = "Verify 9th headline is valid";
            }
            case HEADLINE10 -> {
                selectedCustomBy = HomePage.headline10;
                message = "Verify 10th headline is valid";
            }
            case HEADLINE11 -> {
                selectedCustomBy = HomePage.headline11;
                message = "Verify 11th headline is valid";
            }
            case HEADLINE12 -> {
                selectedCustomBy = HomePage.headline12;
                message = "Verify 12th headline is valid";
            }
            case HEADLINE13 -> {
                selectedCustomBy = HomePage.headline13;
                message = "Verify 13th headline is valid";
            }
            case HEADLINE14 -> {
                selectedCustomBy = HomePage.headline14;
                message = "Verify 14th headline is valid";
            }
            case HEADLINE15 -> {
                selectedCustomBy = HomePage.headline15;
                message = "Verify 15th headline is valid";
            }
            case HEADLINE16 -> {
                selectedCustomBy = HomePage.headline16;
                message = "Verify 16th headline is valid";
            }
            case HEADLINE17 -> {
                selectedCustomBy = HomePage.headline17;
                message = "Verify 17th headline is valid";
            }
            default -> {
                selectedCustomBy = null;
                message = "";
            }
        }
        customAssert().verifyString(selectedCustomBy, headline.getHeadline(), message);
    }

    public void thatTextIsValid(Text text) {
        CustomBy selectedCustomBy;
        String message;
        switch (text) {
            case TEXT1 -> {
                selectedCustomBy = HomePage.text1;
                message = "Verify 1st text is valid";
            }
            case TEXT2 -> {
                selectedCustomBy = HomePage.text2;
                message = "Verify 2nd text is valid";
            }
            case TEXT3 -> {
                selectedCustomBy = HomePage.text3;
                message = "Verify 3rd text is valid";
            }
            case TEXT4 -> {
                selectedCustomBy = HomePage.text4;
                message = "Verify 4th text is valid";
            }
            case TEXT5 -> {
                selectedCustomBy = HomePage.text5;
                message = "Verify 5th text is valid";
            }
            case TEXT6 -> {
                selectedCustomBy = HomePage.text6;
                message = "Verify 6th text is valid";
            }
            case TEXT7 -> {
                selectedCustomBy = HomePage.text7;
                message = "Verify 7th text is valid";
            }
            case TEXT8 -> {
                selectedCustomBy = HomePage.text8;
                message = "Verify 8th text is valid";
            }
            case TEXT9 -> {
                selectedCustomBy = HomePage.text9;
                message = "Verify 9th text is valid";
            }
            case TEXT10 -> {
                selectedCustomBy = HomePage.text10;
                message = "Verify 10th text is valid";
            }
            case TEXT11 -> {
                selectedCustomBy = HomePage.text11;
                message = "Verify 11th text is valid";
            }
            case TEXT12 -> {
                selectedCustomBy = HomePage.text12;
                message = "Verify 12th text is valid";
            }
            case TEXT13 -> {
                selectedCustomBy = HomePage.text13;
                message = "Verify 13th text is valid";
            }
            case TEXT14 -> {
                selectedCustomBy = HomePage.text14;
                message = "Verify 14th text is valid";
            }
            default -> {
                selectedCustomBy = null;
                message = "";
            }
        }
        customAssert().verifyString(selectedCustomBy, text.getText(), message);
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
