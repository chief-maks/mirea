package Pr_14_15;

import Pr_14_15.menu.Dish;
import Pr_14_15.menu.Drink;
import Pr_14_15.menu.Item;
import Pr_14_15.exceptions.IllegalTableNumber;
import Pr_14_15.exceptions.OrderAlreadyAddedException;
import Pr_14_15.order.Order;
import Pr_14_15.order.OrderManager;
import Pr_14_15.order.RestaurantOrder;
import Pr_14_15.order.InternetOrder;

public class Main {
    public static void main(String[] args) {
        Order order1 = new RestaurantOrder();
        order1.add(new Dish("Цезарь", "Вкусный салат", 360));
        order1.add(new Drink("Пряный чай Латте", "Пряный чай", 210));
        order1.add(new Dish("Цезарь", "Вкусный салат", 360));
        order1.add(new Dish("Цезарь", "Вкусный салат", 360));
        System.out.println(order1.costTotal());
        System.out.println(order1.itemQuantity("Цезарь"));
        System.out.println(order1.remove("Цезарь"));
        System.out.println(order1.itemsQuantity());
        for (String s: order1.itemsNames())
            System.out.println(s);
        order1.add(new Dish("Цезарь", "Вкусный салат", 360));
        System.out.println(order1.removeAll("Цезарь"));
        for (Item item : order1.sortedItemsByCostDesc())
            System.out.println(item.getName());

        //Интернет-заказ
        Order order2 = new InternetOrder();
        order2.add(new Drink("Вода", "Газированная вода", 60));
        order2.add(new Dish("Котлета по-киевски", "Киевская коктлета", 600));
        order2.add(new Dish("Цезарь", "Вкусный салат", 360));
        order2.add(new Drink("Чай", "Чёрный чай", 35));

        OrderManager orderManager = new OrderManager();
        try {
            orderManager.add("Кунцевская 1", order2);
            //orderManager.add(order1, 12);   //ошибка номера столика
            orderManager.add(order1, 3);
            //orderManager.add("Кунцевская 1", order2);   //ошибка о наличии заказа
        } catch (OrderAlreadyAddedException e) {
            System.out.println("Заказ уже добавлен!");
        } catch (IllegalTableNumber e) {
            System.out.println("Неправильный адрес!");;
        }

        System.out.println(orderManager.costTotal());

        for (int i : orderManager.freeTableNumbers())
            System.out.print(i + " ");
    }
}