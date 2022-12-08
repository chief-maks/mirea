package Lab_8;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void exOne() {
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

    public static void exTwo() {
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

    public static void exThree() {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        FileWriter open = null;
        try {
            open = new FileWriter("D:\\lab8.txt", false);
            open.append(text);
            open.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exFour() {
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