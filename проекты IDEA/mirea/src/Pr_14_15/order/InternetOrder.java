package Pr_14_15.order;

import Pr_14_15.menu.Item;

public class InternetOrder implements Order {   //класс интернет заказа
    private ListNode head;                      //начальный элемент списка
    private ListNode tail;                      //конечный элемент списка

    public InternetOrder() {        //конструктор
        head = new ListNode();      //присвоение полям значений
        tail = new ListNode();
        head.next = tail;
    }
    public InternetOrder(Item[] items) {        //перегруженный конструктор
        if (items.length == 0) return;          //проверка длины вводимого массива
        for (int i = 0; i < items.length; i++)  //цикл по массиву
            add(items[i]);                      //добавление элементов
    }

    @Override
    public boolean add(Item item) {         //метод добавление позиции в заказ
        if (head.value == null) {           //проверка на существование первого элемента
            head.value = item;              //добавление позиции
            return true;                    //возврат логической единицы
        }
        if (tail.value == null) {           //проверка на существование последнего элемента
            tail.value = item;              //добавление позиции
            return true;                    //возврат логической единицы
        }
        tail.next = new ListNode(item);     //создание нового узла с позицией
        tail = tail.next;                   //добавление узла в конец
        return true;                        //возврат логической единицы
    }

    @Override
    public boolean remove(String itemName) {            //метод удаления позиции по названию
        ListNode go = head;         //переменные для обхода списка
        ListNode prevGo = null;

        while (go != null) {                            //цикл по заказку
            if (go.value.getName().equals(itemName)) {  //сравнение элементов
                if (prevGo != null)             //переадресация указателей
                    prevGo.next = head.next;
                if (head == tail)
                    tail = prevGo;
                head = head.next;
                return true;                    //возврат логической единицы
            }
            prevGo = go;    //продолжение обхода
            go = go.next;
        }

        return false;       //возврат логического нуля
    }

    @Override
    public int removeAll(String itemName) { //метод удаления всех элементов
        int counter = 0;                    //счётчик
        while (!remove(itemName))           //цикл удаления
            counter++;                      //инкрементация счётчика
        return counter;                     //возврат значения счётчика
    }

    @Override
    public int itemsQuantity() {    //метод подсчёта количества позиций в заказе
        int counter = 0;            //счётчик
        ListNode go = head;         //переменаня для обхода
        while (go != null) {        //цикл обхода
            counter++;              //инкрементация счётчика
            go = go.next;           //продолжение обхода
        }
        return counter;             //возврат значения счётчика
    }

    @Override
    public int itemQuantity(String itemName) {  //цикл подсчёта количества позиции в заказе
        int counter = 0;                        //счётчик
        ListNode go = head;                     //переменаня для обхода
        while (go != null) {                    //цикл обхода
            if (go.value.getName().equals(itemName)) counter++; //сравнение элементов
            go = go.next;                       //продолжение обхода
        }
        return counter;                         //возврат значения счётчика
    }

    @Override
    public Item[] getItems() {                  //метод получения массива позиций
        Item[] items = new Item[0];             //создание нового массива
        ListNode go = head;                     //переменаня для обхода
        while (go != null) {                    //цикл обхода
            boolean isFound = false;            //переменная-флаг наличия
            for (Item menuItem : items) {       //цикл по массиву
                if (menuItem.equals(go.value)) {    //сравнение элементов
                    isFound = true;                 //подъятие флага
                    break;                          //выход из цикла
                }
            }

            if (!isFound) {                     //проверка флага
                Item[] temp = new Item[items.length + 1];           //создание временного массива
                System.arraycopy(items, 0, temp, 0, items.length);  //копирование элементов массива
                temp[temp.length - 1] = go.value;                   //добавление элемента
                items = temp;                                       //присвоение массива
            }

            go = go.next;                       //продолжение обхода
        }
        return items;                           //возврат массива
    }

    @Override
    public double costTotal() {         //метод получения стоимости всех позиций заказа
        double cost = 0;                //счётчик
        ListNode go = head;             //переменаня для обхода
        while (go != null) {            //цикл обхода
            cost += go.value.getCost(); //увеличение счётчика стоимости
            go = go.next;               //продолжение обхода
        }
        return cost;                    //возврат значения счётчика
    }

    @Override
    public String[] itemsNames() {                  //метод получения массива строк позиций
        String[] items = new String[0];             //создание нового массива строк
        ListNode go = head;                         //переменаня для обхода
        while (go != null) {                        //цикл обхода
            boolean isFound = false;                //переменная-флаг наличия
            for (String menuItem : items) {         //цикл по массиву
                if (menuItem.equals(go.value)) {    //сравнение элементов
                    isFound = true;                 //подъятие флага
                    break;                          //выход из цикла
                }
            }

            if (!isFound) {                                         //проверка флага
                String[] temp = new String[items.length + 1];       //создание временного массива
                System.arraycopy(items, 0, temp, 0, items.length);  //копирование элементов массива
                temp[temp.length - 1] = go.value.getName();         //добавление элемента
                items = temp;                                       //присвоение массива
            }

            go = go.next;                           //продолжение обхода
        }
        return items;                               //возврат массива
    }

    @Override
    public Item[] sortedItemsByCostDesc() {         //метод получения отсортированного массива позиций
        Item[] items = getItems();                  //массив позиций
        for (int i = 0; i < items.length; i++) {    //сортировка вставками
            Item st = items[i];
            int j = i - 1;
            for (; (j >= 0) && (st.getCost() - items[j].getCost() < 0); j--)
                items[j + 1] = items[j];
            items[j + 1] = st;
        }
        return items;                               //возврат массива
    }
}