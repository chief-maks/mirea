package Pr_9.Second;

public class Student {
    private int IDNumber = 0;
    static int counter = 1;
    private int GPA;
    private String FIO;

    public Student() {
        IDNumber = counter++;
    }
    public Student(String FIO) throws EmptyStringException {
        if (FIO == "") throw new EmptyStringException();
        this.FIO = FIO;
        IDNumber = counter++;
    }
    public Student(String FIO, int GPA) throws EmptyStringException {
        if (FIO == "") throw new EmptyStringException();
        this.GPA = GPA;
        this.FIO = FIO;
        IDNumber = counter++;
    }

    public int getIDNumber() { return IDNumber; }
    public int getGPA() { return GPA; }
    public void setGPA(int GPA) { this.GPA = GPA; }
    public String getFIO() { return FIO; }
    public void setFIO(String FIO) { this.FIO = FIO; }

    @Override
    public String toString() {
        return "Студент: " +
                "\nФИО: " + FIO +
                "\nСредний балл - " + GPA;
    }
}