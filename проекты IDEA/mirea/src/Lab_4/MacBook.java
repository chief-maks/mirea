package Lab_4;

public class MacBook implements Priceable {
    private double productionYear;
    private double ssdСapacity;
    private double diagonal;
    private String color;

    public MacBook(double productionYear, String color, double ssdСapacity, double diagonal) {
        this.color = color;
        this.productionYear = productionYear;
        this.diagonal = diagonal;
        this.ssdСapacity = ssdСapacity;
    }

    @Override
    public double getPrice() {
        return Math.ceil((productionYear - 2000.0) / 20.0 * ((ssdСapacity + 512.0) / 1024.0) * (diagonal / 13.0) * 1200.0);
    }

    @Override
    public String toString() {
        return "MacBook. Год - " + (int)productionYear + ", диагональ - " + diagonal + ", цвет - " + color + ", обьем ssd - " + ssdСapacity + "гб. Предположительная цена - " + (int)getPrice() + "$";
    }
}