package Actions;

import DataIO.LogWriter;
import DataIO.User;
import DataIO.UserReader;
import DataIO.UserWriter;
import Exceptions.EmptyFields;
import Exceptions.UserExist;
import Exceptions.WrongPassword;

import java.io.IOException;

public class ChangeData {
    public void changeData(User user) throws IOException {
//
//        try {
//            User userFromDB = UserReader.read(user.getLogin());
//            if (!user.isExist()) {
//                throw new UserExist();
//            }
//            if (!userFromDB.checkPassword(user)) {
//                throw new WrongPassword();
//            }
//            if (!user.checkRequiredFields(user)) {
//                throw new EmptyFields();
//            }
//            UserWriter.write(user);
//            LogWriter.writeLog("User " + user.getLogin() + " successfully created");
//        } catch (UserExist e) {
//            LogWriter.writeLog(e.toString());
//        } catch (EmptyFields e) {
//            LogWriter.writeLog(e.toString());
//        } catch (WrongPassword e) {
//            LogWriter.writeLog(e.toString());
//        }
    }
}
