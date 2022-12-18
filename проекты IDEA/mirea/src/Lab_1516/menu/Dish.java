package Lab_1516.menu;

public class Dish extends MenuItem {    //класс блюда
    /* перегруженные конструкторы */
    public Dish(String name, String description) {
        super(name, description, 0);
    }
    public Dish(String name, String description, double cost) {
        super(name, description, cost);
    }
}