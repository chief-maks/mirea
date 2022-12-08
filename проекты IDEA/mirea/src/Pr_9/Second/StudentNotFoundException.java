package Pr_9.Second;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException() {
        super("Student not found!");
    }
}