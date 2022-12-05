package Pr_5W;

public class class_5_7 {
    public static int recursion2(int n, int d) {
        if (d > 1 && n % d == 0) {
            return 0;
        }
        else if (d <= 2) {
            return 1;
        }
        else {
            return recursion2(n, d-1);
        }
    }

    public static void recursion1(int n, int d) {
        if (n % d == 0) {
            if (recursion2(d, d - 1) == 1) {
                System.out.println(d);
            }
            if (d != n/d && recursion2(n/d, n/d - 1) == 1) {
                System.out.println(n/d);
            }
        }
        if (d < Math.sqrt(n)) recursion1(n, d+1);

    }

    public static void main(String[] args) {
        int n = 58;
        recursion1(n, 2);
    }
}
