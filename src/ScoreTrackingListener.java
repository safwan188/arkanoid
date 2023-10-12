/**
 * @author safwan
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    //constructor
    /**
     * @param scoreCounter scorecounter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * @param beingHit block being hit
     * @param hitter ball hitting the block
     */
    public void hitEvent(Block beingHit, Ball hitter) {
      this.currentScore.increase(5);
    }
}
