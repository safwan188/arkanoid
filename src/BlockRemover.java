/**
 * @author safwan
 */
public class BlockRemover implements HitListener {

    private GameLevel game;
    private Counter remainingBlocks;
    //constructor
    /**
     * @param game game to remove blocks from
     * @param remainingBlocks remainging blocks in game
     */
    public BlockRemover(GameLevel game, Counter remainingBlocks) {
        this.remainingBlocks = remainingBlocks;
        this.game = game;
    }
    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    /**
     * @param beingHit the block that is being hit
     * @param hitter the ball that hits the block
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(game);
        this.game.getRemainingblocks().decrease(1);

    }
}
