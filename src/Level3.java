import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author safwan
 */
public class Level3 implements LevelInformation {

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
    public Level3() {
        this.ballsNumber = 20;
        this.ballVelocities = new ArrayList<>();
        for (int i = 0; i < this.ballsNumber; i++) {
            this.ballVelocities.add(new Velocity(4, 3));
        }
        this.blocks = new ArrayList<>();
        this.paddlespeed = 2;
        this.paddleWidth = 180;
        this.levelname = "Green 3";
        this.background = new Level3Bg();
        color = Color.green;
        Random rand = new Random();
        for (int i = 0; i <= 4; i++) {
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, g, b);
            for (int j = 0; j <= 5 + i; j++) {
                this.blocks.add(new Block(new Rectangle(new Point(720 - j - (45 * j),
                        260 - i - (25 * i)), 45, 25), randomColor));
            }
        }
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

    @Override
    public Color getColor() {
        return color;
    }

}
