package Lab_10.Lab_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {                             //класс решений

    public <T> ArrayList<T> newArrayList (T[] arr) {    //метод создания нового списка типа ArrayList
        if (arr.length == 0)                            //проверка длины массива
            throw new IllegalArgumentException("Length of array is null");  //выбрасывание исключения
        ArrayList<T> list = new ArrayList<>(arr.length);//создание нового списка
        list.addAll(Arrays.asList(arr));                //копирование элементов
        return list;                                    //возврат списка
    }

    public <T> HashSet<T> newHashSet(T[] arr) {         //метод создания нового списка типа HashSet
        if (arr.length == 0)                            //проверка длины массива
            throw new IllegalArgumentException("Length of array is null");  //выбрасывание исключения
        HashSet<T> list = new HashSet<>(arr.length);    //создание нового списка
        list.addAll(Arrays.asList(arr));                //копирование элементов
        return list;                                    //возврат списка
    }

    public <K, V> HashMap<K, V> newHashMap(K[] arr1, V[] arr2) {    //метод создания нового списка типа HashMap
        if (arr1.length == 0 || arr2.length == 0)                   //проверка длин массивов
            throw new IllegalArgumentException("Length of array is null");  //выбрасывание исключения
        if (arr1.length != arr2.length)                             //проверка равенства длин массивов
            throw new IllegalArgumentException("Lengths of arrays aren't equal");   //выбрасывание исключения
        HashMap<K, V> list = new HashMap<>();   //создание нового списка
        for (int i = 0; i < arr1.length; i++)   //цикл по элементам одного массива
            list.put(arr1[i], arr2[i]);         //добавление элементов в список
        return list;                            //возврат списка
    }
}