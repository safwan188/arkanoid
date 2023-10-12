import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author safwan
 */
public class Level1Bg implements Sprite {
    /**
     * constructor.
     */
    public Level1Bg() {

    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.gray);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.blue);
        for (int i = 0; i < 7; i++) {
            d.drawCircle(400, 170, 100 - (i * 10));
        }
        d.drawLine(280, 170, 520, 170);
        d.drawLine(400, 290, 400, 50);

    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);

    }
}
