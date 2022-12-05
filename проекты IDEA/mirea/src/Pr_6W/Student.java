package Pr_6W;

public class Student {
    private String name;
    private int points;

    public Student(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public String getName() {
        return name;
    }
    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', points=" + points + "}";
    }
}
