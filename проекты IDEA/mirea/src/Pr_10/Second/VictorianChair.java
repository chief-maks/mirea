package Pr_10.Second;

public class VictorianChair implements Chair {  //класс викторианского стула
    private int age;                            //закрытое поле возраста
    public VictorianChair(int age) {
        this.age = age;
    }   //конструктор

    public int getAge() { return age; }                 //метод получения возраста стула

    @Override
    public String toString() {          //переопределённый метод toString
        return "VictorianChair { " +    //возврат строки
                "age = " + age +
                '}';
    }
}