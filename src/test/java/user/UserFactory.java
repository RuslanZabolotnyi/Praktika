package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withLockedPermission() {
        return new User(PropertyReader.getProperty("saucedemo.locked_user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withIncorrectPermission() {
        return new User(PropertyReader.getProperty("saucedemo.incorrect_user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withEmptyPassPermission() {
        return new User(PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.emptypassword"));
    }

    public static User withEmptyUserPermission() {
        return new User(PropertyReader.getProperty("saucedemo.emptyuser"),
                PropertyReader.getProperty("saucedemo.password"));
    }
}
