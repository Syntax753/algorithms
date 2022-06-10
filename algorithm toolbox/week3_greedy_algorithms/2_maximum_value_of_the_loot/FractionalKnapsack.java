import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        // write your code here
        while (capacity > 0) {
            double max = 0;
            int idx = -1;

            for (int i = 0; i < values.length; i++) {
                if (values[i] != 0 && values[i] / (double)weights[i] > max) {
                    max = values[i] / (double) weights[i];
                    idx = i;
                }
            }

            if (idx == -1) {
                break;
            }

            int w = weights[idx];
            value += Math.min(w, capacity) * max;
            capacity -= w;
            values[idx] = 0;
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
        scanner.close();
    }
}
