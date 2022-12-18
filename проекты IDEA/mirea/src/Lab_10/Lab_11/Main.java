package Lab_10.Lab_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] arg) {
        Solution solution = new Solution();                         //создание объекта класса Solution
        String[] arr = new String[]{"Hello", "world", "!"};         //создание массива строк
        ArrayList<String> arrayList = solution.newArrayList(arr);   //инициализация списка типа ArrayList значением метода newArrayList
        System.out.println(arrayList);                              //вывод списка
        HashSet<String> hashSet = solution.newHashSet(arr);         //инициализация списка типа HashSet значением метода newHashSet
        System.out.println(hashSet);                                //вывод списка
        HashMap<String, String> hashMap = solution.newHashMap(arr, new String[]{"H", "w", "!"});    //инициализация списка типа HashMap значением метода newHashMap
        System.out.println(hashMap);                                //вывод списка
    }
}
