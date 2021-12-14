package service;

import java.util.ResourceBundle;

public class PropertyReader {

    private static final ResourceBundle trelloBundle = ResourceBundle.getBundle(
            "mobile");

    public static String userEMail() {
        return trelloBundle.getString("native.userEMail");
    }

    public static String userName() {
        return trelloBundle.getString("native.userName");
    }

    public static String userPassword() {
        return trelloBundle.getString("native.userPassword");
    }

    public static String baseLocator() {
        return trelloBundle.getString("native.baseLocator");
    }

    public static String URL() {
        return trelloBundle.getString("web.URL");
    }

    public static String searchRequest() {
        return trelloBundle.getString("web.searchRequest");
    }

}
