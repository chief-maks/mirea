package Pr_11_12.ex2;

import java.util.StringTokenizer;

public class Address {                                                          //класс адреса
    private String country, region, city, street, house, corpus, apartment;     //закрытые поля адереса

    public Address(String str, boolean comma) {                                 //перегруженный конструктор
        if (str == null)                                                        //проверка на пустую стркоу
            throw new IllegalArgumentException("String is empty!");             //выбрасывание исключения
        String[] strings;                                                       //объявление массива строк
        if (comma) strings = str.split(",");                                    //установка правила разделения
        else {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",.;");  //создание объекта класса StringTokenizer
            strings = new String[stringTokenizer.countTokens()];                //присвоение значения новго массива длины значения метода countTokens()
            for (int i = 0; stringTokenizer.hasMoreTokens(); i++)               //цикл присвоения
                strings[i] = stringTokenizer.nextToken();                       //присвоение элементам массива
        }

        if (strings.length < 7) throw new IllegalArgumentException("String not collect 7 elements!");   //проверка на наличие 7-и элементов в строке

        country = strings[0].trim();    //присвоение полям значений элементов массива без пробелов
        region = strings[1].trim();
        city = strings[2].trim();
        street = strings[3].trim();
        house = strings[4].trim();
        corpus = strings[5].trim();
        apartment = strings[6].trim();
    }

    @Override
    public String toString() {                              //переопределённый метод toString
        return "Address {" +                                //возврат строки
                "\n\tcountry = '" + country + '\'' +
                ",\n\tregion = '" + region + '\'' +
                ",\n\tcity = '" + city + '\'' +
                ",\n\tstreet = '" + street + '\'' +
                ",\n\thouse = '" + house + '\'' +
                ",\n\tcorpus = '" + corpus + '\'' +
                ",\n\tapartment = '" + apartment + '\'' +
                '}';
    }
}