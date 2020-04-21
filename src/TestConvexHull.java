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
        containsPointTestIn();
        containsPointTestOut();
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

    private static void containsPointTestIn() {
        System.out.println("---------containsPointTestIn()------------");
        Point p1 = new Point(15, 55);
        Point p2 = new Point(30, 90);
        Point p3 = new Point(90, 92.5);
        Point p4 = new Point(65, 75);
        Point test = new Point(45, 70);
        ConvexPolygon poly = new ConvexPolygon();
        poly.add(p1);
        poly.add(p2);
        poly.add(p3);
        poly.add(p4);
        System.out.println(poly.containsPoint(test));
    }

    private static void containsPointTestOut() {
        System.out.println("---------containsPointTestOut()------------");
        Point p1 = new Point(15, 55);
        Point p2 = new Point(30, 90);
        Point p3 = new Point(90, 92.5);
        Point p4 = new Point(65, 75);
        Point test = new Point(55, 60);
        ConvexPolygon poly = new ConvexPolygon();
        poly.add(p1);
        poly.add(p2);
        poly.add(p3);
        poly.add(p4);
        System.out.println(poly.containsPoint(test));
    }
}
