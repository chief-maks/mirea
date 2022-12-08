package Pr_9.Second;

public class EmptyStringException extends IllegalArgumentException {
    public EmptyStringException() {
        super("Empty string!");
    }
}