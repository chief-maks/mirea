package Lab_1516.order;

import Lab_1516.menu.MenuItem;

public class ListNode {     //узел списка
    ListNode next;          //указатель на следующий узел
    MenuItem value;         //значение узла

    public ListNode() {
        this(null);
    }                   //конструкторы
    public ListNode(MenuItem value) {
        this.value = value;
    }
}