package Pr_11_12.ex3;

public class Shirt {                            //класс рубашки
    private String number, name, color, size;   //закрытые поля номера, названия, цвета и размера

    public Shirt(String str) {                  //перегруженный конструктор
        String[] strings = str.split(",");      //разделение строки используя меотд split
        number = strings[0];                    //присвоение полям значений элементов массива
        name = strings[1];
        color = strings[2];
        size = strings[3];
    }

    @Override
    public String toString() {                      //переопределённый метод toString
        return "Shirt {" +                          //возврат строки
                "\n\tnumber = '" + number + '\'' +
                ",\n\tname = '" + name + '\'' +
                ",\n\tcolor = '" + color + '\'' +
                ",\n\tsize = '" + size + '\'' +
                '}';
    }
}