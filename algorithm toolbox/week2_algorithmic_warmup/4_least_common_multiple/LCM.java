import java.util.*;

public class LCM {
  private static long gcd_fast(int a, int b) {
    if (b == 0) {
      return a;
    }

    return gcd_fast(b, a % b);
  }


  private static long lcm_fast(int a, int b) {
    if (a == 0  && b == 0) {
      return 0;
    }

    return (long) a*b/gcd_fast(a, b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_fast(a, b));
    scanner.close();
  }
}
