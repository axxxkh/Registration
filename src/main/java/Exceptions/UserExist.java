package Exceptions;

public class UserExist extends Exception{
    public UserExist() {
        super("User already exist");
    }
    public UserExist(String s) {
        super(s);
    }
}
