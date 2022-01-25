package DataIO;

import com.google.gson.Gson;
import java.io.*;

public class UserWriter {
//
//    public UserWriter(User user) {
//        this.login = user.login;
//        this.password = user.password;
//        this.birthday=user.birthday;
//        this.secretQuestion=user.secretQuestion;
//        this.secretAnswer=user.secretAnswer;
//        this.favoriteColour=user.favoriteColour;
//    }
    public UserWriter () {
    }

    public void write (User user) throws IOException {
//        FileWriter file = new FileWriter("src/UserDB/"+user.getLogin()+".txt",true);
//        PrintWriter writer = new PrintWriter(file);
//        writer.println(user.getLogin());
//        writer.println(pwdCoder(user.getPassword(), user.getLogin()));
//        writer.println(user.getBirthday());
//        writer.println(user.getSecretAnswer());
//        writer.println(user.getSecretQuestion());
//        writer.println(user.getFavoriteColour());
//        writer.flush();
//        writer.close();

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/main/java/UserDB/" + user.getLogin() + ".json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        user.setPassword(pwdCoder(user.getPassword(), user.getLogin()));
        fileWriter.write(gson.toJson(user));
        fileWriter.close();
    }

    private char[] pwdCoder (char[] pwd, String login) {
        char[] hash = String.valueOf(login.hashCode()).toCharArray();
        char[] encrypted = new char[pwd.length];
        for (int i = 0; i < pwd.length; i++) {
            if (i<hash.length) {
                encrypted[i]= (char) (pwd[i]+hash[i]);
            } else {
                encrypted[i]=pwd[i];
            }
        }

        return encrypted;
    }
}
