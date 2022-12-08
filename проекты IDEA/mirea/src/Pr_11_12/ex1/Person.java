package Pr_11_12.ex1;

public class Person {                           //класс человека
    private String lastName, name, secondName;  //закрытые поля ФИО

    public Person() {                   //конструктор
        lastName = "Иванов";            //присвоение полю зачнения по умолчанию
        name = "Иван";                  //присвоение полю зачнения по умолчанию
        secondName = "Иванович";        //присвоение полю зачнения по умолчанию
    }
    public Person(String lastName) {    //перегруженный конструктор
        this.lastName = lastName;       //присвоение полю значения параметра
        name = "Иван";                  //присвоение полю зачнения по умолчанию
        secondName = "Иванович";        //присвоение полю зачнения по умолчанию
    }
    public Person(String lastName, String name) {   //перегруженный конструктор
        this.lastName = lastName;                   //присвоение полю значения параметра
        this.name = name;                           //присвоение полю значения параметра
        secondName = "Иванович";                    //присвоение полю зачнения по умолчанию
    }
    public Person(String lastName, String name, String secondName) {    //перегруженный конструктор
        this.lastName = lastName;                                       //присвоение полю значения параметра
        this.name = name;                                               //присвоение полю значения параметра
        this.secondName = secondName;                                   //присвоение полю значения параметра
    }

    public String returnFIO() {     //метод получения ФИО
        StringBuilder stringBuilder = new StringBuilder(lastName);      //создание объекта класса StringBuilder
        stringBuilder.append(" ").append(name.charAt(0)).append(".").   //добавление значения полей и знаков препинания
                append(secondName.charAt(0)).append(".");
        return stringBuilder.toString();    //возврат значения метода toString объекта stringBuilder
    }
}