package service;

import entities.User;
import util.RandomStringGenerator;

public class UserCreator {

    public static final String RANDOM_USER_E_MAIL = RandomStringGenerator.generateString() + PropertyReader.epamDomain();
    public static final String RANDOM_USER_LOGIN = RandomStringGenerator.generateString();
    public static final String RANDOM_USER_PASSWORD = RandomStringGenerator.generateString();

    public static User createNewRandomUser() {
        return new User(RANDOM_USER_E_MAIL, RANDOM_USER_LOGIN, RANDOM_USER_PASSWORD);
    }

    public static User createNewUserWithEmptyMail() {
        return new User("", RANDOM_USER_LOGIN, RANDOM_USER_PASSWORD);
    }

    public static User createNewUserWithEmptyLogin() {
        return new User(RANDOM_USER_E_MAIL, "", RANDOM_USER_PASSWORD);
    }

    public static User createNewUserWithEmptyPassword() {
        return new User(RANDOM_USER_E_MAIL, RANDOM_USER_LOGIN, "");
    }
}
