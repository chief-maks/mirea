package Pr_11_12.ex4;

public class Phone {                            //класс телефонного нмоера
    private String code, three1, three2, four;  //закрытые поля кода и последующие наборы цифр

    public Phone(String str) {                                          //перегруженный конструктор
        four = str.substring(str.length() - 4);                         //присвоение полям значений методов substring
        three2 = str.substring(str.length() - 7, str.length() - 4);
        three1 = str.substring(str.length() - 10, str.length() - 7);
        String temp = str.substring(0, str.length() - 10);
        if (str.startsWith("+"))        //проверка на первый знак
            code = temp;                //присвоение без вычитания
        else
            code = "+" + String.valueOf(Integer.parseInt(temp) - 1);    //прсивоение с вычитанием
    }

    @Override
    public String toString() {
        return "phone = " + code + three1 + "-" + three2 + "-" + four;
    }   //переопределённый метод toString
}