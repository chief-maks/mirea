package Lab_1516.order.manager;

import Lab_1516.menu.MenuItem;
import Lab_1516.order.Order;

public class InternetOrderManager implements OrdersManager {    //класс менеджера интернет-заказов
    private QueueNode head;     //начальный элемент списка
    private QueueNode tail;     //конечный элемент списка
    private int size;           //поле длины списка

    public InternetOrderManager() { //конструктор
        head = new QueueNode();     //присвоение полям значений
        tail = new QueueNode();
        head.next = tail;
        size = 0;
    }

    public boolean add(Order order) {       //метод добавления заказа
        if (head.value == null) {           //проверка на существование первого элемента
            head.value = order;             //добавление заказа
            size++;                         //инкрементация длины
            return true;                    //возврат логической единицы
        }
        if (tail.value == null) {           //проверка на существование последнего элемента
            tail.value = order;             //добавление заказа
            size++;                         //инкрементация длины
            return true;                    //возврат логической единицы
        }
        tail.next = new QueueNode(order);   //создание нового узла с позицией
        tail = tail.next;                   //добавление узла в конец
        size++;                             //инкрементация длины
        return true;                        //возврат логической единицы
    }

    public Order remove() {         //метод удаления послднего элемента списка
        QueueNode go = head;        //переменная для обхода списка
        while (true) {              //цикл обхода
            if (go.next == null) {  //условие на конец списка
                go.prev = null;     //зануление предыдущего элемента
                break;              //выход из цикла
            }
        }
        return go.value;            //возврат значения последнего узла списка
    }

    public Order order() { return tail.value; } //метод, возвращающий последний заказ

    @Override
    public int itemsQuantity(String itemName) {             //метод подсчёта количества позиций в заказе
        int counter = 0;                                    //счётчик
        QueueNode go = head;                                //переменаня для обхода
        while (go != null) {                                //цикл обхода
            counter += go.value.itemQuantity(itemName);     //увеличение счётчика
            go = go.next;                                   //продолжение обхода
        }
        return counter;                                     //возврат значения счётчика
    }

    @Override
    public int itemsQuantity(MenuItem item) {               //метод подсчёта количества позиции в заказе
        int counter = 0;                                    //счётчик
        QueueNode go = head;                                //переменаня для обхода
        while (go != null) {                                //цикл обхода
            counter += go.value.itemQuantity(item.getName());   //увеличение счётчика
            go = go.next;                                   //продолжение обхода
        }
        return counter;                                     //возврат значения счётчика
    }

    @Override
    public Order[] getOrders() {            //метод получения массива заказов
        Order[] orders = new Order[size];   //создание нового массива
        QueueNode go = head;                //переменаня для обхода
        for (int i = 0; i < size; i++) {    //цикл обхода
            orders[i] = head.value;         //добавление в массив
            go = go.next;                   //продолжение обхода
        }
        return orders;                      //возврат массива
    }

    @Override
    public int ordersCostSummary() {        //метод вычисления стоимости всех заказов
        double cost = 0;                    //счётчик
        QueueNode go = head;                //переменаня для обхода
        while (go != null) {                //цикл обхода
            cost += go.value.costTotal();   //увеличение счётчика
            go = go.next;                   //продолжение обхода
        }
        return (int) cost;                  //возврат значения счётчика
    }

    @Override
    public int ordersQuantity() {           //метод вычисления количества заказов
        int counter = 0;                    //счётчик
        QueueNode go = head;                //переменаня для обхода
        while (go != null) {                //цикл обхода
            counter++;                      //инкрементация счётчика
            go = go.next;                   //продолжение обхода
        }
        return counter;                     //возврат значения счётчика
    }
}