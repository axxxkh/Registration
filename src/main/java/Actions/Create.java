package Actions;

import Actions.Exceprtions.EmptyFields;
import Actions.Exceprtions.UserExist;
import DataIO.LogWriter;
import DataIO.User;
import DataIO.UserWriter;

import java.io.IOException;

/*
* try to create user, if he exists throw UserExist Exception,
* in another way checking all necessary fields to add user to database (login,
* password, email and date of birth.
*/

public class Create {
    public boolean create(String json) throws IOException {
        User user = null;

        try {
            user = new User();
            user.create(json);
            UserWriter writer = new UserWriter();
            writer.write(user);
            LogWriter.writeLog("User " + user.getLogin() + " successfully created");
            if (!user.checkRequiredFields(user)) {
                throw new EmptyFields();
            }
        } catch (UserExist e) {
            LogWriter.writeLog(e.toString());
            // Check all required fields
        } catch (EmptyFields e) {
            LogWriter.writeLog(e.toString());
        }
        return true;
    }
}
