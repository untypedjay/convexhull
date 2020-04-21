package algorithmn;

public class ConvexPolygon extends PointSet {

    // constructs a void set of points with capacity 0
    public ConvexPolygon() {
        super(0);
    }

    // constructs a void set of points with the given capacity
    public ConvexPolygon(int capacity) {
        super(capacity);
    }

    // constructs a set of points with the corner points of a convex polygon
    public ConvexPolygon(ConvexPolygon points) {
        super(points);
    }

    // checks if point p is inside of the convex polygon
    public boolean containsPoint(Point p) {
        Point start;
        Point end;
        for (int i = 0; i < size - 1; ++i) {
            start = buffer[i];
            end = buffer[i + 1];
            if (PointSet.isLeft(start, end, p)) {
                return false;
            }
        }
        start = buffer[size - 1];
        end = buffer[0];
        if (PointSet.isLeft(start, end, p)) {
            return false;
        }
        return true;
    }
}
