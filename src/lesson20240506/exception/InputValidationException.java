package lesson20240506.exception;

public class InputValidationException extends Exception {


    public InputValidationException() {
    }

    public InputValidationException(String message){
        super (message);
    }
}
