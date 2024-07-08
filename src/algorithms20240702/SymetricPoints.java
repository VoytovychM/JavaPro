package algorithms20240702;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SymetricPoints {


    private int x;
    private int y;

    public SymetricPoints() {
        this.x = x;
        this.y = y;
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SymetricPoints point = (SymetricPoints) obj;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    public static boolean isSymetric(Point[] points) {
        if (points == null || points.length == 0) return true;

        Map<Integer, Set<Integer>> pointMap = new HashMap<>();
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (Point point : points) {
            pointMap.computeIfAbsent(point.x, k -> new HashSet<>()).add(point.y);
            minX = Math.min(minX, point.x);
            maxX = Math.max(maxX, point.x);
        }

        double symmetryLine = (minX + maxX) / 2.0;
        for (Point point : points) {
            int symmetricalX = (int) Math.round (2 * symmetryLine - point.x);
            if (!pointMap.containsKey(symmetricalX) || !pointMap.get(symmetricalX).contains(point.y)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        SymetricPoints checker = new SymetricPoints();

        Point[] points1 = {
                new Point(1, 1),
                new Point(-1, 1),
                new Point(2, 2),
                new Point(-2, 2)
        };
        System.out.println(checker.isSymetric(points1));// true

        Point[] points2 = {
                new Point(1, 1),
                new Point(-1, 1),
                new Point(3, 2),
                new Point(-2, 2)
        };
        System.out.println(checker.isSymetric(points2)); //false

        Point[] pointsSym1 = new Point[]{
                new Point(1, 3),
                new Point(3, 3),


        };

        System.out.println(checker.isSymetric(pointsSym1));
        Point[] pointsSym2 = new Point[]{
                new Point(-2, 5),
                new Point(-1, 3),
                new Point(4, 3),
                new Point(0, 5),
                new Point(0, -1),
                new Point(2, 3),
                new Point(1, 3),
                new Point(2, 3),
                new Point(5, 5),
                new Point(3, -1),
                new Point(6, 3),
                new Point(-3, 3),
                new Point(3, 5),
        };
        System.out.println(checker.isSymetric(pointsSym2));
    }
}




