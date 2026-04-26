package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("praktika.user"),
                PropertyReader.getProperty("praktika.password"));
    }

    public static User withLockedPermission() {
        return new User(PropertyReader.getProperty("praktika.locked_user"),
                PropertyReader.getProperty("praktika.password"));
    }

    public static User withIncorrectPermission() {
        return new User(PropertyReader.getProperty("praktika.incorrect_user"),
                PropertyReader.getProperty("praktika.password"));
    }

    public static User withEmptyPassPermission() {
        return new User(PropertyReader.getProperty("praktika.user"),
                PropertyReader.getProperty("praktika.emptypassword"));
    }

    public static User withEmptyUserPermission() {
        return new User(PropertyReader.getProperty("praktika.emptyuser"),
                PropertyReader.getProperty("praktika.password"));
    }

    public static UserData withCorrectUser() {
        return new UserData(PropertyReader.getProperty("praktika.firstname"),
                PropertyReader.getProperty("praktika.lastname"), PropertyReader.getProperty("praktika.postalcode"));
    }

    public static UserData infoEmptyUserData() {
        return new UserData(PropertyReader.getProperty("praktika.emptyField"),
                PropertyReader.getProperty("praktika.emptyField"), PropertyReader.getProperty("praktika.emptyField"));
    }

    public static UserData infoEmptyFirstNameUserData() {
        return new UserData(PropertyReader.getProperty("praktika.emptyField"),
                PropertyReader.getProperty("praktika.lastname"), PropertyReader.getProperty("praktika.postalcode"));
    }
}