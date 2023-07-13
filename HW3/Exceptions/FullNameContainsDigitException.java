package Exceptions_HW.HW3.Exceptions;

public class FullNameContainsDigitException extends RuntimeException{
    public FullNameContainsDigitException() {
        super("Есть числовые символы в веденных ФИО");
    }
}