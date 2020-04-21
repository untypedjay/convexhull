package algorithmn;

public class Point {
    public double x = 0;
    public double y = 0;

    public Point() {
        this(0, 0);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(" + x + ", " + y + ")");
        return sb.toString();
    }
}
