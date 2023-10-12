/**
 @author safwan butto
 */
public class Point {
    //fields
    private double x;
    private double y;
    // constructor
    /**
     * @param x x cordinates
     * @param y cordinates
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // distance -- return the distance of this point to the other point

    /**
     * @param other point
     * @return distance between this point and other
     */
    public  double distance(Point other) {
        return Math.sqrt(((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y)));
    }
    // equals -- return true is the points are equal, false otherwise
    /**
     * @param other POINT
     * @return true or false
     * checks if other point is equal to this point
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        double epsilon = Math.pow(10, -13);
        return Math.abs(this.x - other.x) < epsilon && Math.abs(this.y - other.y) < epsilon;
    }
    // Return the x and y values of this point

    /**
     * @return this point x coordinates
     */
    public double getX() {
        return this.x;
    }
    /**
     * @return this point y coordinates
     */
    public double getY() {
        return this.y;
    }
}