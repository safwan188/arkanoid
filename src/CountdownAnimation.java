import biuoop.DrawSurface;
import biuoop.Sleeper;
import java.awt.Color;
/**
 * @author safwan
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int count;
    private SpriteCollection collection;
    private boolean running;
    private Sleeper sleeper;
    private int countfor;
    /**
     * constructor.
     * @param numOfSeconds second to play animition
     * @param countFrom count from number
     * @param gameScreen sprite collection
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.collection = gameScreen;
        this.count = countFrom;
        this.running = false;
        this.sleeper = new Sleeper();
        this.countfor = countFrom;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        long time = (long) ((this.numOfSeconds * 1000) / this.countfor);
        if (count != countfor) {
        this.sleeper.sleepFor(time);
        }
        this.collection.drawAllOn(d);
        if (this.count > 0) {
            d.setColor(Color.black);
            d.drawText(400, 300, String.valueOf(this.count), 50);
            this.count--;
        } else if (this.count == 0) {
            d.setColor(Color.black);
            d.drawText(400, 300, "GO", 50);
            this.count--;
        } else {
            this.running = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return running;
    }
}
