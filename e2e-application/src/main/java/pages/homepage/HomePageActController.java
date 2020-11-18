package pages.homepage;

import bdd_models.ActController;
import scenarios_utils.CustomAssert;

public class HomePageActController extends ActController<CustomAssert> {

    public HomePageActController(CustomAssert customAssert) {
        super(customAssert);
    }

    public void clickSideWhatsappIcon() {
        customAssert().click(HomePage.sideWhatsappIcon, "Click side Whatsapp Icon");
    }

    public void clickFooterWebsiteIcon() {
        customAssert().click(HomePage.footerWebsiteIcon, "Click footer Website Icon");
    }

    public void clickFooterFacebookIcon() {
        customAssert().click(HomePage.footerFacebookIcon, "Click footer Facebook Icon");
    }

    public void clickFooterWhatsappIcon() {
        customAssert().click(HomePage.footerWhatsappIcon, "Click footer Whatsapp Icon");
    }

    public void clickFooterLinkedinIcon() {
        customAssert().click(HomePage.footerLinkedinIcon, "Click footer Linkedin Icon");
    }

    public void clickSliderRightArrow() {
        customAssert().click(HomePage.sliderRightArrow, "Click slider right arrow");
    }

    public void clickContactButton() {
        customAssert().click(HomePage.contactButton, "Click contact button");
    }

    public void sendTextToContactName(String text) {
        customAssert().sendText(HomePage.nameField, text, "Send text " + text + " to name input field");
    }

    public void sendTextToContactCompany(String text) {
        customAssert().sendText(HomePage.companyField, text, "Send text " + text + " to company input field");
    }

    public void sendTextToContactEmail(String text) {
        customAssert().sendText(HomePage.emailField, text, "Send text " + text + " to email input field");
    }

    public void sendTextToContactPhone(String text) {
        customAssert().sendText(HomePage.phoneField, text, "Send text " + text + " to phone input field");
    }

    public void clearTextFromContactPhone() {
        customAssert().clearText(HomePage.phoneField, "Clear text from phone input field");
    }

    public void clearTextFromContactEmail() {
        customAssert().clearText(HomePage.emailField, "Clear text from email input field");
    }

    public void clickGoToTopArrow() {
        customAssert().click(HomePage.goToTopArrow, "Click the go to top arrow");
    }

    public void saveCurrentTabReference() {
        customAssert().saveCurrentTabReference("Save the current tab reference");
    }
}
