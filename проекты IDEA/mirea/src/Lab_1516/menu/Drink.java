package Lab_1516.menu;

public final class Drink extends MenuItem implements Alcoholable {
    private double alcoholVol;      //градус алкоголя
    private DrinkTypeEnum type;     //тип напитка

    /* перегруженный конструктор */
    public Drink(String name, String description, double cost,
                 double alcoholVol, DrinkTypeEnum type) {
        super(name, description, cost);
        this.alcoholVol = alcoholVol;
        this.type = type;
    }

    public DrinkTypeEnum getType() { return type; } //возврат итипа напитка

    @Override
    public boolean isAlcoholDrink() {               //проверка на алкоголь
        return Double.compare(alcoholVol, 0) > 0;   //проверка на спиртное
    }

    @Override
    public double getAlcoholVol() {                 //получение крепкости напитка
        return alcoholVol;                          //возврат значения поля
    }
}