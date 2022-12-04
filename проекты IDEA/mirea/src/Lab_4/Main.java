package Lab_4;

public class Main {
    public static void main(String[] args) {
        MacBook macBook = new MacBook(2017.0, "gold", 512.0, 13.0);
        Iphone iphone13 = new Iphone(13.0, "Product Red", 128.0);
        AppleWatch appleWatch = new AppleWatch(2022.0, "white");
        System.out.println(macBook);
        System.out.println(iphone13);
        System.out.println(appleWatch);
    }
}