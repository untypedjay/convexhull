public class TestConvexHull {
    public static void main(String[] args) {
        PointSet set1 = new PointSet();
        Point p11 = new Point(3.4, 5.2);
        set1.add(p11);
        Point p12 = new Point(30.34, 23.4);
        set1.add(p12);
        System.out.println(set1.toString());

        PointSet set2 = new PointSet();
        Point p21 = new Point(67.3, 36.66);
        set2.add(p21);
        Point p22 = new Point(2.78, 7.435);
        set2.add(p22);
        System.out.println(set2.toString());

        PointSet unified = set1.unify(set2);
        System.out.println(unified.toString());
        System.out.println(unified.size());
    }
}
