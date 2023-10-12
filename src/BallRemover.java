/**
 * @author safwan
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * @param game Game to remove balls from
     * @param remainingBalls remaining balls
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.game.removeSprite(hitter);
        this.remainingBalls.decrease(1);

    }
}
