import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author safwan
 */
public class Level4Bg implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.blue);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.black);
        d.fillCircle(100, 350, 30);
        d.fillCircle(85, 380, 30);
        d.fillCircle(100, 380, 30);
        d.fillCircle(140, 380, 30);
        d.fillCircle(150, 365, 35);
        d.fillCircle(120, 370, 30);
        d.fillCircle(110, 350, 30);
        d.fillCircle(140, 350, 30);
        d.fillCircle(600, 350, 30);
        d.fillCircle(585, 380, 30);
        d.fillCircle(600, 380, 30);
        d.fillCircle(640, 380, 30);
        d.fillCircle(650, 365,  35);
        d.fillCircle(620, 370, 30);
        d.fillCircle(610, 350, 30);
        d.fillCircle(640, 350, 30);
        d.setColor(Color.red);
        for (int i = 0; i < 7; i++) {
            d.drawLine(70 + (i * 15), 400, 85 + (i * 15), 600);
            d.drawLine(570 + (i * 15), 400, 615 + (i * 15), 600);
        }


    }
    @Override
    public void timePassed() {

    }
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);

    }
}
