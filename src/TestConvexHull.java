public class TestConvexHull {
    public static void main(String[] args) {
        PointSet set1 = new PointSet();
        Point p1 = new Point(3.4, 5.2);
        set1.add(p1);
        Point p2 = new Point(30.34, 23.4);
        set1.add(p2);
        System.out.println(set1.toString());
    }
}
