package Lab_1516.order.manager;

import Lab_1516.menu.MenuItem;
import Lab_1516.order.Order;

public class TableOrderManager implements OrdersManager {       //класс менеджера ресторанных заказов
    private Order[] orders;                                     //массив заказов

    public TableOrderManager() {
        this(10);
    }   //конструкторы
    public TableOrderManager(int tableCount) { orders = new Order[tableCount]; }

    private void removeElementByIndex(int index) {          //метод удаления элемента по индексу
        Order[] temp = new Order[orders.length - 1];        //создание новго массива на -1 элемент
        System.arraycopy(orders, 0, temp, 0, index);        //копирование старого массива
        System.arraycopy(orders, index + 1, temp, index, orders.length - index - 1);     //удаление элемента по индексу
        orders = temp;                                      //присвоение нового массива
    }

    public void add(Order order, int tableNumber) {
        orders[tableNumber] = order;
    }   //метод добавление заказа к столику

    public void addItem(MenuItem item, int tableNumber)  {  //метод добавление позиции к заказу к столику
        orders[tableNumber].add(item);
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

    public Order getOrder(int tableNumber) {
        return orders[tableNumber];
    }   //метод получения заказа по номеру столика

    public void remove(int tableNumber)  {  //метод удаления заказа по номеру столика
        removeElementByIndex(tableNumber);
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

    @Override
    public int itemsQuantity(String itemName) {     //метод получение количества позиций
        int count = 0;                              //счётчик
        for (Order order : orders)                  //цикл по элементам массива
            count += order.itemQuantity(itemName);  //увеличение счётчика
        return count;                               //возврат счётчика
    }

    @Override
    public int itemsQuantity(MenuItem item) {       //метод получение количества позиций
        int count = 0;                              //счётчик
        for (Order order : orders)                  //цикл по элементам массива
            count += order.itemQuantity(item.getName());    //увеличение счётчика
        return count;                               //возврат счётчика
    }

    @Override
    public Order[] getOrders() {
        return orders;
    }   //метод получения массива заказов

    @Override
    public int ordersCostSummary() {        //метод вычисления стоимости всех заказов
        int count = 0;                      //счётчик
        for (Order order : orders)          //цикл по элементам массива
            count += order.costTotal();     //увеличение счётчика
        return count;                       //возврат счётчика
    }

    @Override
    public int ordersQuantity() {
        return orders.length;
    }   //метод вычисления количества заказов
}