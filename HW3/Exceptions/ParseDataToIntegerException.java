package Exceptions_HW.HW3.Exceptions;

public class ParseDataToIntegerException extends NumberFormatException{
    public ParseDataToIntegerException(String message) {
        super("не удалось привести к целочисленному типу: " + message);
    }
}
