package Lab_4;

public class Iphone implements Priceable {
    private double version;
    private double ssdСapacity;
    private String color;

    public Iphone(double version, String color, double ssdСapacity) {
        this.color = color;
        this.version = version;
        this.ssdСapacity = ssdСapacity;
    }

    @Override
    public double getPrice() {
        return Math.ceil(version / 14.0 * ((ssdСapacity + 512.0) / 1024.0) * 1000.0);
    }

    @Override
    public String toString() {
        return "iphone " + (int)version + ", цвет - " + color + ", обьем ssd - " + ssdСapacity + "гб. Предположительная цена - " + (int)getPrice() + "$";
    }
}
