package Actions;

import java.io.IOException;
/*
* In input file we look for two lines. First line is action to do:
* creating user, changing password, changing personal data or sending personal data.
* then we perform required action with json string of user data.
* */
public class PerformActions {
    public static void action(String act, String json) {
        String log = new String();
        Actions actions = Actions.valueOf(act);
        try {
            switch (actions) {
                case CREATE:
                    Create create = new Create();
                    create.create(json);
                    break;
                case CHANGEDATA:
                    ChangeData changeData = new ChangeData();
                    break;
                case CHANGEPWD:
                    ChangePassword changePassword = new ChangePassword();
                    break;
                case SENDDATA:
                    SendData sendData = new SendData();
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
