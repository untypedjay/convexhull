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

        ConvexPolygon poly1 = new ConvexPolygon();
        System.out.println(poly1.toString());

        isLeftTestGreater();
        isLeftTestLess();
        isLeftTestGreaterColinear();
        isLeftTestLessColinear();

        Point inside = new Point(45, 70);
        containsPointTest(inside);
        Point outside = new Point(55, 60);
        containsPointTest(outside);

        convexHullTest();
    }

    private static void isLeftTestGreater() {
        System.out.println("---------isLeftTestGreater()------------");
        Point start = new Point(15, 55);
        Point end = new Point(65, 75);
        Point test = new Point(30, 90);
        System.out.println(PointSet.isLeft(start, end, test));
    }

    private static void isLeftTestLess() {
        System.out.println("---------isLeftTestLess()------------");
        Point start = new Point(65, 75);
        Point end = new Point(30, 90);
        Point test = new Point(75, 85);
        System.out.println(PointSet.isLeft(start, end, test));
    }

    private static void isLeftTestGreaterColinear() {
        System.out.println("---------isLeftTestGreaterColinear()------------");
        Point start = new Point(90, 92.5);
        Point end = new Point(45, 70);
        Point test = new Point(15, 55);
        System.out.println(PointSet.isLeft(start, end, test));
    }

    private static void isLeftTestLessColinear() {
        System.out.println("---------isLeftTestLessColinear()------------");
        Point start = new Point(45, 70);
        Point end = new Point(90, 92.5);
        Point test = new Point(75, 85);
        System.out.println(PointSet.isLeft(start, end, test));
    }

    private static void containsPointTest(Point test) {
        System.out.println("---------containsPointTest()------------");
        Point p1 = new Point(15, 55);
        Point p2 = new Point(30, 90);
        Point p3 = new Point(90, 92.5);
        Point p4 = new Point(65, 75);
        ConvexPolygon poly = new ConvexPolygon();
        poly.add(p1);
        poly.add(p2);
        poly.add(p3);
        poly.add(p4);
        System.out.println(poly.containsPoint(test));
    }

    private static void convexHullTest() {
        System.out.println("---------convexHullTest()------------");
        Point p1 = new Point(30, 90);
        Point p2 = new Point(65, 75);
        Point p3 = new Point(15, 55);
        Point p4 = new Point(45, 70);
        Point p5 = new Point(90, 92.5);
        Point p6 = new Point(55, 60);
        Point p7 = new Point(75, 85);
        PointSet set = new PointSet();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);
        set.add(p6);
        set.add(p7);
        ConvexPolygon result = new ConvexPolygon(set.convexHull());
        System.out.println(result.toString());

    }
}
