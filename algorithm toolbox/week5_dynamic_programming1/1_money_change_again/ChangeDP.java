import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int[] coins = new int[Math.max(m+1,5)];
        coins[0] = 0;
        coins[1] = 1;
        coins[2] = 2;
        coins[3] = 1;
        coins[4] = 1;

        if (m < 5) {
            return coins[m];
        }
        
        for (int i = 5; i <= m; i++) {
            coins[i] = Math.min(Math.min(coins[i-3], coins[i-4]),coins[i-1]) +1;
        }

        // for (int i : coins) {
        //     System.out.println(i+" ");
        // }

        return coins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
        scanner.close();
    }
}

