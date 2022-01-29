package Actions;

import DataIO.LogWriter;
import DataIO.User;
import DataIO.UserReader;
import DataIO.UserWriter;
import Exceptions.InvalidDataToRecover;
import Exceptions.UserExist;
import java.io.IOException;
import java.util.Locale;
/*
* perform action to change password
*/
public class ChangePassword {
    public void changePWD(User user) throws IOException {
        User userFromDB = UserReader.read(user.getLogin());
        try {
            if (!user.isExist()) {
                throw new UserExist("No such user at the database.");
            }
            if (!userFromDB.match(user)) {
                throw new InvalidDataToRecover();
            }
            UserWriter.write(user);
            LogWriter.writeLog("Password for "
                    + user.getLogin().toUpperCase(Locale.ROOT) + " was successfully changed");
        } catch (UserExist userExist) {
            LogWriter.writeLog(userExist + " password wasn't changed");
        } catch (InvalidDataToRecover e) {
            LogWriter.writeLog(e + "Password for "
                    + user.getLogin().toUpperCase(Locale.ROOT) + "wasn't changed");
        }
    }
}
