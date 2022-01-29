package DataIO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/*
 * This class is designed to write new user or changed user to database
 */
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
        user.encrypt(true);
        fileWriter.write(gson.toJson(user));
        fileWriter.close();
    }
}
