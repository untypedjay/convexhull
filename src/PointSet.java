public class PointSet {
    private int capacity;
    private int size;

    // TODO constructs a void set of points with capacity 0
    public PointSet() {

    }

    // TODO constructs a void set of points with the given capacity
    public PointSet(int capacity) {

    }

    // TODO constructs a set of points with the corner points of a convex polygon
    public PointSet(ConvexPolygon points) {

    }

    // returns the capacity of the set of points
    public int capacity() {
        return this.capacity;
    }

    // returns the size of the set of points
    public int size() {
        return this.size;
    }

    // TODO changes the capacity of the set of points (newCapacity can be greater, smaller or equal than the old capacity
    public void changeCapacity(int newCapacity) {

    }

    // TODO adds a point to the set and increases the capacity if necessary
    public void add(Point p) {

    }

    // TODO returns the i-th point of the set
    public Point get(int i) {
        return null;
    }

    // TODO unifies two sets of points and returns a new set of points
    public PointSet unify(PointSet other) {
        return null;
    }

    // TODO constructs a string in this format: [(x1,y1), ..., (xn,yn)]
    public String toString() {
        return "test";
    }

    // TODO calculates the convex hull of the set of points
    public ConvexPolygon convexHull() {
        return null;
    }
}
