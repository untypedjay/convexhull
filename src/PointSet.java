import static java.lang.Math.min;

public class PointSet {
    protected Point [] buffer = null;
    protected int capacity = 0;
    protected int size = 0;

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

    // constructs a set of points with the corner points of a convex polygon
    public PointSet(ConvexPolygon points) {
        this(points.capacity * 2);
        addToPointSet(this, points);
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
            for (int i = 0; i < size(); ++i) {
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

    // returns the i-th point of the set
    public Point get(int i) {
        return buffer[i]; //TODO may throw exception if index is negative
    }

    // unifies two sets of points and returns a new set of points
    public PointSet unify(PointSet other) {
        PointSet unified = new PointSet(this.capacity + other.capacity);
        addToPointSet(unified, this);
        addToPointSet(unified, other);
        return unified;
    }

    // constructs a string in this format: [(x1,y1), ..., (xn,yn)]
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size(); ++i) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(buffer[i].toString());
        }
        sb.append("]");
        return sb.toString();
    }

    // calculates the convex hull of the set of points
    public ConvexPolygon convexHull() {
        ConvexPolygon convexHull = new ConvexPolygon();
        Point start = new Point(this.findLeftmostPoint());
        Point end;
        int i = 0;
        do {
            convexHull.add(start);
            end = this.get(0);
            for (int j = 0; j < this.size(); ++j) {
                if (start == end || isLeft(start, end, this.get(j))) {
                    end = this.get(j);
                }
            }
            ++i;
            System.out.println(i);
            start = end;
        } while (end.x != convexHull.get(0).x && end.y != convexHull.get(0).y);
        return convexHull;
    }

    private void addToPointSet(PointSet resultSet, PointSet addSet) {
        for (int i = 0; i < addSet.size(); ++i) {
            resultSet.add(addSet.get(i));
        }
    }

    protected static boolean isLeft(Point start, Point end, Point auditee) {
        double cross_product = (end.x - start.x) * (auditee.y - start.y) - (end.y - start.y) * (auditee.x - start.x);
        if (cross_product > 0) {
            return true;
        } else if (cross_product < 0) {
            return false;
        } else if (distance(start, auditee) + distance(auditee, end) == distance(start, end)) {
            return false;
        } else {
            return true;
        }
    }

    private Point findLeftmostPoint() {
        Point leftmost = new Point();
        leftmost = buffer[0];
        for (int i = 1; i < size; ++i) {
            if (buffer[i].x < leftmost.x) {
                leftmost = buffer[i];
            }
        }
        return leftmost;
    }

    private static double distance(Point a, Point b) {
        return Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.x));
    }
}
