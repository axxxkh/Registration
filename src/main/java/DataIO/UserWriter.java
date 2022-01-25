package DataIO;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class UserWriter {

    public UserWriter() {
    }

    public void write(User user) throws IOException {

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

    private char[] pwdCoder(char[] pwd, String login) {
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
        char[] hash = (login.hashCode() + codeString).toCharArray();
        char[] encrypted = new char[pwd.length];
        for (int i = 0; i < pwd.length; i++) {
            if (i < hash.length) {
                encrypted[i] = (char) (pwd[i] + hash[i]);
            } else {
                encrypted[i] = pwd[i];
            }
        }
        return encrypted;
    }
}
