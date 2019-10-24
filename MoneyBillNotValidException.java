package rs.itcentar;

public class MoneyBillNotValidException extends Exception {
    private Novcanica novcanica;

    public MoneyBillNotValidException(Novcanica novcanica, String message) {
        super(message);
        this.novcanica = novcanica;
    }

    public MoneyBillNotValidException(Novcanica novcanica, String message, Throwable cause) {
        super(message, cause);
        this.novcanica = novcanica;
    }

    public Novcanica getNovcanica() {
        return novcanica;
    }
}
