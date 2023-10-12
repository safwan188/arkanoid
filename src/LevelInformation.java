import java.awt.Color;
import java.util.List;

/**
 * @author safwan
 */
public interface LevelInformation {
    /**
     * @return number of balls in level
     */
    int numberOfBalls();
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()

    /**
     * @return ballvelocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return paddle speed
     */
    int paddleSpeed();

    /**
     * @return paddle width
     */
    int paddleWidth();
    // the level name will be displayed at the top of the screen.

    /**
     * @return levelname
     */
    String levelName();
    // Returns a sprite with the background of the level

    /**
     * @return background
     */
    Sprite getBackground();
    // The Blocks that make up this level, each block contains
    // its size, color and location.

    /**
     * @return list of blocks in level
     */
    List<Block> blocks();
    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();

    /**
     * @return blocks to remove from game
     */
    int numberOfBlocksToRemove();
    //returns level background color
    /**
     * @return background color
     */
    Color getColor();
}
