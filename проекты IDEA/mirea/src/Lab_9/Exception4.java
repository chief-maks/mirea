package Lab_9;

import java.util.Scanner;

public class Exception4 {
    public void exceptionDemo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите чиселку");
        String intString = scanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        }
        catch (Exception e){
            System.out.println("Что-то пошло не так");
        }
        finally {
            System.out.println("Конец игры");
        }
    }
}
