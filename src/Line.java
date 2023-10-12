
/**
 * @author safwan
 */

public class Line {
    // fields
    private Point  start;
    private Point end;
    // constructors

    /**
     * @param start starting point
     * @param end ending point
     * draw a line from 2 points starting from the smallest x coordinates
     */
    public Line(Point start, Point end) {

            this.start = start;
            this.end = end;



    }
    /**
     * @param x1 point 1 x
     * @param y1 point 1 y
     * @param x2 point 2 x
     * @param y2 point 2 y
     * builds 2 points from 4 double and then build a line from 2 points
     */
    public Line(double x1, double y1, double x2, double y2) {

            start = new Point(x1, y1);
            end = new Point(x2, y2);

    }
    // Return the length of the line
    /**
     * @return the length of the line
     */
    public double length() {
        return start.distance(end);
    }
    // Returns the middle point of the line
    /**
     * @return middle points in the line
     */
    public Point middle() {
        return new Point((this.end.getX() + this.start.getX()) / 2, (Math.max(this.start.getY(), this.end.getY())
                + Math.min(this.start.getY(), this.end.getY())) / 2);
    }
    // Returns the start point of the line
    /**
     * @return this line start point
     */
    public Point start() {
        return this.start;
    }
    // Returns the end point of the line
    /**
     * @return this line end point
     */
    public Point end() {
        return this.end;
    }
    // Returns true if the lines intersect, false otherwise
    /**
     * @param other checks if other line intersect with this line
     * @return true if there is intersection false otherwise
     */
    public boolean isIntersecting(Line other) {
        if (this.start.equals(other.start) && this.end.equals(other.end)) {
            return true;
        }
        // Line AB represented as a1x + b1y = c1
        double a1 = this.end.getY() - this.start.getY();
        double b1 = this.start.getX() - this.end.getX();
        double c1 = a1 * (this.start.getX()) + b1 * (this.start.getY());

        // Line CD represented as a2x + b2y = c2
        double a2 = other.end.getY() - other.start.getY();
        double b2 = other.start.getX() - other.end.getX();
        double c2 = a2 * (other.start.getX()) + b2 * (other.start.getY());

        double determinant = a1 * b2 - a2 * b1;

        if (determinant == 0 && ((end.getX() == other.start.getX() && end.getY() == other.start.getY())
                || (other.end.getX() == start.getX() && other.end.getY() == start.getY()))) {
            return true;
        } else if (determinant == 0 && (b1 != 0 || b2 != 0)) {
            // The lines are parallel.
            return false;
        } else {
            double x = (b2 * c1 - b1 * c2) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;
            x = Math.round(x);
            y = Math.round(y);
            return Math.round(Math.min(start.getX(), end.getX())) <= x
                    && x <= Math.round(Math.max(start.getX(), end.getX()))
                    && Math.round(Math.min(other.start.getX(), other.end.getX())) <= x
                    && x <= Math.round(Math.max(other.start.getX(), other.end.getX()))
                    && Math.round(Math.min(start.getY(), end.getY())) <= y
                    && Math.round(Math.max(start.getY(), end.getY())) >= y
                    && Math.round(Math.min(other.start.getY(), other.start.getY())) <= y
                    && Math.round(Math.max(other.start.getY(), other.end.getY())) >= y;
        }

    }
    // Returns the intersection point if the lines intersect,
    // and null otherwise.
    /**
     * @param other line that intersect with
     * @return intersection point between this line and other line if it exsist null otherwise
     */
    public Point intersectionWith(Line other) {
        if (isIntersecting(other)) {
            // Line AB represented as a1x + b1y = c1
            double a1 = this.end.getY() - this.start.getY();
            double b1 = this.start.getX() - this.end.getX();
            double c1 = a1 * (this.start.getX()) + b1 * (this.start.getY());

            // Line CD represented as a2x + b2y = c2
            double a2 = other.end.getY() - other.start.getY();
            double b2 = other.start.getX() - other.end.getX();
            double c2 = a2 * (other.start.getX()) + b2 * (other.start.getY());

            double determinant = a1 * b2 - a2 * b1;
            if (determinant == 0) {
                if (start.getX() < other.start.getY() && this.end.equals(other.start)) {
                    return this.end;
                } else if (other.start.getX() < start.getX() && this.start.equals(other.end)) {
                    return this.start;
                }
            }
            double x = (b2 * c1 - b1 * c2) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;
            if (determinant == 0) {
                return null;
            }
            return new Point(x, y);
        }
        return null;

    }
    // equals -- return true is the lines are equal, false otherwise

    /**
     * @param other line
     * @return true if other line equals this line flase otherwise
     */
    public boolean equals(Line other) {
        return ((this.start.equals(other.start) && this.end.equals(other.end))
                || (this.start.equals(other.start) && this.end.equals(other.end)));

    }
    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.
    /**
     * @param rect collidable object shape
     * @return closest point of intersection
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //list  of intersect points with object
        java.util.List<Point> points =  rect.intersectionPoints(this);
        //check if there is no intersection points
        if (points.isEmpty()) {
            return null;
        }
        double[] distances = new double[4];
        Point temp;
        temp = points.get(0);
        if ((temp.getY() == 0 || temp.getX() == 0) && points.size() > 1) {
            temp = points.get(1);
        }
        double tempdist;
        tempdist = this.start.distance(temp);
        //searchs for closest intersection point
        for (Point intpoint: points) {
            int i = 0;
            if (intpoint != null) {
                distances[i] = this.start.distance(intpoint);
                if (distances[i] < tempdist) {
                    temp = intpoint;
                }
            }
            i++;
        }
        return temp;
    }
}
