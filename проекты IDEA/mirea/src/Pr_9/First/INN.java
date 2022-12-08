package Pr_9.First;

import java.math.BigInteger;
import java.util.Scanner;

public class INN {
    public static void checkINN(Long number) throws invalidINNException {
        Long check = number;
        int count = 0;
        while (check != 0) {
            check /= 10;
            count++;
        }
        if (count != 10) throw new invalidINNException(number);
    }

    public static void doINN() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String FIO = in.nextLine();
        System.out.println("Введите ИНН: ");
        try {
            Long INN = in.nextLong();
            checkINN(INN);
            System.out.println("Добро пожаловать!");
        } catch (invalidINNException e) {
            System.out.println(e);
        }
    }
}
