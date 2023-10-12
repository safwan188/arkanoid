import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author safwan
 */
public class KeyPressStoppableAnimation implements Animation {
    private Animation animation;
    private String key;
    private KeyboardSensor sensor;
    private boolean shouldstop;

    /**
     * construtor.
     * @param sensor keyboard sensor
     * @param key string key
     * @param animation animition
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.key = key;
        this.sensor = sensor;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
            animation.doOneFrame(d);
    }

    /**
     * @return if key is pressed returns true
     */
    public boolean shouldBegin() {
        if (this.sensor.isPressed(key)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean shouldStop() {
        if (sensor.isPressed(KeyboardSensor.SPACE_KEY)) {
            return true;
        }
        return false;
    }
}
