import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author safwan
 */
public class SpriteCollection {
    private List<Sprite> sprites = new ArrayList<Sprite>();
    /**
     * @param s adds s to sprites
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }
    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> clone = new ArrayList<>(sprites);
        for (Sprite s: clone) {
            s.timePassed();
        }
    }
    /**
     * @param d  call drawOn(d) on all sprites.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s:sprites) {
            s.drawOn(d);
        }
    }
    /**
     * @return this sprite collection
     */
    public List<Sprite> getSprites() {
        return this.sprites;
    }
}
