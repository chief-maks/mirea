package Pr_11_12.ex5;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static String getLine(String str) {      //метод перестановки по условию
        String[] sstrings = str.split(" ");         //разбиение текста
        ArrayList<String> strings = new ArrayList<>(sstrings.length);   //создание списка типа ArrayList
        Collections.addAll(strings, sstrings);              //добавление всех элементов в список
        StringBuilder stringBuilder = new StringBuilder();  //создание объекта класса StringBuilder

        stringBuilder.append(strings.get(0)).append(" ");   //добавление первого элемента списка
        for (int i = 0; i < strings.size() - 1; i++) {      //цикл по элементам списка
            String sI = strings.get(i);                     //получение элемента списка
            for (int j = i + 1; j < strings.size() - 1; j++) {  //цикл по оставшимся элементам списка
                String sJ = strings.get(j);                     //получение элемента списка
                if ( sI.substring(sI.length() - 1)
                        .equalsIgnoreCase(sJ.substring(0, 1)) ) {   //проверка на равенство символов
                    stringBuilder.append(sJ).append(" ");       //добавление элемента в строку
                    strings.set(j, strings.get(i + 1));         //обмен местами с подходящим словом
                    strings.set(i + 1, sJ);
                    break;                                      //конец внутреннего цикла
                }
            }
        }
        return stringBuilder.toString();    //возврат значения метода toString объекта stringBuilder
    }

    public static void main(String[] args) {        //основной алгоритм программы
        Scanner in = new Scanner(System.in);        //создание сканера
        String path = in.nextLine();                //считывание строки - пути к файлу
        StringBuilder stringBuilder = new StringBuilder();  //создание объекта класса StringBuilder
        try {                                               //блок, в котором может быть вызвано исключение
            FileReader fileReader = new FileReader(path);   //открытие файла объектом класса FileReader
            int c;                                          //переменная для чтения
            while ( (c = fileReader.read()) != -1)          //цикл считывания
                stringBuilder.append( (char) c);            //добавление символа в строку
        } catch (IOException e) {                           //отлавливание исключения класса IOException
            System.out.println(e.getMessage());                            //вывод исключения
        }
        System.out.println(getLine(stringBuilder.toString()));  //вывод значения метода getLine
    }
}
