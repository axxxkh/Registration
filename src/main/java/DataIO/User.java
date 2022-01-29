package DataIO;

import com.google.gson.Gson;
import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;

/*
 * User class has all private fields, and only one getter for login
 * Also it has next methods:
 * - isExist - to check if is there user with the same login at database, return true or false
 * - create - return new user from json string
 * - check password - check password matching, return true or false
 * - checkRequiredField - check if all of necessary fields is filled
 * - match - used to check all information when user forget password. Returns true if matching over 70%
 * -  */

public class User {
    private String login;
    private char[] password;
    private char[] NewPassword;
    private final String email = null;
    private LocalDate birthday;
    private String secretQuestion;
    private String secretAnswer;
    private String favoriteColour;

    public User() {
    }

    public String getLogin() {
        return login.toLowerCase(Locale.ROOT);
    }

    public boolean isExist() {
        return new File("src/main/java/UserDB/" + this.login.toLowerCase(Locale.ROOT) + ".json").isFile();
    }

    public static User create(String json) {
        Gson parser = new Gson();
        return parser.fromJson(json, User.class);
    }

    public boolean checkPassword(User user) {
        return Arrays.equals(this.password, user.password);
    }

    public boolean checkRequiredFields(User user) {
        return user.login != null && user.password != null && user.email != null;
    }

    public boolean match(User user) {
        final int PWD_VAL = 50;
        final int EMAIL_VAL = 15;
        final int BIRTH_VAL = 10;
        final int SEC_Q_VAL = 10;
        final int SEC_A_VAL = 10;
        final int FAV_COL_VAL = 10;
        final int FIELDS_QTY = 7;

        int matchIndex = 0;
        int fieldsFilled = 0;
        for (int i = 0; i < (user.password.length > this.password.length ?
                this.password.length : user.password.length); i++) {
            if (this.password[i] == user.password[i]) {
                matchIndex += PWD_VAL / user.password.length;
            }
        }
        fieldsFilled += 1;

        if (this.email != null && this.email.equals(user.email)) {
            fieldsFilled += 1;
            matchIndex += EMAIL_VAL;
        }
        if (this.birthday != null && this.birthday.equals(user.birthday)) {
            fieldsFilled += 1;
            matchIndex += BIRTH_VAL;

        }
        if (this.secretQuestion != null && this.secretQuestion.equals(user.secretQuestion)) {
            fieldsFilled += 1;
            matchIndex += SEC_Q_VAL;
        }
        if (this.secretAnswer != null & this.secretAnswer.equals(user.secretAnswer)) {
            fieldsFilled += 1;
            matchIndex += SEC_A_VAL;
        }
        if (this.favoriteColour != null && this.favoriteColour.equals(user.favoriteColour)) {
            fieldsFilled += 1;
            matchIndex += FAV_COL_VAL;
        }

        matchIndex = matchIndex * FIELDS_QTY / fieldsFilled;
        return matchIndex > 70;
    }

    public void changePassword(User user) {
        if (this.login.equals(user.login) && Arrays.equals(this.password, user.password)) {
            this.password = user.NewPassword;
        }
    }

    @Override
    public String toString() {
        return "login - " + this.login + ". e-mail: " + this.email
                + ". Birthdate - " + this.birthday;
    }

    public void encrypt() {
        String codeString = "Еней був парубок моторний\n" +
                "І хлопець хоть куди козак,\n" +
                "Удавсь на всеє зле проворний,\n" +
                "Завзятійший од всіх бурлак.\n" +
                "Но греки, як спаливши Трою,\n" +
                "Зробили з неї скирту гною,\n" +
                "Він, взявши торбу, тягу дав;\n" +
                "Забравши деяких троянців,\n" +
                "Осмалених, як гиря, ланців,\n" +
                "П’ятами з Трої накивав.";
        char[] hash = (this.login.hashCode() + codeString).toCharArray();
        char[] encrypted = new char[password.length];
        for (int i = 0; i < password.length; i++) {
            encrypted[i] = (char) (password[i] + hash[i]);
        }
        this.password=encrypted;
    }
}
