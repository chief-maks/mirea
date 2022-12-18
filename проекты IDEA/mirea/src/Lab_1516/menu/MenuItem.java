package Lab_1516.menu;

public class MenuItem {         //класс позиции меню
    private String name;        //название
    private String description; //описание
    private double cost;        //стоимость

    /* перегруженный конструктор */
    public MenuItem(String name, String description, double cost) {
        this.name = name;               //присвоение полям значений параметров
        this.description = description;
        this.cost = cost;
    }

    public String getName() { return name; }                //методы получения значений полей
    public String getDescription() { return description; }
    public double getCost() { return cost; }
}