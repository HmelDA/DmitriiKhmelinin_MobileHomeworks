package service;

import java.util.ResourceBundle;

public class PropertyReader {

    private static final ResourceBundle trelloBundle = ResourceBundle.getBundle(
            "mobile");

    public static String epamDomain() {
        return trelloBundle.getString("native.epamDomain");
    }

    public static String URL() {
        return trelloBundle.getString("web.URL");
    }

    public static String searchRequest() {
        return trelloBundle.getString("web.searchRequest");
    }

}
