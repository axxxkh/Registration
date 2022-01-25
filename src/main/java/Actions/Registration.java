package Actions;

import DataIO.User;
import DataIO.UserWriter;

import java.io.IOException;

public class Registration {
    public boolean registrate (User user) throws IOException {
        if (user.isExist()) {
            System.out.println("User with this login already exist");
            return false;
        }
        UserWriter writer = new UserWriter();
        writer.write(user);
        System.out.println("User successfully created");
        return false;
    }
}
