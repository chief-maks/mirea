package Pr_6;

public class Main {
    public static void main(String[] args) {
        Student[] mas = new Student[5];
        mas[0] = new Student("Leonid", 91);
        mas[1] = new Student("Misha", 79);
        mas[2] = new Student("Maksim", 58);
        mas[3] = new Student("Masha", 98);
        mas[4] = new Student("Sasha", 83);

        System.out.println("Исходный массив:");

        for(int i = 0; i < 5; i++) {
            System.out.println(mas[i]);
        }

        SortingStudentsByGPA sortMas = new SortingStudentsByGPA(mas);
        sortMas.quickSort(0, mas.length - 1);

        System.out.println("Отсортированный массив:");

        for(int i = 0; i < 5; i++) {
            System.out.println(sortMas.getMasI(i));
        }

    }
}
