import biuoop.KeyboardSensor;

import java.util.List;

/**
 * @author safwan
 */
public class GameFlow {
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;

    /**
     * constructor.
     * @param ar animition runner
     * @param ks keyboardsensor
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.keyboardSensor = ks;
        this.animationRunner = ar;

    }

    /**
     * @param levels levels to run
     */
    public void runLevels(List<LevelInformation> levels) {
        Counter score = new Counter();

        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.animationRunner, score);

            level.initialize();
            while (level.getRemaindBlocks().getValue() > 0 && level.getRemainedBalls().getValue() > 0) {
                level.run();
            }

            if (level.getRemainedBalls().getValue() == 0) {
                GameOver gameOver = new GameOver(this.animationRunner.getKeyboardSensor(), level.getScore().getValue());
                KeyPressStoppableAnimation gameover1 =
                        new KeyPressStoppableAnimation(this.animationRunner.getKeyboardSensor(),
                               "", gameOver);
                this.animationRunner.run(gameover1);
                this.animationRunner.getGui().close();

            }

        }
        YouWin win = new YouWin(this.animationRunner.getKeyboardSensor(), score.getValue());
        KeyPressStoppableAnimation youwin = new KeyPressStoppableAnimation(this.animationRunner.getKeyboardSensor(),
                "", win);
        this.animationRunner.run(youwin);
        this.animationRunner.getGui().close();
    }
}
