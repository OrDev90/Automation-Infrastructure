package scenarios_utils;

import java.util.ResourceBundle;

public class WebsiteConfiguration {

    private final static String PROPERTIES_FILE_NAME = "env";
    public static String BASE_URL = null;

    public static void initConfiguration() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(PROPERTIES_FILE_NAME);
        BASE_URL = resourceBundle.getString("BASE_URL");
    }
}
