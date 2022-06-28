import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        int[] values = new int[n + 1];
        values[0] =1;

        for (int i = 0; i < n && values[n] == 0; i++) {

            if (i <= n / 3 && values[i * 3] == 0) {
                values[i * 3] = values[i] + 1;
            }

            if (i <= n / 2) {
                if (values[i * 2] == 0) {
                    values[i * 2] = values[i] + 1;
                } else {
                    values[i * 2] = Math.min(values[i * 2], values[i] + 1);
                }
            }

            if (values[i + 1] == 0) {
                values[i + 1] = values[i] + 1;
            } else {
                values[i + 1] = Math.min(values[i + 1], values[i] + 1);
            }

        }

        // for (int i = 1; i < values.length; i++) {
        //     System.out.println("i " + i + " " + values[i]);
        // }

        List<Integer> sequence = new ArrayList<>();

        while (n != 0) {
            sequence.add(n);

            int min = values[n];
            int idx = 0;

            if (n % 3 == 0) {
                if (values[n / 3] > 0 && values[n / 3]< min) {
                    min = values[n / 3];
                    idx = n / 3;
                }
            }

            if (n % 2 == 0) {
                if (values[n / 2] > 0 && values[n / 2]< min) {
                    min = values[n / 2];
                    idx = n / 2;
                }
            }

            if (values[n - 1] >0 && values[n-1]< min) {
                min = values[n - 1];
                idx = n - 1;
            }

            n = idx;
        }

        Collections.reverse(sequence);

        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
        scanner.close();
    }
}
