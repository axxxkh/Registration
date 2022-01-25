package DataIO;

import java.io.File;
import java.time.LocalDate;

public class User {
    private String login;
    public char[] password;
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

    public boolean isExist() {
        if (new File("src/UserDB/" + this.login + ".txt").isFile()) {
            return true;
        }
        return false;
    }
}
