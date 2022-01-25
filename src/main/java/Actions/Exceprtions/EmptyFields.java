package Actions.Exceprtions;

public class EmptyFields extends Exception{
    public EmptyFields() {
        super("You have fill all required fields");
    }
}
