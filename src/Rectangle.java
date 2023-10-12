
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author safwan
 */
public class Rectangle {
    private Point upleft;
    private double width;
    private double height;
    /**
     * Create a new rectangle with location and width/height.
     * @param upperLeft upleft
     * @param width width
     * @param height height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        if (width <= 0 || height <= 0) {
            return;
        }
        this.upleft = upperLeft;
        this.width = width;
        this.height = height;
    }
    /**
     * @param line Return a (possibly empty) List of intersection points with line.
     * @return Return a (possibly empty) List of intersection points with line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intrpoints = new ArrayList<Point>();
        Line upper = new Line(upleft, new Point(upleft.getX() + width, upleft.getY()));
        Line lower = new Line(upleft.getX(), upleft.getY() + height, upleft.getX() + width,
                upleft.getY() + height);
        Line left = new Line(upleft, new Point(upleft.getX(), upleft.getY() + height));
        Line right = new Line(upleft.getX() + width, upleft.getY(), upleft.getX() + width,
                upleft.getY() + height);
        Point point1 = line.intersectionWith(lower);
        intrpoints.add(point1);
        Point point = line.intersectionWith(upper);
        intrpoints.add(point);
        Point point2 = line.intersectionWith(left);
        intrpoints.add(point2);
        Point point3 = line.intersectionWith(right);
        intrpoints.add(point3);
        intrpoints.removeIf(Objects::isNull);
        return  intrpoints;
    }
    // Return the width and height of the rectangle

    /**
     * @return rec width
     */
    public double getWidth() {
        return  this.width;
    }
    /**
     * @return rec height
     */
    public double getHeight() {
        return this.height;
    }
    /**
     * @return rec upper left point
     */
    public Point getUpperLeft() {
        return this.upleft;
    }
}
