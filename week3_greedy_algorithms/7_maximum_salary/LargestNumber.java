import java.util.*;
import java.util.stream.Collectors;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here

        Arrays.sort(a, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                double max1 = Double.parseDouble("9".repeat(o1.length()));
                double max2 = Double.parseDouble("9".repeat(o2.length()));

                if (max1/Integer.parseInt(o1) > max2/Integer.parseInt(o2))
                    return 1;
                else
                return -1;
            }
        });

        return Arrays.stream(a).collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
        scanner.close();
    }
}

