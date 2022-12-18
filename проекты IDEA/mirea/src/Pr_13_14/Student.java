package Pr_13_14;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Student {
    private int IDNumber = 0;
    static int counter = 1;
    private String FIO;
    private GregorianCalendar date;             //дата рождения

    public Student() {
        IDNumber = counter++;
    }
    public Student(String FIO) {
        this.FIO = FIO;
        IDNumber = counter++;
    }
    public Student(String FIO, String date){    //конструктор с датой рождения
        this.FIO = FIO;
        IDNumber = counter++;
        setDate(date);                          //установка даты рождения
    }

    public String getDate(char typeOutput) {    //метод получения даты
        SimpleDateFormat formatForDate;         //формат вывода даты
        switch (typeOutput) {                   //оператор множества выбора
            case 'm':                                                   //средний формат вывода
                formatForDate = new SimpleDateFormat("dd.MM.yyyy");     //присвоение формата
                break;
            case 'l':                                                   //полный формат вывода
                formatForDate = new SimpleDateFormat("dd MMMM yyyy");   //присвоение формата
                break;
            default:                                                    //короткий формат по умолчанию
                formatForDate = new SimpleDateFormat("dd.MM.yy");       //присвоение формата
                break;
        }

        return formatForDate.format(date.getTime());
    }

    public void setDate(String date) {                                      //метод установки даты рождения
        StringTokenizer st = new StringTokenizer(date, ".");                //создание разделителя строки
        int[] arrayOfDate = new int[st.countTokens()];                      //создание массива для разбиения строки
        for (int i = 0; i < 3; i++)                                         //цикл присвоения
            arrayOfDate[i] = Integer.parseInt(st.nextToken());              //присвоение элементам массива данных из строки
        GregorianCalendar setDate = new GregorianCalendar();                //создание текущей даты
        setDate.set(arrayOfDate[2], arrayOfDate[1] - 1, arrayOfDate[0]);    //установка даты
        setDate.set(Calendar.HOUR_OF_DAY, 0);                               //присвоение полям времени нулей
        setDate.set(Calendar.MINUTE, 0);
        setDate.set(Calendar.SECOND, 0);
        setDate.set(Calendar.MILLISECOND, 0);
        this.date = setDate;
    }

    public int getIDNumber() { return IDNumber; }
    public String getFIO() { return FIO; }
    public void setFIO(String FIO) { this.FIO = FIO; }

    @Override
    public String toString() {                      //переопределённый метод toString
        return "Студент: " +                        //возврат строки
                "\nФИО: " + FIO +
                "\nДата рождения: " + getDate('s'); //вывод в коротком формате по умолчанию
    }
}