package Exceptions;

public class InvalidDataToRecover extends Exception{
    public InvalidDataToRecover() {
        super("Not enough data to change password. You should have at least 70% of valid information");
    }
}
