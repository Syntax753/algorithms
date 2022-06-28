import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    int[][] grid = new int[s.length() + 1][t.length() + 1];

    for (int i = 0; i < s.length() + 1; i++) {
      grid[i][0] = i;
    }

    for (int i = 0; i < t.length() + 1; i++) {
      grid[0][i] = i;
    }

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      for (int j = 0; j < t.length(); j++) {
        if (t.charAt(j) == c) {
          grid[i + 1][j + 1] = grid[i][j];

        } else {
          grid[i + 1][j + 1] = Math.min(grid[i][j], Math.min(grid[i][j + 1], grid[i + 1][j])) + 1;
        }

      }
    }

    // for (int i = 0; i < grid.length; i++) {
    // for (int j = 0; j < grid[0].length; j++) {
    // System.out.print(grid[i][j] + " ");
    // }
    // System.out.println();
    // }

    return grid[s.length()][t.length()];

  }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
    scan.close();
  }

}
