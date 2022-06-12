import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {

        System.out.printf("left %d, right %d\n", left, right);
        if (left == right) {
            System.out.println("left = right");
            return -1;
        }
        if (left + 1 == right) {
            System.out.println("left +1 = right - "+a[left]);
            return a[left];
        }
        // write your code here
        int mid = (right + left) / 2;
        System.out.printf("mid %d\n", mid);
        int l = getMajorityElement(a, left, mid);
        System.out.printf("l %d\n", l);
        int r = getMajorityElement(a, mid, right);
        System.out.printf("r %d\n", r);
        if (l == -1) {
            System.out.println("l == -1 - "+r);
            return r;
        }

        if (r == -1) {
            System.out.println("r == -1 - "+l);
            return l;
        }

        if (l == r) {
            System.out.println("r == l - "+l);
            return l;
        }

        System.out.println("return -1");
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
