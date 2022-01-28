package DataIO;

import com.google.gson.Gson;
import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;

public class User {
    private String login;
    private char[] password;
    private char[] NewPassword;
    private String email = null;
    private LocalDate birthday;
    private String secretQuestion;
    private String secretAnswer;
    private String favoriteColour;

    public User() {
    }

    public String getLogin() {
        return login.toLowerCase(Locale.ROOT);
    }

    public void setLogin(String login) {
        this.login = login.toLowerCase(Locale.ROOT);
    }

    public char[] getPassword() {
        return password;
    }

    public String getEmail() {
        return email.toLowerCase(Locale.ROOT);
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase(Locale.ROOT);
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getSecretQuestion() {
        return secretQuestion.toLowerCase(Locale.ROOT);
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion.toLowerCase(Locale.ROOT);
    }

    public String getSecretAnswer() {
        return secretAnswer.toLowerCase(Locale.ROOT);
    }

    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer.toLowerCase(Locale.ROOT);
    }

    public String getFavoriteColour() {
        return favoriteColour.toLowerCase(Locale.ROOT);
    }

    public void setFavoriteColour(String favoriteColour) {
        this.favoriteColour = favoriteColour.toLowerCase(Locale.ROOT);
    }

    public boolean isExist() {
        return new File("src/main/java/UserDB/"+ this.login + ".json").isFile();
    }

    public static User create(String json) {
        Gson parser = new Gson();
        return parser.fromJson(json, User.class);
    }

    public boolean checkPassword(User user) {

        System.out.println(this.password.equals(user.password));
        return this.password.equals(user.password);
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
        return matchIndex > 70 ? true : false;
    }

    public void changePassword (User user) {
        if (this.login.equals(user.login)&&this.password.equals(user.password)) {
            this.password= user.NewPassword;
        }
    }

    @Override
    public String toString() {
        return "login - " + this.login + ". e-mail: " + this.email
                + ". Birthdate - " + this.getBirthday();
    }
}
