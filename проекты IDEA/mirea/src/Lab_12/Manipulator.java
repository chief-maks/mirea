package Lab_12;

import java.util.Arrays;
import java.util.Scanner;

public class Manipulator {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);   //подключение сканера
        System.out.println("Write the text");       //вывод о необходимости ввода
        String text = scanner.nextLine();           //считывание строки с консоли
        System.out.println("Write the pattern");    //вывод о необходимости ввода
        String patter = scanner.nextLine();         //считывание строки с консоли
        text = Arrays.toString(text.split(patter)); //разделение строки
        System.out.println("Divided text:");        //вывод о разбиении
        System.out.println(text);                   //вывод разбитого текста
    }
}