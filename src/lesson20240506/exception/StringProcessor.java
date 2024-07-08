package lesson20240506.exception;

import lesson20240506.exception.InputValidationException;

public class StringProcessor {
    public static String process (String string) throws InputValidationException {
        if(string == null) throw new InputValidationException("input string cannot be null");
        if(string.length() < 5) throw new InputValidationException("string lengths is too short");
        return "---" + string + "----";
    }
}
