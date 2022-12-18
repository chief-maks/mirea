package Pr_10W.Second;

public class ChairFactory implements AbstractChairFactory {     //класс-фабрика
    /* переопределённый метод создания комплексного числа
     *  возвращает объект класса VictorianChair с полем возраста 0 */
    @Override
    public VictorianChair createVictorianChair() {
        return new VictorianChair(0);
    }

    /* переопределённый метод создания комплексного числа
     *  возвращает объект класса MagicChair */
    @Override
    public MagicChair createMagicanChair() {
        return new MagicChair();
    }

    /* переопределённый метод создания комплексного числа
     *  возвращает объект класса FunctionalChair */
    @Override
    public FunctionalChair createFunctionalChair() {
        return new FunctionalChair();
    }
}