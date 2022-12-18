package Pr_13_14;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void printEmployee(String surname) {              //метод вывода фамилии и даты
        StringBuilder stringBuilder = new StringBuilder(surname);   //создание объекта класса stringBuilder

        //количество миллисекунд с полуночи 1 янаря 1970
        Date receiveDate = new Date();                              //создание объекта класса Date
        Date handingDate = new Date(System.currentTimeMillis() + 2628000000L);  //столько миллисекунд в месяце (31 день)

        SimpleDateFormat formatForDate = new SimpleDateFormat("dd.MM"); //создание объекта класса для форматирования вывода даты
        stringBuilder.append(".\nЗадание получено: ").append(formatForDate.format(receiveDate))
                .append("\nДата сдачи: ").append(formatForDate.format(handingDate));    //добавление в строку

        System.out.println(stringBuilder);  //вывод строки
    }

    public static void equalsDate() {                                   //меторд сравнения дат
        Scanner in = new Scanner(System.in);                            //подключение считывания с консоли
        System.out.println("Введите дату в формате 'дд.мм.гггг':");     //вывод о необходимом вводе
        String date = in.nextLine();                                    //считывание из консоли
        StringTokenizer st = new StringTokenizer(date, ".");            //разделение через точку
        int[] arrayOfDate = new int[st.countTokens()];                  //разбиение введённой строки
        for (int i = 0; i < 3; i++)                                     //цикл присвоения
            arrayOfDate[i] = Integer.parseInt(st.nextToken());          //присвоение элементам массива данных пользователя

        Calendar currentDate = new GregorianCalendar();                 //создание новой текущей даты
        currentDate.set(Calendar.HOUR_OF_DAY, 0);                       //присвоение полям времени нулей
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);
        Calendar inputDate = new GregorianCalendar(arrayOfDate[2], arrayOfDate[1] - 1, arrayOfDate[0]); //создание даты пользователя
        if (currentDate.equals(inputDate))                  //проверка на равенство
            System.out.println("Ваша дата равна текущей."); //вывод о равенстве
        else if (currentDate.before(inputDate))             //проверка на предшествие
            System.out.println("Ваша дата позже текущей."); //вывод о предшествии
        else
            System.out.println("Ваша дата раньше текущей.");//вывод о последовании
    }

    public static void formDate() {                 //метод создания объектов классов Date и Calendar
        Scanner in = new Scanner(System.in);        //подключение считывания с консоли
        System.out.println("Введите дату:");        //вывод о вводе необходимых данных
        String date = in.nextLine();                //считывание даты
        String time = in.nextLine();                //считывание времени
        int year = Integer.parseInt(date.substring(0, 4));      //разбиение на год, месяц, день, час и минуту
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6, 8));
        int hour = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(2, 4));

        Date generateDate = new Date((day - 1) * 86400000L);    //создание объекта класса Date через миллисекунды
        generateDate.setYear(year - 1900);  //установка года
        generateDate.setMonth(month - 1);   //установка месяца
        generateDate.setHours(hour);        //установка часа
        generateDate.setMinutes(minutes);   //установка минуты
        System.out.println(generateDate);   //вывод на экран generateDate

        Calendar generateCalendar = new GregorianCalendar();            //создание объекта класса Calendar
        generateCalendar.set(year, month - 1, day, hour, minutes, 0);   //установка года, месяца, дня, часа, минуты и секунды
        System.out.println(generateCalendar.getTime());                 //вывод на экран этого generateCalendar
    }

    public static void checkLists() {                           //метод проверки скорости работы коллекций
        Integer[] arr = {10, 4, 5, 6, 3};
        ArrayList<Integer> arrayList = new ArrayList<>();       //коллекция ArrayList
        LinkedList<Integer> linkedList = new LinkedList<>();    //коллекция LinkedList
        long startDate, endDate, calculation;                   //переменные для подсчёта времени

        Collections.addAll(arrayList, arr);                     //вставка базовых значений
        Collections.addAll(linkedList, arr);

        System.out.println("ArrayList:");
        startDate = System.nanoTime();
        arrayList.add(1);                                           //добавление элемента
        endDate = System.nanoTime();
        calculation = endDate - startDate;
        System.out.println("Время добавления нс: " + calculation);
        startDate = System.nanoTime();
        arrayList.add(1, 2);                                        //добавление по индексу
        endDate = System.nanoTime();
        calculation = endDate - startDate;
        System.out.println("Время вставки нс: " + calculation);
        startDate = System.nanoTime();
        arrayList.contains(5);                                      //поиск по образцу
        endDate = System.nanoTime();
        calculation = endDate - startDate;
        System.out.println("Время поиска нс: " + calculation);
        startDate = System.nanoTime();
        arrayList.remove(2);                                        //удаление элемента по индексу
        endDate = System.nanoTime();
        calculation = endDate - startDate;
        System.out.println("Время удаления нс: " + calculation);

        System.out.println("LinkedList:");
        startDate = System.nanoTime();
        linkedList.add(1);                                          //добавление элемента
        endDate = System.nanoTime();
        calculation = endDate - startDate;
        System.out.println("Время добавления нс: " + calculation);
        startDate = System.nanoTime();
        linkedList.add(1, 2);                                       //добавление по индексу
        endDate = System.nanoTime();
        calculation = endDate - startDate;
        System.out.println("Время вставки нс: " + calculation);
        startDate = System.nanoTime();
        linkedList.contains(5);                                     //поиск по образцу
        endDate = System.nanoTime();
        calculation = endDate - startDate;
        System.out.println("Время поиска нс: " + calculation);
        startDate = System.nanoTime();
        linkedList.remove(2);                                       //удаление элемента по индексу
        endDate = System.nanoTime();
        calculation = endDate - startDate;
        System.out.println("Время удаления нс: " + calculation);
    }

    public static void main(String[] args) {
        printEmployee("Вадим Малин");   //Ex1
        System.out.println();

        equalsDate();   //Ex2
        System.out.println();

        //Ex3
        Student AD = new Student("Анастасиади Дмитрий", "27.09.2003");
        Student VM = new Student();
        VM.setFIO("Вадим Малин");
        VM.setDate("25.11.2003");
        System.out.println(AD);
        System.out.println(VM);
        System.out.println(VM.getDate('l'));    //получение полной даты
        System.out.println(AD.getDate('m'));    //получение средней даты
        System.out.println();

        formDate(); //Ex4
        System.out.println();

        checkLists();   //Ex5
    }
}
