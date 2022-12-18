package Lab_1516.exceptions;

public class IllegalAddressException extends Exception {
    public IllegalAddressException() {
        super("Некорректный адрес!");
    }
}