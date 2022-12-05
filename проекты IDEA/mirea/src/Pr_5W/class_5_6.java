package Pr_5W;

public class class_5_6 {
    public static int recursion(int n, int d) {
        if (d > 1 && n % d == 0) {
            return 0;
        }
        else if (d <= 2) {
            return 1;
        }
        else {
            return recursion(n, d-1);
        }
    }
    public static void main(String[] args) {
        int n = 3;
        if (recursion(n, n-1) == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
