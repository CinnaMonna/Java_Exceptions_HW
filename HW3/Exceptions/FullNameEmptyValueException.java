package Exceptions_HW.HW3.Exceptions;

public class FullNameEmptyValueException extends RuntimeException{
    public FullNameEmptyValueException() {
        super("Есть пустые значения в введенных ФИО");
    }
    
}
