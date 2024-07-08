package summary20240510;

public class WrongLoginException extends Exception{

    public WrongLoginException() {
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
