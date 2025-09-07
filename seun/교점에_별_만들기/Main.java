package seun.교점에_별_만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  private static class Point {
    public final long x, y;

    private Point(long x, long y) {
      this.x = x;
      this.y = y;
    }
  }

  private static Point intersection(
      long a1, long b1, long c1, long a2, long b2, long c2) {
    long det = a1 * b2 - a2 * b1;
    if (det == 0) return null;

    long xNum = b1 * c2 - b2 * c1;
    long yNum = a2 * c1 - a1 * c2;

    if (xNum % det != 0 || yNum % det != 0) return null;

    return new Point(xNum / det, yNum / det);
  }

  private static Point getMinimumPoint(List<Point> points) {
    long x = Long.MAX_VALUE;
    long y = Long.MAX_VALUE;
    for (Point p : points) {
      if (p.x < x) {
        x = p.x;
      }
      if (p.y < y) {
        y = p.y;
      }
    }
    return new Point(x, y);
  }

  private static Point getMaximumPoint(List<Point> points) {
    long x = Long.MIN_VALUE;
    long y = Long.MIN_VALUE;
    for (Point p : points) {
      if (p.x > x) {
        x = p.x;
      }
      if (p.y > y) {
        y = p.y;
      }
    }
    return new Point(x, y);
  }

  public static String[] solution(int[][] line) {
    List<Point> points = new ArrayList<>();
    for (int i = 0; i < line.length; i++) {
      for (int j = i + 1; j < line.length; j++) {
        Point p =
            intersection(
                line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
        if (p != null) {
          points.add(p);
        }
      }
    }

    if (points.isEmpty()) {
      return new String[0];
    }

    Point minimum = getMinimumPoint(points);
    Point maximum = getMaximumPoint(points);

    int width = (int) (maximum.x - minimum.x + 1);
    int height = (int) (maximum.y - minimum.y + 1);

    char[][] arr = new char[height][width];
    for (char[] row : arr) {
      Arrays.fill(row, '.');
    }

    for (Point p : points) {
      int x = (int) (p.x - minimum.x);
      int y = (int) (maximum.y - p.y);
      arr[y][x] = '*';
    }

    String[] result = new String[arr.length];
    for (int i = 0; i < result.length; i++) {
      result[i] = new String(arr[i]);
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] line = {
      {2, -1, 4},
      {-2, -1, 4},
      {0, -1, 1},
      {5, -8, -12},
      {5, 8, 12}
    };

    String[] out = solution(line);
    for (String s : out) {
      System.out.println(s);
    }
  }
}