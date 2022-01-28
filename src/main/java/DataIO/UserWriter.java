package DataIO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class UserWriter {

    public UserWriter() {
    }

    public static void write(User user) throws IOException {

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/main/java/UserDB/" + user.getLogin() + ".json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        user.setPassword(pwdCoder(user.getPassword(), user.getLogin()));
        fileWriter.write(gson.toJson(user));
        fileWriter.close();
    }

    private static char[] pwdCoder(char[] pwd, String login) {
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
            encrypted[i] = (char) (pwd[i] + hash[i]);
        }
        return encrypted;
    }
}
