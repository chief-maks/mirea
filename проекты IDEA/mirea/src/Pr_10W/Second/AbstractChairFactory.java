package Pr_10W.Second;

interface AbstractChairFactory {                //интерфейс фабрики
    VictorianChair createVictorianChair();      //метод создания викторианского стула
    MagicChair createMagicanChair();            //метод создания магического стула
    FunctionalChair createFunctionalChair();    //метод создания функционального стула
}