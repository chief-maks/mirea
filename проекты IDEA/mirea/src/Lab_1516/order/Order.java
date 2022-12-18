package Lab_1516.order;

import Lab_1516.menu.MenuItem;

public interface Order {
    boolean add(MenuItem item);         //метод добавление позиции в заказ
    boolean remove(String itemName);    //метод удаления позиции по названию
    int removeAll(String itemName);     //метод удаления всех элементов
    int itemsQuantity();                //метод подсчёта количества позиций в заказе
    MenuItem[] getItems();              //метод получения массива позиций
    double costTotal();                 //метод получения стоимости всех позиций заказа
    int itemQuantity(String itemName);  //цикл подсчёта количества позиции в заказе
    String[] itemsNames();              //метод получения массива строк позиций
    MenuItem[] sortedItemsByCostDesc(); //метод получения отсортированного массива позиций
}