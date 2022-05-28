import java.util.Scanner;

public class Fibonacci {
    private static long calc_fib(int n) {
        int[] fibList = new int[Math.max(2, n + 1)];
        fibList[0] = 0;
        fibList[1] = 1;

        for (int i = 2; i < fibList.length; i++) {
            fibList[i] = fibList[i - 2] + fibList[i - 1];
        }

        // for (int i = 0; i < fibList.length; i++) {
        //     System.out.println(fibList[i]);
        // }

        return fibList[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
        in.close();
    }
}
