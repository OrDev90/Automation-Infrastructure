package enums;

public enum Url {

    URL1("https://api.whatsapp.com/send?phone=972544945333"),
    URL2("https://herolo.co.il/?lang=he"),
    URL3("https://www.facebook.com/Herolofrontend"),
    URL4("https://api.whatsapp.com/send?phone=972544945333"),
    URL5("https://www.linkedin.com/company/herolo/"),
    URL6("https://automation.herolo.co.il/");

    private final String url;

    Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}
