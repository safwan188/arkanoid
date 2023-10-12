import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author safwan
 */
public class Block implements Sprite, Collidable, HitNotifier {
    private Rectangle blockshape;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * @param c new block shape
     * @param color new block color
     */
    public Block(Rectangle c, Color color) {
        this.color = color;
        this.blockshape = c;
        this.hitListeners =  new ArrayList<>();
    }
    /**
     * @param surface draws block on surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) blockshape.getUpperLeft().getX(), (int) blockshape.getUpperLeft().getY(),
                (int) blockshape.getWidth(), (int) blockshape.getHeight());
    }

    /**
     * @return block color
     */
    public Color getColor() {
        return this.color;
    }
    @Override
    public void timePassed() {

    }
    @Override
    //add block to game
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    /**
     * @return return blockshape
     */
    public Rectangle getCollisionRectangle() {
        return this.blockshape;
    }
    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).

    /**
     * @param collisionPoint collision points with this object
     * @param currentVelocity velocity of the ball
     * @param hitter hitter ball
     * @return new velocity of the ball
     */

    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        if (Math.round(collisionPoint.getY()) == Math.round(blockshape.getUpperLeft().getY() + blockshape.getHeight())
                || Math.round(collisionPoint.getY()) == Math.round(blockshape.getUpperLeft().getY())) {
            currentVelocity = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }
        if (Math.round(collisionPoint.getX()) == Math.round(blockshape.getUpperLeft().getX() + blockshape.getWidth())
                || Math.round(collisionPoint.getX()) == Math.round(blockshape.getUpperLeft().getX())) {
            currentVelocity = new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }
        this.notifyHit(hitter);
        return currentVelocity;
    }

    /**
     * @param game remove black from game
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);

    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);

    }
    /**
     * @param hitter the ball that hits the block
     */
    public void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }

    }
}