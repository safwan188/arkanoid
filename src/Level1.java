
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author safwan
 */
public class Level1 implements LevelInformation {

    private int ballsNumber;
    private List<Velocity> ballVelocities;
    private int paddlespeed;
    private int paddleWidth;
    private  String levelname;
    private Sprite background;
    private List<Block> blocks;
    private int blocksToremove;
    private Color color;
    /**
     * constructor.
     */
    public Level1() {
        this.ballsNumber = 1;
        ballVelocities = new ArrayList<>();
        blocks = new ArrayList<>();
        this.ballVelocities.add(new Velocity(0, 4));
        this.paddlespeed = 2;
        this.paddleWidth = 60;
        this.levelname = "Direct hit";
        this.background = new Level1Bg();
        this.color = Color.black;
        this.blocks.add(new Block(new Rectangle(new Point(380,  150), 40, 40), Color.red));
    }
    @Override
    public Color getColor() {
        return color;
    }
    @Override
    public int numberOfBalls() {
        return ballsNumber;
    }
    @Override
    public List<Velocity> initialBallVelocities() {
        return ballVelocities;
    }

    @Override
    public int paddleSpeed() {
        return paddlespeed;
    }

    @Override
    public int paddleWidth() {
        return paddleWidth;
    }

    @Override
    public String levelName() {
        return levelname;
    }

    @Override
    public Sprite getBackground() {
        return background;
    }

    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocksToremove;
    }
}
