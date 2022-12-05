package Pr_5W;

public class class_5_5 {
    static int summa(int a, int b) {
        if(a > 0) {
            b += a % 10;
            a /= 10;
            return summa(a, b);
        }
        return b;
    }

    public static void main(String arg[]) {
        int a = 6546;
        System.out.println(summa(a, 0));
    }
}
