package Pr_9W.Second;

public class EmptyStringException extends IllegalArgumentException {
    public EmptyStringException() {
        super("Empty string!");
    }
}