import java.util.*;
import java.util.stream.Collectors;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {

        List<Segment> segs = Arrays.stream(segments).sorted(Comparator.comparing(s -> s.end))
                .collect(Collectors.toList());

        // System.out.println(segs);

        int p = -1;
        List<Integer> points = new ArrayList<>();
        for (Segment s:segs) {
            if (s.start > p) {
                p = s.end;
                points.add(p);
            }
        }

        return points.stream().mapToInt(i->i).toArray();

    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
        scanner.close();
    }
}
