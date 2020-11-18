package enums;

public enum Headline {

    HEADLINE1("מפתחים"),
    HEADLINE2("בשפה שלך"),
    HEADLINE3("הירולו - מובילים בפיתוח"),
    HEADLINE4("איך נוכל לעזור לכם?"),
    HEADLINE5("מיקור חוץ לפיתוח Frontend ובודקי איכות"),
    HEADLINE6("פרויקט Full Stack מקצה לקצה"),
    HEADLINE7("ייעוץ ושדרוג ל–JavaScript"),
    HEADLINE8("עבודות לדוגמה"),
    HEADLINE9("כמה מהלקוחות שלנו"),
    HEADLINE10("לכל שאלה תשובה"),
    HEADLINE11("אנחנו זקוקים לחיזוק והרחבת צוות הפיתוח הקיים, האם זה משהו שאתם יכולים לעזור בו?"),
    HEADLINE12("האם אתם מספקים רק שירותי פיתוח צד לקוח?"),
    HEADLINE13("האם יש לכם ניסיון עם חברות סטארטאפ?"),
    HEADLINE14("האם המפתחים שלכם עובדים ממקומות אחרים בעולם?"),
    HEADLINE15("למה כדאי לי לעבוד דווקא איתכם?"),
    HEADLINE16("איך נוכל להתקדם?"),
    HEADLINE17("רוצים לשמוע עוד?");

    private final String headline;

    Headline(String headline) {
        this.headline = headline;
    }

    public String getHeadline() {
        return this.headline;
    }
}
