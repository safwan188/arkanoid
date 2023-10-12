import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author safwan
 */
public class ScoreIndicator implements Sprite {
    private Rectangle shape;
    private Color color;
    private Counter score;
    //constructor
    /**
     * @param shape rectangle shape
     * @param color color
     * @param score score counter
     */
    public ScoreIndicator(Rectangle shape, Color color, Counter score) {
        this.shape = shape;
        this.color = color;
        this.score = score;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.fillRectangle((int) shape.getUpperLeft().getX(),
                (int) shape.getUpperLeft().getY(),
                (int) shape.getWidth(),
                (int) shape.getHeight());
        d.setColor(Color.black);
        String s = "Score:" + String.valueOf(this.score.getValue());
        d.drawText(360, 18, s, 15);

    }

    @Override
    public void timePassed() {

    }

    /**
     * @return score
     */
    public Counter getScore() {
        return score;
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);

    }
}
