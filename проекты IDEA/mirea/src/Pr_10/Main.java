package Pr_10;

public class Main {
    public static void main(String[] args) {
        ConcreteFactory factory = new ConcreteFactory();

        System.out.println(factory.CreateComplex(2, 3));
    }
}
