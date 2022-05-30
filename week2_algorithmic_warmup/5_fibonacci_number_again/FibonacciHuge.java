import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeFast(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;

        List<Long> mods = new ArrayList<>();
        long cycle = 0;
        for (long i = 0; i < n - 1; ++i) {
            mods.add(previous);
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%m;

            if (previous == 0 && current == 1) {
                cycle = i + 1;
                break;
            }
        }

        // System.out.println(mods+ " " +current);

        if (cycle == 0) {
            return current;
        } else {
            return mods.get((int) (n % cycle)) % m;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeFast(n, m));
        scanner.close();
    }
}
