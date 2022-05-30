import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int sqrt = (int) Math.sqrt((double) n);
        // System.out.println(sqrt);

        int top = 0;
        int sum = 0;
        for (int i = sqrt; sum <= n; i++) {
            top = i - 1;
            sum = i * (i + 1) / 2;
        }
        top--;

        for (int i = 0; i < top; i++) {
            summands.add(i + 1);
        }

        int addOn = n - top * (top + 1) / 2;

        if (addOn > 0) {
            summands.add(addOn);
        }

        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
        scanner.close();
    }
}
