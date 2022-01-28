package Actions;

import DataIO.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

/*
 * In input file we look for two lines. First line is action to do:
 * creating user, changing password, changing personal data or sending personal data.
 * second line is json, so we deserialize it and depends on the action send to perform action class
 * */

public class Registration {
    public static void start() {

        File file = new File("src/main/java/Input/" + "input.json");
        FileReader fileReader;
        BufferedReader bf;
        String action;
        String temp;
        try {
            fileReader = new FileReader(file);
            bf = new BufferedReader(fileReader);
            action = bf.readLine().toUpperCase(Locale.ROOT);
            StringBuilder json = new StringBuilder();
            while ((temp = bf.readLine())!=null) {
                json.append(temp);
            }
            User user = User.create(json.toString());
            System.out.println(user.toString());
            System.out.println(user.isExist());
            PerformActions.action(action, user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
