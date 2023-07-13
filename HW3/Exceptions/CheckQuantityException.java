package Exceptions_HW.HW3.Exceptions;

public class CheckQuantityException extends RuntimeException {
    public CheckQuantityException() {
        super("Количество введенных данных не соответствует запросу");
    } 
    
}
