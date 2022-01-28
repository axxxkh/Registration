package DataIO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class UserReader {
    public static User read(String login) throws IOException {

        File file = new File("src/main/java/UserDB/" + login.toLowerCase(Locale.ROOT) + ".json");
        FileReader fileReader = null;
        fileReader = new FileReader(file);

        int i;
        StringBuilder sb = new StringBuilder();
        while ((i = fileReader.read()) != -1) {
            sb.append((char) i);
        }

        User user = User.create(sb.toString());
        user.setPassword(pwdCoder(user.getPassword(), user.getLogin()));
        fileReader.close();
        return user;
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
        char[] decrypted = new char[pwd.length];
        for (int i = 0; i < pwd.length; i++) {
            decrypted[i] = (char) (pwd[i] - hash[i]);
        }
        return decrypted;
    }
}
