import java.util.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {

        if (stops[0] > tank) {
            return -1;
        }
        for (int i = 1; i < stops.length; i++) {
            if (stops[i] - stops[i - 1] > tank) {
                return -1;
            }
        }

        if (dist - stops[stops.length - 1] > tank) {
            return -1;
        }

        int travel = 0;
        int refills = 0;
        int scout = 0;
        for (int i = 0; i < stops.length; i++) {
            if (travel + tank >= dist) {
                break;
            }

            if (stops[i] > travel + tank) {
                travel = scout;
                scout = 0;
                refills++;
            } else {
                scout = stops[i];
            }
        }

        if (travel + tank < dist) {
            refills++;
        }

        return refills;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
        scanner.close();
    }
}
