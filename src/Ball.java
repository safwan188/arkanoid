import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author safwan
 */
public class Ball implements Sprite {
    // fields
    private GameEnvironment environment;
    private int r;
    private Point point;
    private Velocity velocity;
    private Color ballcolor;
    // constructor
    /**
     * @param x x coordinates
     * @param y y coordinates
     * @param radius ball radius
     * @param color ball color
     * construct a ball from 2 coordinates ints and radius from int and color
     */
    public Ball(int x, int y, int radius, java.awt.Color color) {
        r = radius;
        ballcolor = color;
        this.point = new Point(x, y);
    }

    /**
     * @param g adds ball to g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
    /**
     * @param point ball center/coordinates
     * @param radius ball radius
     * @param color ball color
     * construct a ball from  a point radius and color
     */
    public  Ball(Point point, int radius, java.awt.Color color) {
        r = radius;
        ballcolor = color;
        this.point = new Point((int) point.getX(), (int) point.getY());
    }
    // accessors
    /**
     * @return ball center x coordinates
     */
    public int getX() {
        return (int) this.point.getX();
    }

    /**
     * @return this ball center
     */
    public Point getCenter() {
        return this.point;
    }
    /**
     * @return ball center y coordinates
     */
    public int getY() {
        return (int) this.point.getY();
    }
    /**
     * @return ball radius
     */
    public int getSize() {
        return this.r;
    }
    /**
     * @return ball velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }
    /**
     * @return ball color
     */
    public java.awt.Color getColor() {
        return this.ballcolor;
    }
    // draw the ball on the given DrawSurface
    /**
     * @param surface the ball draws it self on
     * ball draws it self on surface
     */
    public void drawOn(DrawSurface surface) {
         surface.setColor(this.ballcolor);
        surface.fillCircle((int) point.getX(), (int) point.getY(), r);
    }
    @Override
    public void timePassed() {
        this.moveOneStep();
    }
    // set ball velocity
    /**
     * @param v taking v and apply it to ball velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }
    /**
     * @param dx horzintal speeed
     * @param dy vertical speed
     * sets velocity using horzintal and vertical speed
     */
    //another method to set velocity
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }
    //method to move ball one step using ball velocity
    /**
     * moves one step calculates possible collison changes speed if there is a hit.
     */
    public void moveOneStep() {
        Point endpoint = this.point;
        while (endpoint.getX() < 765  && endpoint.getX() > 35   && endpoint.getY() < 595 && endpoint.getY() > 35) {
            Velocity v = new Velocity(this.velocity.getDx(), this.velocity.getDy());
            endpoint = v.applyToPoint(endpoint);
        }

        Line trajercy = new Line(this.point, endpoint);
        CollisionInfo info = environment.getClosestCollision(trajercy);
        if (info != null) {
            Velocity v2 = new Velocity(-this.velocity.getDx(), -this.velocity.getDy());
            Point temp = v2.applyToPoint(info.collisionPoint());
            double d = this.point.distance(info.collisionPoint()) - temp.distance(info.collisionPoint());
            if (d <= 1) {
                this.velocity = info.collisionObject().hit(this, info.collisionPoint(), this.getVelocity());
            }
        }
        //moves one step
        this.point = this.getVelocity().applyToPoint(this.point);
    }
    /**
     * @param ge sets ball game environment ge
     */
    public void setGameEnvironment(GameEnvironment ge) {
        this.environment = ge;
    }
}
