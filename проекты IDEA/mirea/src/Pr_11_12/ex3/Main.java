package Pr_11_12.ex3;

public class Main {
    public static void main(String[] args) {        //основной алгоритм программы
        String[] strings = new String[] {           //массив входных строк
                "S001,Black Polo Shirt,Black,XL",
                "S002,Black Polo Shirt,Black,L",
                "S003,Blue Polo Shirt,Blue,XL",
                "S004,Blue Polo Shirt,Blue,M",
                "S005,Tan Polo Shirt,Tan,XL",
                "S006,Black T-Shirt,Black,XL",
                "S007,White T-Shirt,White,XL",
                "S008,White T-Shirt,White,L",
                "S009,Green T-Shirt,Green,S",
                "S010,Orange T-Shirt,Orange,S",
                "S011,Maroon Polo Shirt,Maroon,S"
        };
        Shirt[] shirts = new Shirt[strings.length]; //новый массив рубашек
        for (int i = 0; i < strings.length; i++)    //цикл присвоения
            /* //присвоение элементам массива рубашек значения элемента массива входных строк */
            shirts[i] = new Shirt(strings[i]);
        for (Shirt shirt : shirts)                  //цикл по массиву рубашек
            System.out.println(shirt);              //вывод рубашки
    }
}
