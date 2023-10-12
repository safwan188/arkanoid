/**
 * @author safwan
 */
public class Velocity {
    //class fields
    private double v;
    private double dx;
    private double dy;
    // constructors
    /**
     * @param dx horizntal speed
     * @param dy vertical speed
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
        v = Math.sqrt((dx * dx) + (dy * dy));
    }
    /**
     * @param angle to determind vertical speed and horizntal speed
     * @param speed speed
     * @return velocity from angle and speed
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double radian = Math.toRadians(angle);
        double dx = (Math.sin(radian) * speed);
        double dy = (Math.cos(radian) * speed);
        return new Velocity(dx, dy);
    }
    /**
     * @return horizntal speed
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * @return vertical speed
     */
    public double getDy() {
        return this.dy;
    }
    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    /**
     * @return absolute speed
     */
    public double getV() {
        return this.v;
    }
    /**
     * @param p point
     * @return point +dx point +dy
     */
    public Point applyToPoint(Point p) {
        return new Point((p.getX() + dx),  (p.getY() + dy));
    }
}
