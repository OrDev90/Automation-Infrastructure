package scenarios;

import enums.Headline;
import enums.Text;
import enums.Url;
import org.testng.annotations.Test;
import scenarios_utils.TestBase;
import utils.StringUtils;

public class Scenarios extends TestBase {

    @Test(description = "Validate home page url", groups = {"Sanity"})
    public void scenario1() {
        homePage.verify().thatUrlIsCorrect(Url.URL6.getUrl());
    }

    @Test(description = "Click on all icons and validate url after click", groups = {"Sanity"})
    public void scenario2() {
        homePage.act().saveCurrentTabReference();
        homePage.act().clickSideWhatsappIcon();
        homePage.verify().thatUrlIsCorrectInNewTab(Url.URL1.getUrl());
        homePage.act().saveCurrentTabReference();
        homePage.act().clickFooterWebsiteIcon();
        homePage.verify().thatUrlIsCorrectInNewTab(Url.URL2.getUrl());
        homePage.act().saveCurrentTabReference();
        homePage.act().clickFooterFacebookIcon();
        homePage.verify().thatUrlIsCorrectInNewTab(Url.URL3.getUrl());
        homePage.act().saveCurrentTabReference();
        homePage.act().clickFooterWhatsappIcon();
        homePage.verify().thatUrlIsCorrectInNewTab(Url.URL4.getUrl());
        homePage.act().saveCurrentTabReference();
        homePage.act().clickFooterLinkedinIcon();
        homePage.verify().thatUrlIsCorrectInNewTab(Url.URL5.getUrl());
    }

    @Test(description = "Validate all headlines and text", groups = {"Sanity"})
    public void scenario3() {
        homePage.verify().thatHeadlineIsValid(Headline.HEADLINE1);
        homePage.verify().thatHeadlineIsValid(Headline.HEADLINE2);
        homePage.verify().thatHeadlineIsValid(Headline.HEADLINE3);
        homePage.verify().thatHeadlineIsValid(Headline.HEADLINE4);
        homePage.verify().thatHeadlineIsValid(Headline.HEADLINE5);
        homePage.verify().thatHeadlineIsValid(Headline.HEADLINE6);
        homePage.verify().thatHeadlineIsValid(Headline.HEADLINE7);
        homePage.verify().thatHeadlineIsValid(Headline.HEADLINE8);
        homePage.verify().thatHeadlineIsValid(Headline.HEADLINE9);
        homePage.verify().thatHeadlineIsValid(Headline.HEADLINE10);
        homePage.verify().thatHeadlineIsValid(Headline.HEADLINE11);
        homePage.verify().thatHeadlineIsValid(Headline.HEADLINE12);
        homePage.verify().thatHeadlineIsValid(Headline.HEADLINE13);
        homePage.verify().thatHeadlineIsValid(Headline.HEADLINE14);
        homePage.verify().thatHeadlineIsValid(Headline.HEADLINE15);
        homePage.verify().thatHeadlineIsValid(Headline.HEADLINE16);
        homePage.verify().thatHeadlineIsValid(Headline.HEADLINE17);
        homePage.verify().thatTextIsValid(Text.TEXT1);
        homePage.verify().thatTextIsValid(Text.TEXT2);
        homePage.verify().thatTextIsValid(Text.TEXT3);
        homePage.verify().thatTextIsValid(Text.TEXT4);
        homePage.verify().thatTextIsValid(Text.TEXT5);
        homePage.verify().thatTextIsValid(Text.TEXT6);
        homePage.verify().thatTextIsValid(Text.TEXT7);
        homePage.verify().thatTextIsValid(Text.TEXT8);
        homePage.verify().thatTextIsValid(Text.TEXT9);
        homePage.verify().thatTextIsValid(Text.TEXT10);
        homePage.verify().thatTextIsValid(Text.TEXT11);
        homePage.verify().thatTextIsValid(Text.TEXT12);
        homePage.verify().thatTextIsValid(Text.TEXT13);
        homePage.verify().thatTextIsValid(Text.TEXT14);
    }

    @Test(description = "In example projects, verify that the first purple circle is selected, click right arrow, " +
            "verify that all images have changed, click right arrow until the initial image has returned", groups = {"Sanity"})
    public void scenario4() {
        homePage.verify().thatSlickDotIsActive(0);
        homePage.verify().thatSliderShowCorrectImages(0);
        homePage.act().clickSliderRightArrow();
        homePage.verify().thatSlickDotIsActive(1);
        homePage.verify().thatSliderShowCorrectImages(1);
        homePage.act().clickSliderRightArrow();
        homePage.verify().thatSlickDotIsActive(2);
        homePage.verify().thatSliderShowCorrectImages(2);
        homePage.act().clickSliderRightArrow();
        homePage.verify().thatSlickDotIsActive(3);
        homePage.verify().thatSliderShowCorrectImages(3);
        homePage.act().clickSliderRightArrow();
        homePage.verify().thatSlickDotIsActive(4);
        homePage.verify().thatSliderShowCorrectImages(4);
        homePage.act().clickSliderRightArrow();
        homePage.verify().thatSlickDotIsActive(0);
        homePage.verify().thatSliderShowCorrectImages(0);
    }

    @Test(description = "In the bottom form, click the button and verify that all fields are mandatory" , groups = {"Negative"})
    public void scenario5() {
        homePage.act().clickContactButton();
        homePage.verify().thatErrorMessageHasAppearedForNameField();
        homePage.verify().thatErrorMessageHasAppearedForCompanyField();
        homePage.verify().thatErrorMessageHasAppearedForEmailField();
        homePage.verify().thatErrorMessageHasAppearedForPhoneField();
    }

    @Test(description = "In the bottom form, test negative inputs to telephone and email" , groups = {"Negative"})
    public void scenario6() {
        homePage.act().sendTextToContactPhone(StringUtils.generateRandomNumberInLength(10));
        homePage.act().clickContactButton();
        homePage.verify().thatErrorMessageHasAppearedForPhoneField();
        homePage.act().clearTextFromContactPhone();
        homePage.act().sendTextToContactPhone(StringUtils.generateRandomIllegalCharactersStringInLength(10));
        homePage.act().clickContactButton();
        homePage.verify().thatErrorMessageHasAppearedForPhoneField();
        homePage.act().clearTextFromContactPhone();
        homePage.act().sendTextToContactPhone(StringUtils.generateRandomLong());
        homePage.act().clickContactButton();
        homePage.verify().thatErrorMessageHasAppearedForPhoneField();
        homePage.act().clearTextFromContactPhone();
        homePage.act().sendTextToContactPhone(StringUtils.generateRandomStringInLength(10));
        homePage.act().clickContactButton();
        homePage.verify().thatErrorMessageHasAppearedForPhoneField();
        homePage.act().clearTextFromContactPhone();
        homePage.act().sendTextToContactEmail(StringUtils.generateRandomIllegalCharactersStringInLength(10));
        homePage.act().clickContactButton();
        homePage.verify().thatErrorMessageHasAppearedForEmailField();
        homePage.act().clearTextFromContactEmail();
        homePage.act().sendTextToContactEmail(StringUtils.generateRandomNumberInLength(10));
        homePage.act().clickContactButton();
        homePage.verify().thatErrorMessageHasAppearedForEmailField();
        homePage.act().clearTextFromContactEmail();
        homePage.act().sendTextToContactEmail(StringUtils.generateInvalidEmailAtVersion());
        homePage.act().clickContactButton();
        homePage.verify().thatErrorMessageHasAppearedForEmailField();
        homePage.act().clearTextFromContactEmail();
        homePage.act().sendTextToContactEmail(StringUtils.generateInvalidEmailSuffixVersion());
        homePage.act().clickContactButton();
        homePage.verify().thatErrorMessageHasAppearedForEmailField();
        homePage.act().clearTextFromContactEmail();
    }

    @Test(description = "Scroll to the bottom of the page, verify the arrow up button leads to the top" , groups = {"Sanity"})
    public void scenario7() {
        homePage.act().clickContactButton();
        homePage.act().clickGoToTopArrow();
        homePage.verify().thatPageYOffsetIs("0");
    }

    @Test(description = "Fill bottom form inputs and click the send button" , groups = {"Sanity"})
    public void scenario8() {
        homePage.act().sendTextToContactName(StringUtils.generateRandomName());
        homePage.act().sendTextToContactCompany(StringUtils.generateRandomStringInLength(8));
        homePage.act().sendTextToContactEmail(StringUtils.generateRandomEmail());
        homePage.act().sendTextToContactPhone(StringUtils.generateRandomPhone());
        homePage.act().clickContactButton();
    }
}
