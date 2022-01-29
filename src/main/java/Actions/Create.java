package Actions;

import DataIO.LogWriter;
import DataIO.User;
import DataIO.UserWriter;
import Exceptions.EmptyFields;
import Exceptions.UserExist;

import java.io.IOException;

/*
 * try to create user, if he exists throw UserExist Exception,
 * in another way checking all necessary fields to add user to database (login,
 * password, email and date of birth.
 */

public class Create {
    public void create(User user) throws IOException {

        try {
            if (user.isExist()) {
                throw new UserExist();
            }
            if (!user.checkRequiredFields(user)) {
                throw new EmptyFields();
            }
            UserWriter.write(user);
            LogWriter.writeLog("User " + user.getLogin() + " successfully created");
        } catch (UserExist e) {
            LogWriter.writeLog(e + " user " + user.getLogin() + " wasn't add to the base");
            System.out.println(e);
        } catch (EmptyFields e) {
            LogWriter.writeLog(e.toString());
            System.out.println(e + " user " + user.getLogin() + " wasn't add to the base");
        }
    }
}
