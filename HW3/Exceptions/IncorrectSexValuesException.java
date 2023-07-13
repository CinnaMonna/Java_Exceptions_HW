package Exceptions_HW.HW3.Exceptions;

public class IncorrectSexValuesException extends RuntimeException{
    public IncorrectSexValuesException() {
        super("Пол - указано неверное значение");
    }
}