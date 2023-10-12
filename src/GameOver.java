import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * @author safwan
 */
public class GameOver implements Animation {
    private boolean stop;
    private KeyboardSensor keyboard;
    private int score;
    /**
     * constructer.
     * @param k keyboard
     * @param score score
     */
    public GameOver(KeyboardSensor k, int score) {
        this.keyboard = k;
        this.score = score;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.red);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.black);
        d.drawText(300, d.getHeight() / 2, "Game Over your score is : " + score, 32);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
