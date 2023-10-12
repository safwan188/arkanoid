import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * @author safwan
 */
public class YouWin implements Animation {
    private boolean stop;
    private KeyboardSensor keyboard;
    private int score;

    /**
     * constuctor.
     * @param k keyboard sensor
     * @param score score
     */
    public YouWin(KeyboardSensor k, int score) {
        this.keyboard = k;
        this.score = score;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {

        d.setColor(Color.black);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.white);
        d.drawText(300, d.getHeight() / 2, "You Win your score is :" + score, 32);

    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
