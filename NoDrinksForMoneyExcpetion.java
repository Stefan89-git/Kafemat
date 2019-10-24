package rs.itcentar;

public class NoDrinksForMoneyExcpetion extends Exception {

    public NoDrinksForMoneyExcpetion(String message) {
        super(message);
    }

    public NoDrinksForMoneyExcpetion(String message, Throwable cause) {
        super(message, cause);
    }
}
