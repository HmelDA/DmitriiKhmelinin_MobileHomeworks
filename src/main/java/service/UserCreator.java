package service;

import entities.User;

public class UserCreator {

    public static final String USER_E_MAIL = PropertyReader.userEMail();
    public static final String USER_LOGIN = PropertyReader.userName();
    public static final String USER_PASSWORD = PropertyReader.userPassword();


    public static User withCredentialsFromProperty() {
        return new User( USER_E_MAIL, USER_LOGIN, USER_PASSWORD);
    }

    public static User withEmptyLogin() {
        return new User(USER_E_MAIL, "", USER_PASSWORD);
    }

    public static User withEmptyPassword() {
        return new User(USER_E_MAIL, USER_LOGIN, "");
    }

    public static User withEmptyMail() {
        return new User("", USER_LOGIN, USER_PASSWORD);
    }
}
