package Exceptions_HW.HW3.Exceptions;

public class CheckSexException extends RuntimeException{
    public CheckSexException() {
        super("Значение 'пол' - пустое");
    }
}
