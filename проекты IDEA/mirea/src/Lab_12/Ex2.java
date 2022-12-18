package Lab_12;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex2 {
    public static void main(String[] arg) {
        System.out.println(isThatString("abcdefghijklmnopqrstuv18340"));
        System.out.println(isThatString("abcdefghijklmnopqrstuv18340."));
        System.out.println(findValue("25.98 USD. 0.004 EU"));
        System.out.println(isNotState("1 + 3 + 5"));
        System.out.println(isNotState("(1 + 3) - 5"));
        System.out.println(isNotState("1 + 3 -5"));
        System.out.println(isDate("29/02/2000"));
        System.out.println(isDate("01/01/2003"));
        System.out.println(isDate("29/02/2001"));
        System.out.println(isDate("30-04-2003"));
        System.out.println(isDate("1/1/1899")); //начиная с 1900 года
        System.out.println(isEmail("user@example.com"));
        System.out.println(isEmail("root@localhost"));
        System.out.println(isEmail("myhost@@@com.ru"));
        System.out.println(isEmail("@my.ru"));
        System.out.println(isPassword("F032_Password"));
        System.out.println(isPassword("TrySpy1"));  //7 символов
        System.out.println(isPassword("smart_pass"));
        System.out.println(isPassword("A007"));
    }

    public static boolean isThatString(String str) {        //метод сравнения строки
        return str.equals("abcdefghijklmnopqrstuv18340");   //возврат значения метода equals
    }

    public static ArrayList<String> findValue(String str) { //метод поиска цен
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?\\s?((RUB)|(USD)|(EU))");  //создание шаблона
        Matcher matcher = pattern.matcher(str);                                     //согласование
        ArrayList<String> arrayList = new ArrayList<>();    //создание нового списка
        while (matcher.find())                              //цикл поиска
            arrayList.add(matcher.group());                 //добавление подстроки в список
        return arrayList;                                   //возврат списка
    }

    public static boolean isNotState(String str) {                  //метод проверки цифр
        Pattern pattern = Pattern.compile("\\d+([)])*\\s+([^+])+"); //создание шаблона
        Matcher matcher = pattern.matcher(str);                     //согласование
        return matcher.find();                                      //возврат наличия подстроки
    }

    public static boolean isDate(String str) {          //метод проверки даты
        Pattern pattern = Pattern.compile("29/02/+(19([02468][048])|([3579][26])" +
                "| ([2-9]\\d([02468][048])|([3579][26]))) |" +
                "(\\d+/+\\d+/+((19)|(2))+\\d{2})");     //создание шаблона
        Matcher matcher = pattern.matcher(str);         //согласование
        return matcher.find();                          //возврат наличия подстроки
    }

    public static boolean isEmail(String str) {                         //метод проверки адреса электронной почты
        Pattern pattern = Pattern.compile("([a-z])+@([a-z])+(\\.)*");   //создание шаблона
        Matcher matcher = pattern.matcher(str);                         //согласование
        return matcher.find();                                          //возврат наличия подстроки
    }

    public static boolean isPassword(String str) {                      //метод проверки надёжности пароля
        Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z_]{8,}"); //создание шаблона
        Matcher matcher = pattern.matcher(str);                                                 //согласование
        return matcher.find();                                                                  //возврат наличия подстроки
    }
}