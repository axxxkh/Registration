import DataIO.User;
import DataIO.UserReader;
import DataIO.UserWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        UserWriter userWriter = new UserWriter();
        User user = new User();
        user.setLogin("aaa");
        user.setPassword("dsfsf".toCharArray());
        user.setBirthday(LocalDate.now());
//        user.setSecretQuestion("question");
        user.setSecretAnswer("sdfsfs");
        user.setFavoriteColour("red");
        userWriter.write(user);

        UserReader readUser = new UserReader();
        User readed = readUser.read("aaa");
        readed.setLogin("bbb");
        userWriter.write(readed);
    }
}
