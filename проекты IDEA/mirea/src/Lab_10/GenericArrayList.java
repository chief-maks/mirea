package Lab_10;

import java.util.*;

public class GenericArrayList<T> {      //класс, хранящий любые типы данных
    private T[] list;                   //массив элементов
    private int size;                   //размер массива

    public GenericArrayList() {         //конструктор
        size = 0;                       //присвоение длины
        list = (T[]) new Object[size];  //создание массива
    }

    public GenericArrayList(int size) { //перегруженный конструктор
        this.size = size;               //присвение длины
        list = (T[]) new Object[size];  //создание массива
    }

    public GenericArrayList(T[] array) {    //перегруженный конструктор
        this.size = array.length;           //присвение длины
        list = array;                       //присвоение массива
    }

    public int getSize() { return size; }   //метод получения длины массива

    public boolean isEmpty() {          //метод проверяющий отсутствие элементов
        if (size == 0) return true;     //возврат логической единицы
        return false;                   //возврат логического нуля
    }

    public void clear() {                           //метод очистки массива
        for (int index = 0; index < size; index++)  //цикл по массиву
            list[index] = null;                     //зануление элементов
    }

    public T get(int index) {                       //метод получения элемента по индексу
        try {                                       //блок пробирования
            return list[index];                     //возврат элемента по индексу
        } catch (IndexOutOfBoundsException e) {     //отлавливание исключения типа выхода за границы массива
            System.out.println("Out of bounds!");   //вывод о выходе за границы массива
            return null;                            //возврат нуля
        }
    }

    public boolean set(int index, T element) {      //метод установки элемента на определённый индекс
        try {                                       //блок пробирования
            list[index] = element;                  //присвоение элемента по индексу
            return true;                            //возврат логической единицы
        } catch (IndexOutOfBoundsException e) {     //отлавливание исключения типа выхода за границы массива
            System.out.println("Out of bounds!");   //вывод о выходе за границы массива
            return false;                           //возврат логического нуля
        }
    }

    public boolean remove(int index) {              //метод удаления элемента по индексу
        try {                                       //блок пробирования
            list[index] = null;                     //зануление элемента по индексу
            return true;                            //возврат логической единицы
        } catch (IndexOutOfBoundsException e) {     //отлавливание исключения типа выхода за границы массива
            System.out.println("Out of bounds!");   //вывод о выходе за границы массива
            return false;                           //возврат логического нуля
        }
    }

    public int indexOf(T element) {                 //метод поиска элемента с возвратом индекса вхождения
        if (isEmpty())                              //проверка на наличие элементов
            throw new IllegalStateException("Array is empty!"); //выбрасывани исключения
        for (int index = 0; index < size; index++)  //цикл по элементам массива
            if (list[index].equals(element))        //проверка на соответствие
                return index;                       //возврат индекса вхождения
        return -1;                                  //возврат -1 (отсутсвие)
    }

    public boolean add(T element) {                 //метод добавления элемента
        for (int i = 0; i < size; i++) {            //цикл по элементам массива
            if (list[i] == null) {                  //проверка на отсутсвие элемента на индексе
                list[i] = element;                  //присвоение элемента
                return true;                        //возврат логической единицы
            }
        }
        list = Arrays.copyOf(list, size + 1);       //копипрование массива
        list[size] = element;                       //присвоение элемента
        size++;                                     //инкрементация длины массива
        return true;                                //возврат логической единицы
    }

    public boolean contains(T element) {                        //метод поиска элемента
        if (isEmpty())                                          //проверка на наличие элементов
            throw new IllegalStateException("Array is empty!"); //выбрасывани исключения
        for (int index = 0; index < size; index++)              //цикл по элементам массива
            if (list[index].equals(element))                    //проверка на соответствие
                return true;                //возврат логической единицы
        return false;                       //возврат логического нуля
    }

    public boolean containsAll(Collection<T> collection) {  //метод проверки вхождения всех элементов в массив
        ArrayList<T> arr = new ArrayList<>(collection);     //создание списка из параметра
        for (int i = 0; i < arr.size(); i++) {              //цикл по списку
            if (this.contains(arr.get(i))) continue;        //проверка на соответствие
            else return false;                              //возврат логического нуля
        }
        return true;                                        //возврат логической единицы
    }

    public GenericArrayList<T> subList(int index1, int index2) {    //метод выделения подсписка
        GenericArrayList<T> newArray = new GenericArrayList<>();    //создание списка
        try {                                       //блок пробирования
            for(int i = index1; i < index2; i++)    //цикл по массиву от индекса до индекса
                newArray.add(list[i]);              //добавление в подсписок
            return newArray;                        //возврат подсписка
        } catch (IndexOutOfBoundsException e) {     //отлавливание исключения типа выхода за границы массива
            System.out.println("Out of bounds!");   //вывод о выходе за границы массива
            return newArray;                        //возврат подсписка
        }
    }

    public void sort(Comparator<? super T> comp) {      //метод сортировка массиа
        try {                                           //блок пробирования
            for (int i = 0; i < size; i++) {            //сортировка выбором
                int maxElementIndex = i;
                for (int j = i + 1; j < size; j++)
                    if (comp.compare(list[maxElementIndex], list[j]) > 0)
                        maxElementIndex = j;
                if (maxElementIndex != i) {
                    T temp = list[i];
                    list[i] = list[maxElementIndex];
                    list[maxElementIndex] = temp;
                }
            }
        } catch (NullPointerException e) {              //отлавливание исключение типа нулевой указатель
            System.out.println("Sorting is not possible. Fill in all the values."); //вывод об отсутствии возможности сортировки
        }
    }

    @Override
    public String toString() {                          //переопределённый метод toString
        return "GenericArrayList { " +                  //возврат строки
                " list = " + Arrays.toString(list) +
                ", size = " + size +
                '}';
    }
}