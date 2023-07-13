package Exceptions_HW.HW3.Exceptions;

public class FullNameReadFromDataException extends IndexOutOfBoundsException{
    public FullNameReadFromDataException(String message) {
        super("Не удалось распознать ФИО: " + message);
    }
}
