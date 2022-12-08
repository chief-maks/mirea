package Pr_9.First;

import java.math.BigInteger;

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