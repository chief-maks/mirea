package Lab_8W;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void exOne() {   // дозаписываем
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        FileWriter open = null;
        try {
            open = new FileWriter("D:\\lab8.txt", true);
            open.append(text);
            open.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exTwo() {    // вывод из файла
        FileReader open = null;
        try {
            open = new FileReader("D:\\lab8.txt");
            int c;
            while ((c = open.read()) != -1)
                System.out.println((char) c);
            open.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exThree() {     // перезаписываем
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        FileWriter open = null;
        try {
            open = new FileWriter("D:\\lab8.txt");   // по умолчанию append - false(можно не указывать)
            open.append(text);
            open.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exFour() {            // дозаписываем
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        FileWriter open = null;
        try {
            open = new FileWriter("D:\\lab8.txt", true);
            open.append(text);
            open.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] arg) {
        exOne();
        exTwo();
        exThree();
        exFour();
    }
}