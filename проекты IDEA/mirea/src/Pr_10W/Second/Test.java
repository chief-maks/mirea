package Pr_10W.Second;

public class Test {                                         //класс для тестирования
    public static void main(String[] arg) {                 //основной алгоритм программы
        ChairFactory chairFactory = new ChairFactory();     //создание фабрики
        Client client = new Client();                       //создание новго клиента
        Chair chair = chairFactory.createMagicanChair();    //создание магического стула
        ((MagicChair)chair).doMagic();                      //осуществление магии
        client.setChair(chair);                             //установка клиенту стула
        System.out.println(client);                         //вывод данных о клиенте
        chair = chairFactory.createVictorianChair();        //создание викторианского стула
        chair = (VictorianChair)chair;                      //приведение типов
        client.setChair(chair);                             //установка клиенту стула
        System.out.println(client);                         //вывод данных о клиенте
    }
}