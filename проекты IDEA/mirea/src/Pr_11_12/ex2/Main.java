package Pr_11_12.ex2;

public class Main {
    public static void main(String[] arg) {                                                             //основной алгоритм программы
        Address a1 = new Address("Российская Федерация, ГФЗ Москва, " +
                "город Москва, улица Кунцевская, дом 1, отсутствует , квартира 39", true);              //создание объекта класса Address
        System.out.println(a1);                                                                         //вывод на экран значения метода toString объекта a1
        Address a2 = new Address("Российская Федерация , ГФЗ Москва; " +
                "город Москва   . улица Кунцевская; дом 1    , отсутствует . квартира 39", false);      //создание объекта класса Address
        System.out.println(a2);                                                                         //вывод на экран значения метода toString объекта a2
//        Address a3 = new Address("", true);   //ошибка
//        System.out.println(a3);
        Address a4 = new Address(" , , , , , , ,", true);   //создание объекта класса Address
        System.out.println(a4);                             //вывод на экран значения метода toString объекта a4
    }
}
