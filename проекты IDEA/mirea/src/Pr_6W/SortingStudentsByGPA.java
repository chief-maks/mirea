package Pr_6W;

public class SortingStudentsByGPA implements Comparator {
    private Student[] mas;
    public SortingStudentsByGPA(Student[] mas) {
        this.mas = mas;
    }
    public Student getMasI(int i) {
        return mas[i];
    }

    @Override
    public void quickSort(int low, int high) {
        if (low >= high) return;
        int middle = low + (high - low) / 2;
        int opora = mas[middle].getPoints();
        int i = low;
        int j = high;

        while (i <= j) {

            while (mas[i].getPoints() < opora) {
                ++i;
            }
            while (mas[j].getPoints() > opora) {
                --j;
            }

            if (i <= j) {
                int temp = mas[i].getPoints();
                mas[i].setPoints(mas[j].getPoints());
                mas[j].setPoints(temp);
                ++i;
                --j;
            }
        }

        if (low < j) quickSort(low, j);

        if (high > i) quickSort(i, high);
    }
}