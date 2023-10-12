/**
 * @author safwan
 */
public class CollisionInfo {
    private Point collPoint;
    private Collidable box;
    // the point at which the collision occurs.
    /**
     * construct CollisionInfo from params.
     * @param collPoint collpoints
     * @param box box
     */
    public CollisionInfo(Point collPoint, Collidable box) {
        this.collPoint = collPoint;
        this.box = box;
    }
    /**
     * @return collision points
     */
    public Point collisionPoint() {
        return this.collPoint;
    }
    // the collidable object involved in the collision.
    /**
     * @return collison object
     */
    public Collidable collisionObject() {
        return this.box;
    }
}
