import java.util.ArrayList;
import java.util.List;
/**
 * @author safwan
 */
public class GameEnvironment {
    // add the given collidable to the environment.
    private List<Collidable> collidables = new ArrayList<Collidable>();
    /**
     * @param c add collidable to collidables list
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * @return this collidables
     */
    public List<Collidable> getCollidables() {
        return this.collidables;
    }
    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.
    /**
     * @param trajectory checks if trajectory collides with collidables
     * @return collisioninfo
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Point> copoints = new ArrayList<Point>();
        for (Collidable box: collidables) {
            Point point = trajectory.closestIntersectionToStartOfLine(box.getCollisionRectangle());
            if (point != null) {
                copoints.add(point);
            }
        }
        if (copoints.isEmpty()) {
            return null;
        }
        Point min = copoints.get(0);
        if ((min.getY() == 0 || min.getX() == 0) && copoints.size() > 1) {
            min = copoints.get(1);
        }

        for (Point p:copoints) {
            if (min.distance(trajectory.start()) >= p.distance(trajectory.start())) {
                min = p;
            }
        }
        int temp = -1;
        for (Collidable box: collidables) {
            if (min.equals(trajectory.closestIntersectionToStartOfLine(box.getCollisionRectangle()))) {
                temp = collidables.indexOf(box);
                break;
            }
        }
        return new CollisionInfo(min, collidables.get(temp));
    }
}
