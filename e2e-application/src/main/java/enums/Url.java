package enums;

public enum Url {

    URL1("https://www.google.com/?gws_rd=ssl"),
    URL2("https://www.google.com/intl/iw/gmail/about/#");

    private final String url;

    Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}
