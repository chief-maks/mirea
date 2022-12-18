package Pr_14_15.order;

import Pr_14_15.menu.Item;

public interface Order {
    boolean add(Item item);             //метод добавление позиции в заказ
    boolean remove(String itemName);    //метод удаления позиции по названию
    int removeAll(String itemName);     //метод удаления всех элементов
    int itemsQuantity();                //метод подсчёта количества позиций в заказе
    Item[] getItems();                  //метод получения массива позиций
    double costTotal();                 //метод получения стоимости всех позиций заказа
    int itemQuantity(String itemName);  //цикл подсчёта количества позиции в заказе
    String[] itemsNames();              //метод получения массива строк позиций
    Item[] sortedItemsByCostDesc();     //метод получения отсортированного массива позиций
}