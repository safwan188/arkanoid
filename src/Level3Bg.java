import biuoop.DrawSurface;

import java.awt.Color;

/***
 * @author safwan
 */
public class Level3Bg implements Sprite {
    /**
     * constructor.
     */
    public Level3Bg() {

    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.green);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.black);
        d.fillRectangle(70, 400, 140, 300);
        d.setColor(Color.white);
        d.fillRectangle(80, 410, 120, 150);
        d.setColor(Color.black);
        for (int i = 0; i <= 4; i++) {
            d.fillRectangle(80, 430 + (i * 30), 120, 10);
            d.fillRectangle(95 + (i * 25), 410, 10, 150);

        }
        d.setColor(Color.gray);
        d.fillRectangle(120, 350, 40, 50);
        d.fillRectangle(130, 150, 20, 200);
        d.setColor(Color.orange);
        d.fillCircle(140, 140, 15);
        d.setColor(Color.red);
        d.fillCircle(140, 140, 8);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);

    }
}
