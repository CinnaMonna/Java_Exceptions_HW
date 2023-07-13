package Exceptions_HW.HW3.Exceptions;
import java.io.IOException;

public class FileCreateException extends IOException {
    public FileCreateException(String message) {
        super("Файл не был создан: " + message);
    }
}