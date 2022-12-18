package Pr_9W.First;

public class invalidINNException extends Exception {
    private Long number;

    public invalidINNException(Long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ИНН с номером: " + number + " не действителен!";
    }
}