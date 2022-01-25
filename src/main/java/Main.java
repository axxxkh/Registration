import Actions.Exceprtions.UserExist;
import Actions.Exceprtions.WrongPassword;
import Actions.Registration;
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
        user.setPassword("dsff".toCharArray());
        user.setBirthday(LocalDate.now());
//        user.setSecretQuestion("question");
        user.setSecretAnswer("sdfsfs");
        user.setFavoriteColour("red");
        userWriter.write(user);

        UserReader readUser = new UserReader();
        User readed = readUser.read("aaa");
        readed.setLogin("bbb");
        userWriter.write(readed);
        Registration.start();

        try {
            System.out.println("my exception");
            throw new UserExist();
        } catch (UserExist e) {
            System.out.println(e);
        }

        try {
            System.out.println("Wrong pass");
            throw new WrongPassword();
        } catch (WrongPassword e) {

        }

    }
}
