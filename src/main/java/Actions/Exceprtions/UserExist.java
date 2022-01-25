package Actions.Exceprtions;

public class UserExist extends Exception{
    public UserExist() {
        super("User already exist");
    }
}
