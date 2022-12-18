package Lab_10;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static <T> ArrayList<T> converter(T[] arr) {  //метод конвертации массива в список
        if (arr.length == 0)                             //проверка на наличие элементов в массиве
            throw new IllegalArgumentException("Length of array is null");  //выбрасывание исключения
        ArrayList<T> list = new ArrayList<>(arr.length);    //создание списка
        list.addAll(Arrays.asList(arr));                    //добавление всех элементов в список
        return list;                                        //возврат списка
    }

    public static <E> E get(E[] arr, int index) {   //метод получения элемента массива по индексу
        if (index < 0 || index > arr.length)        //проверка индекса
            /* Выбрасывание исключения */
            throw new IndexOutOfBoundsException("Array size = "+ arr.length + ", index = " + index);
        return arr[index];          //возвра элемента по индексу
    }

    public static ArrayList<File> readDirectory(String path) {      //метод хранения содержимого каталога
        File file = new File(path);                                 //открытие файла
        if (!file.exists() || !file.isDirectory())                  //проверка
            throw new IllegalArgumentException();                   //выбрасывание исключения
        ArrayList<File> fileArrayList = new ArrayList<>();          //создание списка для хранения
        Collections.addAll(fileArrayList, file.listFiles());        //добавление списка файлов каталога в массив
        try {                                                       //блок пробирования
            for (int i = 0; i < 5; i++)                             //цикл по списку
                System.out.println(fileArrayList.get(i).getName()); //вывод названия элемента каталога
        } catch (Exception e) {                                     //отлавливание исключения
            System.out.println("Less that 5 elements!");            //вывод об отсутсвии 5-ти элементов
        }
        return fileArrayList;                                       //возврат списка элементов
    }

    public static void main(String[] arg) {
        //Ex1
        Integer[] arr1 = new Integer[]{1, 2, 3};
        String[] arr2 = new String[]{"Hello", "world", "!", "!", "!"};
        ArrayList<String> arr3 = converter(arr2);
        System.out.println(arr3);


        System.out.println(get(arr1, 0));
//        System.out.println(get(arr1, 10));    //Ошибка индекса

        ArrayList<File> fileArrayList = readDirectory(Paths.get("").toAbsolutePath().toString());
        System.out.println(fileArrayList);

        //Ex2
        GenericArrayList<Integer> arr4 = new GenericArrayList<>(6);
        arr4.set(0, 4);
        arr4.set(3, 9);
        arr4.add(6);
        arr4.add(8);
        arr4.add(2);
        arr4.add(1);
        System.out.println(arr4);
        arr4.sort(Integer::compareTo);
        arr4.remove(3);
        System.out.println(arr4);
        System.out.println(arr4.subList(1, 5));
        System.out.println(arr4.contains(2));
        System.out.println();

        Integer[] list = new Integer[]{1, 4, 3, 8, 2};
        GenericArrayList<Integer> arr5 = new GenericArrayList<>(list);
        System.out.println(arr5);
        System.out.println(arr5.indexOf(8));
        System.out.println(arr5.get(4));
        System.out.println(arr5.containsAll(converter(new Integer[]{1, 2, 8})));
        arr5.clear();
        System.out.println(arr5);
    }
}
