package Lab_4;

public class AppleWatch implements Priceable {
    private double productionYear;
    private String color;

    public AppleWatch(double productionYear, String color) {
        this.color = color;
        this.productionYear = productionYear;
    }

    @Override
    public double getPrice() {
        return Math.ceil((productionYear - 2000.0) / 22.0 * 500.0);
    }

    @Override
    public String toString() {
        return "Apple Watch. Год - " + (int)productionYear + ", цвет - " + color + ". Предположительная цена - " + (int)getPrice() + "$";
    }
}