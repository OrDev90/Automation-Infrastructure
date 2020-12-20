package enums;

public enum Url {

    URL1("https://www.google.com/?gws_rd=ssl"),
    URL2("https://mail.google.com");

    private final String url;

    Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}
