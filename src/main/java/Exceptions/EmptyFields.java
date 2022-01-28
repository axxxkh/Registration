package Exceptions;

public class EmptyFields extends Exception{
    public EmptyFields() {
        super("You haven't fill all required fields");
    }
}
