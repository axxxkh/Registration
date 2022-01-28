package Actions;

import DataIO.User;

import java.io.IOException;

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
                    break;
                case CHANGEPWD:
                    ChangePassword changePassword = new ChangePassword();
                    changePassword.changePWD(user);
                    break;
                case SENDDATA:
                    SendData sendData = new SendData();
                    sendData.send(user);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
