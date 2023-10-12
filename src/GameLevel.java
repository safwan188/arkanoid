import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/**
 * @author safwan
 * */
public class GameLevel implements Animation {
    //fields
    private Counter remaindBlocks;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter remainedBalls;
    private Counter score;
    private int rowsnum;
    private AnimationRunner runner;
    private boolean running;
    private List<Double> rows;
    private LevelInformation info;
    /**
     * game constructer.
     * @param levelInformation  levelinfo
     * @param runner  game runner
     * @param score  game score
     */
    public GameLevel(LevelInformation levelInformation, AnimationRunner runner, Counter score) {
        info = levelInformation;
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.remaindBlocks = new Counter();
        this.remainedBalls = new Counter();
        this.score = score;
        this.rowsnum = 0;
        this.rows = new ArrayList<>();
        this.runner = runner;
        this.info.getBackground().addToGame(this);


    }

    /**
     * @return if animition shouldstop
     */
    public boolean shouldStop() {
        return !this.running;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        PauseScreen pause = new PauseScreen(this.runner.getKeyboardSensor());
        KeyPressStoppableAnimation pause1 = new KeyPressStoppableAnimation(runner.getKeyboardSensor(),
                "p", pause);
        if (pause1.shouldBegin()) {
            this.runner.run(pause1);
        }
        if (this.remaindBlocks.getValue() == 0) {
            this.running = false;

        }
        if (this.remainedBalls.getValue() == 0) {
            this.running = false;

        }
        List<Double> heights = new ArrayList<>();
        for (Collidable c : this.getEnvironment().getCollidables()) {
            heights.add(c.getCollisionRectangle().getUpperLeft().getY());
        }
        HashSet<Double> nodupe = new HashSet<Double>(heights);
        nodupe.remove(545.0);
        this.score.increase((this.rowsnum - nodupe.size()) * 100);
        this.rowsnum = nodupe.size();
        this.runner.getGui().getDrawSurface().setColor(Color.black);
        this.runner.getGui().getDrawSurface().drawText(500, 17, "Level Name:" + this.info.levelName(), 15);
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
    }

    /**
     * @return remaining balls in game
     */
    public Counter getRemainingblocks() {
        return this.remaindBlocks;
    }
    /**
     * @return game environment
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }
    /**
     * @param c adds Collidable c to this game environment
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * @param velocities ball velocities
     * @param ballnum ball number
     * makes balls on paddle
     */
    public void makeBalls(List<Velocity> velocities, int ballnum) {

        int dis = (info.paddleWidth() / ballnum);
        int x = 0;
        for (Velocity v :velocities) {
            if (x == 400) {
                x += dis;

            }
            Ball ball1 = new Ball(new Point(400 - (info.paddleWidth() / 2) + x, 540), 5, Color.red);
            ball1.setVelocity(v);
            ball1.setGameEnvironment(this.environment);
            ball1.addToGame(this);
            x += dis;

        }
        this.remainedBalls.increase(info.numberOfBalls());
    }
    /**
     * @param s adds Sprite s to this game sprites
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }
    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle) and add them to the game.
     */
    public void initialize() {
        //balls
        BallRemover ballRemover = new BallRemover(this, this.remainedBalls);
        BlockRemover remover = new BlockRemover(this, this.remaindBlocks);
        ScoreTrackingListener trackingListener = new ScoreTrackingListener(this.score);
        makeBalls(info.initialBallVelocities(), info.numberOfBalls());
        for (Block b: info.blocks()) {
            b.addToGame(this);
            b.addHitListener(remover);
            b.addHitListener(trackingListener);
            this.remaindBlocks.increase(1);
            if (!rows.contains(b.getCollisionRectangle().getUpperLeft().getY())) {
                rows.add(b.getCollisionRectangle().getUpperLeft().getY());
            }
        }

        //side blocks

        Block b1 = new Block(new Rectangle(new Point(765, 35), 35, 530), Color.black);
        Block b2 = new Block(new Rectangle(new Point(0, 35), 35, 530), Color.black);
        Block b3 = new Block(new Rectangle(new Point(0, 0), 800, 35), Color.black);
        Block b4 = new Block(new Rectangle(new Point(0, 565), 800, 35), info.getColor());
        rows.add(35.0);
        rows.add(0.0);
        rows.add(565.0);
        b1.addToGame(this);
        b2.addToGame(this);
        b3.addToGame(this);
        b4.addToGame(this);
        b4.addHitListener(ballRemover);
        ScoreIndicator indicator = new ScoreIndicator(new Rectangle(new Point(0, 0),  800, 20),
                Color.white, this.score);

        this.sprites.addSprite(indicator);
        this.sprites.addSprite(new LevelName(info.levelName()));
        this.rowsnum = rows.size();
    }
    // Run the game -- start the animation loop.
    /**
     * @runs the game-- start the animation loop.
     */
    public void run() {
        //adds paddle
        Paddle paddle = new Paddle(this.runner.getGui().getKeyboardSensor(),
                this.info.paddleWidth(), this.info.paddleSpeed());
        paddle.addToGame(this);
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.running = true;
        this.runner.run(this);
        this.score.increase(100);
    }
    /**
     * @param c collidable
     */
    public void removeCollidable(Collidable c) {
        GameEnvironment clone = this.environment;
        clone.getCollidables().remove(c);
        this.environment = clone;
    }

    /**
     * @param s remove s from sprite collection
     */
    public void removeSprite(Sprite s) {
        SpriteCollection clone = this.sprites;
        clone.getSprites().remove(s);
        this.sprites = clone;
    }

    /**
     * @return remained balls in game
     */
    public Counter getRemainedBalls() {
        return this.remainedBalls;
    }

    /**
     * @return remained blocks in game
     */
    public Counter getRemaindBlocks() {
        return this.remaindBlocks;
    }

    /**
     * @return game score
     */
    public Counter getScore() {
        return score;
    }
}