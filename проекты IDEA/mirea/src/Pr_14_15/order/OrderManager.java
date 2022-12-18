package Pr_14_15.order;

import Pr_14_15.exceptions.IllegalTableNumber;
import Pr_14_15.exceptions.OrderAlreadyAddedException;
import Pr_14_15.menu.Item;

import java.util.HashMap;

public class OrderManager {
    private Order[] orders;                 //заказы в ресторане
    private HashMap<String, Order> pairs;   //интернет-заказы

    public OrderManager() {
        this(10);
    }   //конструкторы
    public OrderManager(int tableCount) {
        orders = new Order[tableCount];
        pairs = new HashMap<>();
    }

    private void removeElementByIndex(int index) {          //метод удаления элемента по индексу
        Order[] temp = new Order[orders.length - 1];        //создание новго массива на -1 элемент
        System.arraycopy(orders, 0, temp, 0, index);        //копирование старого массива
        System.arraycopy(orders, index + 1, temp, index, orders.length - index - 1);     //удаление элемента по индексу
        orders = temp;                                      //присвоение нового массива
    }


    /* Метод добавления заказа к столику */
    public void add(Order order, int tableNumber) throws OrderAlreadyAddedException, IllegalTableNumber {
        if (orders[tableNumber] != null) throw new OrderAlreadyAddedException();    //выбрасывание исключений
        if (tableNumber > orders.length - 1) throw new IllegalTableNumber();
        orders[tableNumber] = order;    //метод добавления заказа к столику
    }

    /* Метод добавления позиции к заказу к столику */
    public void addItem(Item item, int tableNumber) throws OrderAlreadyAddedException, IllegalTableNumber {
        if (orders[tableNumber] == null) throw new OrderAlreadyAddedException();    //выбрасывание исключений
        if (tableNumber > orders.length - 1) throw new IllegalTableNumber();
        orders[tableNumber].add(item);  //метод добавления позиции к заказу
    }

    public int freeTableNumber() {              //метод получения свободного столика
        for (int i = 0; i < orders.length; i++) //цикл по столикам
            if (orders[i] == null) return i;    //проверка наличия заказов, возврат номера столика
        return 0;                               //возврат нуля
    }

    public int[] freeTableNumbers() {                               //метод получения количества свободных столиков
        int[] nums = new int[0];                                    //новый массив
        for (int i = 0; i < orders.length; i++) {                   //цикл по столикам
            if (orders[i] == null) {                                //проверка на отсутсвие заказа
                int[] temp = new int[nums.length + 1];              //временный массив
                System.arraycopy(nums, 0, temp, 0, nums.length);    //копирование во временный массив
                temp[temp.length - 1] = i;                          //добавление номера столика
                nums = temp;                                        //присвоение временного массива
            }
        }
        return nums;                                                //возврат массива номеров столиков
    }

    public Order getOrder(int tableNumber) throws IllegalTableNumber {      //метод получения заказа по номеру столика
        if (tableNumber > orders.length - 1) throw new IllegalTableNumber();//выбрасывание исключения
        return orders[tableNumber];                     //возврат заказа
    }

    public void remove(int tableNumber) throws IllegalTableNumber {         //метод удаления заказа по номеру столика
        if (tableNumber > orders.length - 1) throw new IllegalTableNumber();//выбрасывание исключения
        removeElementByIndex(tableNumber);              //удаление элемента по индексу
    }

    public boolean remove(Order order) {            //метод удаления заказа
        for (int i = 0; i < orders.length; i++) {   //цикл по заказам
            if (orders[i].equals(order)) {          //сравнение заказов
                removeElementByIndex(i);            //удаление элемента по индексу
                return true;                        //возврат логической единицы
            }
        }
        return false;                               //возврат логического нуля
    }

    public int removeAll(Order order) {     //метод удаления одинаковых заказов
        int count = 0;                      //счётчик заказов
        while (remove(order))               //цикл удаления
            count++;                        //инкрементация счётчика
        return count;                       //возврат количества
    }


    //Методы для интернет-заказов
    public void add(String address, Order order) throws OrderAlreadyAddedException {    //метод добавления заказа по адресу
        if (pairs.get(address) != null) throw new OrderAlreadyAddedException();         //выбрасывание исключения
        pairs.put(address, order);                          //добавление заказа и адреса
    }

    public Order getOrder(String address) {     //метод получения заказа по адресу
        return pairs.get(address);              //возврат заказа
    }

    public boolean remove(String address) {     //метод удалению заказа по адресу
        return pairs.remove(address) != null;   //удаление ненулевого элемента
    }

    public void addItem(String address, Item item) throws OrderAlreadyAddedException {  //метод добавление позиции к заказу
        if (pairs.get(address) == null) throw new OrderAlreadyAddedException();         //выбрасывание исключения
        pairs.get(address).add(item);           //добавление позиции к заказу
    }

    public Order[] getOrders() {                    //метод получения массива заказов
        Order[] orders = new Order[pairs.size()];   //новый массив
        int i = 0;                                  //счётчик
        for (Order order : pairs.values())          //цикл по заказам
            orders[i++] = order;                    //добавление в массив
        return orders;                              //возврат массива
    }

    public double costTotal() {             //метод получения общей стоимости
        double cost = 0;                    //счётчик стоимости
        for (Order order : pairs.values())  //цикл по заказам
            cost += order.costTotal();      //добавление стоимости заказа
        return cost;                        //возврат стоимости
    }

    public int getDish(String dishName) {               //метод получения количества позиций во всех заказах
        int counter = 0;                                //счётчик вхождений
        for (Order order : pairs.values())              //цикл по заказам
            counter += order.itemQuantity(dishName);    //добавление количества блюд в заказе
        return counter;                                 //возврат счётчика
    }
}