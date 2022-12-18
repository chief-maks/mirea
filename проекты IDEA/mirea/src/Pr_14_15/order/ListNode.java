package Pr_14_15.order;

import Pr_14_15.menu.Item;

public class ListNode {     //узел списка
    ListNode next;          //указатель на следующий узел
    Item value;             //значение узла

    public ListNode() {
        this(null);
    }               //конструкторы
    public ListNode(Item value) {
        this.value = value;
    }
}