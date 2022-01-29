package Actions;

import DataIO.LogWriter;
import DataIO.User;
import DataIO.UserReader;
import Exceptions.UserExist;
import java.io.FileWriter;
import java.io.IOException;

/*
* sendin data about user to output folder to .txt file wih user name
* */

public class SendData {
    public void send(User user) throws IOException {
        User userFromDB = UserReader.read(user.getLogin());
        try {
            if (!user.isExist()) {
                throw new UserExist("No such user at database");
            }
            if (userFromDB.checkPassword(user)) {
                FileWriter fileWriter = new FileWriter("src/main/java/output/" + user.getLogin() + ".txt");
                fileWriter.write(userFromDB.toString());
                fileWriter.flush();
                LogWriter.writeLog("All personal data about " + user.getLogin()
                        + " successfully has been written to file /output/" + user.getLogin() + ".txt");
                fileWriter.close();
            }
        } catch (UserExist e) {
            LogWriter.writeLog(e + " no data saved");
        }
    }
}
