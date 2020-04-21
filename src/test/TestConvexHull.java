package test;

import algorithmn.ConvexPolygon;
import algorithmn.Point;
import algorithmn.PointSet;

public class TestConvexHull {
    public static void main(String[] args) {
        unifyTest();

        Point inside = new Point(45, 70);
        containsPointTest(inside);
        Point outside = new Point(55, 60);
        containsPointTest(outside);

        convexHullTest();
    }

    private static void unifyTest() {
        System.out.println("---------unifyTest()------------");
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
        Point p2 = new Point(65, -75);
        Point p3 = new Point(15, 55);
        Point p4 = new Point(45, 70);
        Point p5 = new Point(-90, 92.5);
        Point p6 = new Point(55, 60);
        Point p7 = new Point(85.86, 8943.4);
        Point p8 = new Point(7.4, 85);
        Point p9 = new Point(3, 6.6);
        Point p10 = new Point(7455, 67.5);
        Point p11 = new Point(-7455.65, 45.5);
        Point p12 = new Point(63, 54.67);
        Point p13 = new Point(865.4, 45.5);
        Point p14 = new Point(6, -5.5);
        Point p15 = new Point(67, 34.5);
        Point p16 = new Point(96.5, 4);
        Point p17 = new Point(-45., 854);
        Point p18 = new Point(6.7, 856);
        Point p19 = new Point(-34, 8665);
        Point p20 = new Point(2.4, 45);
        Point p21 = new Point(576.6, 45);
        PointSet set = new PointSet();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);
        set.add(p6);
        set.add(p7);
        set.add(p8);
        set.add(p9);
        set.add(p10);
        set.add(p11);
        set.add(p12);
        set.add(p13);
        set.add(p14);
        set.add(p15);
        set.add(p16);
        set.add(p17);
        set.add(p18);
        set.add(p19);
        set.add(p20);
        set.add(p21);
        ConvexPolygon result = new ConvexPolygon(set.convexHull());
        System.out.println(result.toString());

        Point t1 = new Point();
        Point t2 = new Point(346.546, 568.46);
        PointSet set2 = new PointSet();
        set2.add(t1);
        set2.add(t2);
        ConvexPolygon result2 = new ConvexPolygon(set2.convexHull());
        System.out.println(result2.toString());
    }
}
