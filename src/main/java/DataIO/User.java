package DataIO;

import Actions.Exceprtions.UserExist;
import com.google.gson.Gson;

import java.io.File;
import java.time.LocalDate;

public class User {
    private String login;
    private char[] password;
    private String email;
    private LocalDate birthday;
    private String secretQuestion;
    private String secretAnswer;
    private String favoriteColour;

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public char[] getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }

    public String getFavoriteColour() {
        return favoriteColour;
    }

    public void setFavoriteColour(String favoriteColour) {
        this.favoriteColour = favoriteColour;
    }

    private boolean isExist() {
        return new File("src/UserDB/" + this.login + ".json").isFile();
    }

    public User create(String json) throws UserExist {
        Gson parser = new Gson();
        User user = parser.fromJson(json, User.class);

        if (user.isExist()) {
            throw new UserExist();
        }
        return user;
    }

    public boolean checkRequiredFields(User user) {
        return !user.getLogin().isEmpty() && user.getPassword().length != 0 && !user.getEmail().isEmpty();
    }

    @Override
    public String toString() {
        return "login - " + this.login + ". e-mail: " + this.email + ". Birthdate - " + this.getBirthday()
                + ". Secret Question - " + this.secretQuestion + "Answer for secret question - " +
                this.secretAnswer + ". Favorite colour - " + this.favoriteColour;
    }
}
