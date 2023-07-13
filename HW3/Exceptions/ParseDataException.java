package Exceptions_HW.HW3.Exceptions;

public class ParseDataException extends RuntimeException{
    public ParseDataException(String message) {
        super("Не удалось распознать данные: " + message);
    }
}