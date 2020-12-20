package enums;

public enum Headline {

    HEADLINES(new String[] {"מפתחים",
            "בשפה שלך",
            "הירולו - מובילים בפיתוח",
            "איך נוכל לעזור לכם?",
            "מיקור חוץ לפיתוח Frontend ובודקי איכות",
            "פרויקט Full Stack מקצה לקצה",
            "ייעוץ ושדרוג ל–JavaScript",
            "עבודות לדוגמה",
            "כמה מהלקוחות שלנו",
            "לכל שאלה תשובה",
            "אנחנו זקוקים לחיזוק והרחבת צוות הפיתוח הקיים, האם זה משהו שאתם יכולים לעזור בו?",
            "האם אתם מספקים רק שירותי פיתוח צד לקוח?",
            "האם יש לכם ניסיון עם חברות סטארטאפ?",
            "האם המפתחים שלכם עובדים ממקומות אחרים בעולם?",
            "למה כדאי לי לעבוד דווקא איתכם?",
            "איך נוכל להתקדם?",
            "רוצים לשמוע עוד?"});

    private final String[] headlines;

    Headline(String[] headlines) {
        this.headlines = headlines;
    }

    public String getHeadlineByIndex(int index) {
        return this.headlines[index];
    }

    public String[] getHeadlines() {
        return this.headlines;
    }
}
