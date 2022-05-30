import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int c = m / 10;
        m %= 10;

        if (m >= 5) {
            c++;
            m -= 5;
        }

        return c + m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
        scanner.close();
    }
}
