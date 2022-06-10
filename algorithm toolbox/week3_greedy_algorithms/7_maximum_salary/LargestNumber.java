import java.util.*;
import java.util.stream.Collectors;

public class LargestNumber {
    private static String largestNumber(String[] a) {

        Arrays.sort(a, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int a = Integer.parseInt(o1);
                double aMax = Integer.parseInt(o1.replaceAll("[0-9]", "9"));
                int b = Integer.parseInt(o2);
                double bMax = Integer.parseInt(o2.replaceAll("[0-9]", "9"));

                if (aMax/a > bMax/b)
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

