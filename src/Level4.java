import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author safwan
 */
public class Level4 implements LevelInformation {
    private int ballsNumber;
    private List<Velocity> ballVelocities;
    private int paddlespeed;
    private int paddleWidth;
    private  String levelname;
    private Sprite background;
    private Color color;
    private List<Block> blocks;
    private int blocksToremove;
    /**
     * constructor.
     */
    public Level4() {
        this.ballsNumber = 30;
        this.ballVelocities = new ArrayList<>();
        for (int i = 0; i < this.ballsNumber; i++) {
            this.ballVelocities.add(new Velocity(0, 5));
        }
        this.blocks = new ArrayList<>();
        this.paddlespeed = 2;
        this.paddleWidth = 150;
        this.levelname = "Final Four";
        this.background = new Level4Bg();
        color = Color.blue;
        Random rand = new Random();
        for (int i = 0; i <= 4; i++) {
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, g, b);
            for (int j = 0; j <= 15; j++) {
                this.blocks.add(new Block(new Rectangle(new Point(720 - j - (45 * j),
                        260 - i - (25 * i)), 45, 25), randomColor));
            }
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
