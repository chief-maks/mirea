package Lab_9;

import java.util.Scanner;

public class Exception2 {
    public void exceptionDemo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите чиселку");
        String intString = scanner.next();
        int i = Integer.parseInt(intString);
        System.out.println(2 / i);
    }
}
