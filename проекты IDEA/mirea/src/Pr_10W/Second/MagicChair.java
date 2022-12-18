package Pr_10W.Second;

public class MagicChair implements Chair {      //класс магического стула
    public MagicChair() {}                      //конструктор

    public void doMagic() {
        System.out.println("Magic happened!");
    }   //метод осуществления магии

    @Override
    public String toString() {
        return "MagicanChair";
    }   //переопределённый метод toString
}