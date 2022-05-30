import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumFast(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        List<Long> sums = new ArrayList<>();
        sums.add(0L);
        sums.add(1L);
        Long sum = 1L;

        for (long i = 0; i < n-1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%10;
            sum+=current;
            sum %=10;
            sums.add(sum);

            if (previous == 0 && current == 1) {
                n = n%(i+1);
                break;
            }
            
        }

        // System.out.println(n + " "+ sums);
        return sums.get((int) (n));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumFast(n);
        System.out.println(s);
        scanner.close();
    }
}

