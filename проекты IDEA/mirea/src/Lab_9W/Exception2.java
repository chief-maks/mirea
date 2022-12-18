package Lab_9W;

import java.util.Scanner;

public class Exception2 {
    public void exceptionDemo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число");
        String intString = scanner.next();
        int i = Integer.parseInt(intString);
        System.out.println(2 / i);
    }
}
