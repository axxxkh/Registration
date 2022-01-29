package Actions;

import DataIO.LogWriter;
import DataIO.User;

import java.io.IOException;

/*
 * Depends on actions that listed in Actions enum, we start class that perform action
 * or write to log file information about wrong action */

public class PerformActions {
    public static void action(String act, User user) {
        String log;
        Actions actions = Actions.valueOf(act);
        try {
            switch (actions) {
                case CREATE:
                    Create create = new Create();
                    create.create(user);
                    break;
                case CHANGEDATA:
                    ChangeData changeData = new ChangeData();
                    changeData.changeData(user);
                    System.out.println("change data");
                    break;
                case CHANGEPWD:
                    ChangePassword changePassword = new ChangePassword();
                    changePassword.changePWD(user);
                    break;
                case SENDDATA:
                    SendData sendData = new SendData();
                    sendData.send(user);
                    break;
                default:
                    LogWriter.writeLog("Wrong action");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
