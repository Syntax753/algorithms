import java.util.*;


public class Knapsack {
  static int optimalWeight(int W, int[] weights) {
    // write you code here
    int result = 0;
    int n = weights.length;

    int[][] values = new int[n+1][W+1];

    for (int i = 0; i < W+1; i++) {
      values[0][i] = 0;
    }

    for (int i = 1; i < n+1; i++) {
      int weight = weights[i-1];
      for (int w = 1; w < W+1; w++) {
        if (w>=weight) {
          int max = Math.max(weight+values[i-1][w-weight], values[i-1][w]);
          values[i][w] = max;
        } else {
          values[i][w] = values[i-1][w];
        }
      }
    }

    // for (int i = 0; i < n+1; i++) {
    //   for (int j = 0; j < W+1; j++) {
    //     System.out.printf("%2d ", values[i][j]);
    //   }
    //   System.out.println();
    // }

    return values[n][W];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int W, n;
    W = scanner.nextInt();
    n = scanner.nextInt();
    int[] w = new int[n];
    for (int i = 0; i < n; i++) {
      w[i] = scanner.nextInt();
    }
    System.out.println(optimalWeight(W, w));
    scanner.close();
  }
}
