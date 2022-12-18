package Pr_14_15.menu;

public class Dish implements Item {                     //класс блюда
    private String name;                                //поле названия
    private String description;                         //поле описания
    private double cost;                                //поле стоимости

    public Dish(String name, String description) {      //перегруженный конструктор
        this.name = name;                               //присвоение полям значений
        this.description = description;
        this.cost = 0;
    }
    public Dish(String name, String description, double cost) {     //перегруженный конструктор
        if (cost < 0 || name.equals("") || description.equals(""))  //проверка на корректность
            throw new IllegalArgumentException();                   //выбрасывание исключения
        this.name = name;                                           //присвоение полям значений
        this.description = description;
        this.cost = cost;
    }

    public String getName() { return name; }                        //методы возвращающие значения полей
    public String getDescription() { return description; }
    public double getCost() { return cost; }
}