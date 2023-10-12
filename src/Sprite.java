import biuoop.DrawSurface;
/**
 * @author safwan
 */
public interface Sprite {
    /**
     * @param d draw the sprite to the screen d
     */
    void drawOn(DrawSurface d);

    /**
     * // notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * @param g adds sprite to game g
     */
    void addToGame(GameLevel g);
}
