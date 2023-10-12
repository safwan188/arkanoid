/**
 * @author safwan
 */
public interface HitListener {
    // This method is called whenever the beingHit object is hit.
    // The hitter parameter is the Ball that's doing the hitting.
    /**
     * @param beingHit block being hit
     * @param hitter hitter ball
     */
    void hitEvent(Block beingHit, Ball hitter);
}