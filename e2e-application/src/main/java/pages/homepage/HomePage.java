package pages.homepage;

import bdd_models.TestTarget;
import driver_utils.CustomBy;
import scenarios_utils.CustomAssert;

public class HomePage extends TestTarget<HomePageGetController, HomePageActController, HomePageVerifyController> {

    /**
     * Icons
     */
    public final static CustomBy sideWhatsappIcon = CustomBy.className("cjunrQ");
    public final static CustomBy footerWebsiteIcon = CustomBy.className("bXWGqN");
    public final static CustomBy footerFacebookIcon = CustomBy.className("eufMcD");
    public final static CustomBy footerWhatsappIcon = CustomBy.className("jOgeKm");
    public final static CustomBy footerLinkedinIcon = CustomBy.className("gcUHBk");

    /**
     * Headlines
     */
    public final static CustomBy headline1 = CustomBy.cssSelector("h2[class*='kTdOgs'] > span");
    public final static CustomBy headline2 = CustomBy.cssSelector("h2[class*='jKncTX'] > span");
    public final static CustomBy headline3 = CustomBy.cssSelector("h2[class*='gAjuXS'] > span");
    public final static CustomBy headline4 = CustomBy.cssSelector("div[class*='gXInJv'] + h2[class*='hFnTIP'] > span");
    public final static CustomBy headline5 = CustomBy.cssSelector("div[class*='hNxzDJ']:nth-of-type(1) h3[class*='bDmtNu'] > span");
    public final static CustomBy headline6 = CustomBy.cssSelector("div[class*='hNxzDJ']:nth-of-type(2) h3[class*='bDmtNu'] > span");
    public final static CustomBy headline7 = CustomBy.cssSelector("div[class*='hNxzDJ']:nth-of-type(3) h3[class*='bDmtNu'] > span");
    public final static CustomBy headline8 = CustomBy.cssSelector("h2[class*='cwVJTI'] > span");
    public final static CustomBy headline9 = CustomBy.cssSelector("div[class*='dPdBgB'] > h2[class*='hFnTIP'] > span");
    public final static CustomBy headline10 = CustomBy.cssSelector("h2[class*='fvaFnt'] > span");
    public final static CustomBy headline11 = CustomBy.cssSelector("section[class*='JaKvb']:nth-of-type(1) > h4[class*='gWrOLH']");
    public final static CustomBy headline12 = CustomBy.cssSelector("section[class*='JaKvb']:nth-of-type(2) > h4[class*='gWrOLH']");
    public final static CustomBy headline13 = CustomBy.cssSelector("section[class*='JaKvb']:nth-of-type(3) > h4[class*='gWrOLH']");
    public final static CustomBy headline14 = CustomBy.cssSelector("section[class*='JaKvb']:nth-of-type(4) > h4[class*='gWrOLH']");
    public final static CustomBy headline15 = CustomBy.cssSelector("section[class*='JaKvb']:nth-of-type(5) > h4[class*='gWrOLH']");
    public final static CustomBy headline16 = CustomBy.cssSelector("section[class*='JaKvb']:nth-of-type(6) > h4[class*='gWrOLH']");
    public final static CustomBy headline17 = CustomBy.cssSelector("h2[class*='biJcCF'] > span");

    /**
     * Text
     */
    public final static CustomBy text1 = CustomBy.cssSelector("h1[class*='bgDSPF']");
    public final static CustomBy text2 = CustomBy.cssSelector("h4[class*='diLMYT']:nth-of-type(1)");
    public final static CustomBy text3 = CustomBy.cssSelector("h4[class*='diLMYT']:nth-of-type(2)");
    public final static CustomBy text4 = CustomBy.cssSelector("div[class*='hNxzDJ']:nth-of-type(1) p[class*='cboLJD'] > span");
    public final static CustomBy text5 = CustomBy.cssSelector("div[class*='hNxzDJ']:nth-of-type(2) p[class*='cboLJD'] > span");
    public final static CustomBy text6 = CustomBy.cssSelector("div[class*='hNxzDJ']:nth-of-type(3) p[class*='cboLJD'] > span");
    public final static CustomBy text7 = CustomBy.cssSelector("section[class*='JaKvb']:nth-of-type(1) > p[class*='cboLJD'] > span");
    public final static CustomBy text8 = CustomBy.cssSelector("section[class*='JaKvb']:nth-of-type(2) > p[class*='cboLJD'] > span");
    public final static CustomBy text9 = CustomBy.cssSelector("section[class*='JaKvb']:nth-of-type(3) > p[class*='cboLJD'] > span");
    public final static CustomBy text10 = CustomBy.cssSelector("section[class*='JaKvb']:nth-of-type(4) > p[class*='cboLJD'] > span");
    public final static CustomBy text11 = CustomBy.cssSelector("section[class*='JaKvb']:nth-of-type(5) > p[class*='cboLJD'] > span");
    public final static CustomBy text12 = CustomBy.cssSelector("section[class*='JaKvb']:nth-of-type(6) > p[class*='cboLJD'] > span");
    public final static CustomBy text13 = CustomBy.cssSelector("p[class*='dMPGUj']:nth-of-type(1)");
    public final static CustomBy text14 = CustomBy.cssSelector("p[class*='dMPGUj']:nth-of-type(2)");

    /**
     * Example Projects
     */
    public final static CustomBy exampleSlickDots = CustomBy.cssSelector("div[class*='cCmxEs'] ul[class*='slick-dots'] > li");
    public final static CustomBy sliderRightArrow = CustomBy.cssSelector("div[class*='slick-next'] > img");
    public final static CustomBy exampleSlickSlides = CustomBy.cssSelector("section[class*='bMmzri'] > div[class*='slick-slide'] .slick-track > div");

    /**
     * Form
     */
    public final static CustomBy nameField = CustomBy.cssSelector("div[class*='gvuIlc']:nth-of-type(1) > div:nth-of-type(1) > input");
    public final static CustomBy nameFieldErrorMessage = CustomBy.cssSelector("div[class*='gvuIlc']:nth-of-type(1) > div:nth-of-type(1) span[class*='bDkbFh']");
    public final static CustomBy companyField = CustomBy.cssSelector("div[class*='gvuIlc']:nth-of-type(1) > div:nth-of-type(2) > input");
    public final static CustomBy companyFieldErrorMessage = CustomBy.cssSelector("div[class*='gvuIlc']:nth-of-type(1) > div:nth-of-type(2) span[class*='bDkbFh']");
    public final static CustomBy emailField = CustomBy.cssSelector("div[class*='gvuIlc']:nth-of-type(2) > div:nth-of-type(1) > input");
    public final static CustomBy emailFieldErrorMessage = CustomBy.cssSelector("div[class*='gvuIlc']:nth-of-type(2) > div:nth-of-type(1) span[class*='bDkbFh']");
    public final static CustomBy phoneField = CustomBy.cssSelector("div[class*='gvuIlc']:nth-of-type(2) > div:nth-of-type(2) > input");
    public final static CustomBy phoneFieldErrorMessage = CustomBy.cssSelector("div[class*='gvuIlc']:nth-of-type(2) > div:nth-of-type(2) span[class*='bDkbFh']");
    public final static CustomBy contactButton = CustomBy.cssSelector("a[class*='llCdxe']");

    /**
     *  General
     */
    public final static CustomBy goToTopArrow = CustomBy.className("huPgzm");

    public HomePage(CustomAssert customAssert) {
        super(new HomePageGetController(customAssert),
                new HomePageActController(customAssert),
                new HomePageVerifyController(customAssert));
    }
}
