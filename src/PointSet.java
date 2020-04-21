import static java.lang.Math.min;

public class PointSet {
    private Point [] buffer = null;
    private int capacity = 0;
    private int size = 0;

    // constructs a void set of points with capacity 0
    public PointSet() {
        this(0);
    }

    // constructs a void set of points with the given capacity
    public PointSet(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.buffer = new Point[capacity];
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

    // changes the capacity of the set of points (newCapacity can be greater, smaller or equal than the old capacity
    public void changeCapacity(int newCapacity) {
        if (capacity != newCapacity) {
            Point [] newBuffer = new Point[newCapacity];
            size = min(size, newCapacity);
            for (int i = 0; i < size; ++i) {
                newBuffer[i] = buffer[i];
            }
            buffer = newBuffer;
            capacity = newCapacity;
        }
    }

    // adds a point to the set and increases the capacity if necessary
    public void add(Point p) {
        if (size + 1 > capacity) {
            changeCapacity((capacity + 1) * 2);
        }
        ++size;
        buffer[size - 1] = p;
    }

    // TODO returns the i-th point of the set
    public Point get(int i) {
        return null;
    }

    // TODO unifies two sets of points and returns a new set of points
    public PointSet unify(PointSet other) {
        return null;
    }

    // constructs a string in this format: [(x1,y1), ..., (xn,yn)]
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; ++i) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(buffer[i].toString());
        }
        sb.append("]");
        return sb.toString();
    }

    // TODO calculates the convex hull of the set of points
    public ConvexPolygon convexHull() {
        return null;
    }
}
