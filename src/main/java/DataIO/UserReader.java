package DataIO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class UserReader {
    public static User read(String login) throws IOException {

        File file = new File("src/main/java/UserDB/" + login.toLowerCase(Locale.ROOT) + ".json");
        FileReader fileReader = new FileReader(file);

        int i;
        StringBuilder sb = new StringBuilder();
        while ((i = fileReader.read()) != -1) {
            sb.append((char) i);
        }

        User user = User.create(sb.toString());
        user.encrypt(false);
        fileReader.close();
        return user;
    }
}
