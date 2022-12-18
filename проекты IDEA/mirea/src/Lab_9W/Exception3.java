package Lab_9W;

import java.util.Scanner;

public class Exception3 {
    public void exceptionDemo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите чиселку");
        String intString = scanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
