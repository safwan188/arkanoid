import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author safwan
 */
public class LevelName implements Sprite {
    private String levelname;

    /**
     * constructor.
     * @param name level name
     */
    public LevelName(String name) {
        this.levelname = name;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(500, 19, "Level Name:" + levelname, 14);
    }
    @Override
    public void timePassed() {

    }
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);

    }
}
