import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author safwan
 */
public class Level2 implements LevelInformation {

    private int ballsNumber;
    private List<Velocity> ballVelocities;
    private int paddlespeed;
    private int paddleWidth;
    private  String levelname;
    private Sprite background;
    private List<Block> blocks;
    private Color color;
    private int blocksToremove;
    /**
     * constructor.
     */
    public Level2() {
        this.ballsNumber = 7;
        this.ballVelocities = new ArrayList<>();
        this.blocks = new ArrayList<>();
        for (int i = 0; i < ballsNumber; i++) {
            this.ballVelocities.add(new Velocity(5 + i, 5 + i));
        }
        this.paddlespeed = 1;
        this.paddleWidth = 500;
        this.levelname = "Wide easy";
        color = Color.white;
        this.background = new Block(new Rectangle(new Point(0, 0), 800, 600), Color.white);
        Random rand = new Random();
        for (int i = 0; i < 16; i++) {
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, g, b);
            this.blocks.add(new Block(new Rectangle(new Point(719 - (i * 46),  200),
                    46, 40), randomColor));
        }
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
