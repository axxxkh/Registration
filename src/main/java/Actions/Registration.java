package Actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class Registration {
    public static void start() {
        File file = new File("src/main/java/Input/" + "input.json");
        FileReader fileReader;
        BufferedReader bf;
        String action;
        String json;
        try {
            fileReader = new FileReader(file);
            bf = new BufferedReader(fileReader);
            action = bf.readLine().toUpperCase(Locale.ROOT);
            json = bf.readLine();
            PerformActions.action(action, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
