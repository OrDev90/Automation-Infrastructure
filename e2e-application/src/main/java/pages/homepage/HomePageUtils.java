package pages.homepage;

public class HomePageUtils {

    protected static String getPositionByIndex(int index) {
        String position;
        if(index == 1) {
            position = "1st";
        } else if(index == 2) {
            position = "2nd";
        } else if(index == 3) {
            position = "3rd";
        } else {
            position = index + "th";
        }
        return position;
    }
}
