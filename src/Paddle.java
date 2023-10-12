import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
/**
 * @author safwan
 */
public class Paddle  implements Sprite, Collidable {
    //fields
    private biuoop.KeyboardSensor keyboard;
    private Rectangle blockShape;
    private int speed;
    private double width;
    //constructor
    /**
     * @param keyboard construct paddle and save keyboard
     * @param speed paddle speed
     * @param width paddle width
     */
    public Paddle(biuoop.KeyboardSensor keyboard, double width, int speed) {
        this.keyboard = keyboard;
        this.width = width;
        this.blockShape = new Rectangle(new Point(400 - (width / 2), 545), width, 20);
        this.speed = speed;
    }
    /**
     * move paddle one step to the left.
     */
    public void moveLeft() {
        this.blockShape = new Rectangle(new Point(this.blockShape.getUpperLeft().getX() - (5 * speed),
                this.blockShape.getUpperLeft().getY()), this.blockShape.getWidth(), this.blockShape.getHeight());
        if (this.blockShape.getUpperLeft().getX() <= 35) {
            this.blockShape = new Rectangle(new Point(35, this.blockShape.getUpperLeft().getY()),
                    this.blockShape.getWidth(), this.blockShape.getHeight());
        }
    }
    /**
     * move paddle one step to the right.
     */
    public void moveRight() {
        this.blockShape = new Rectangle(new Point(this.blockShape.getUpperLeft().getX() + (5 * speed),
                this.blockShape.getUpperLeft().getY()), this.blockShape.getWidth(), this.blockShape.getHeight());

        if (this.blockShape.getUpperLeft().getX() >= 765 - this.blockShape.getWidth()) {
            this.blockShape = new Rectangle(new Point(765 - blockShape.getWidth(),
                    this.blockShape.getUpperLeft().getY()),
                    this.blockShape.getWidth(), this.blockShape.getHeight());
        }
    }
    // Sprite
    /**
     * checks which key is pressed and notifies the right function.
     */
    public void timePassed() {
        if (keyboard.isPressed("a") || keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed("d") || keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * @param d draw paddle on d .
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.yellow);
        d.fillRectangle((int) blockShape.getUpperLeft().getX(),
                (int) blockShape.getUpperLeft().getY(), (int) blockShape.getWidth(), (int) blockShape.getHeight());
    }
    // Collidable
    /**
     * @return blockshape of paddle.
     */
    public Rectangle getCollisionRectangle() {
        return this.blockShape;
    }
    @Override
    // dividing paddle into 5 areas checking in which area the collison point is and changing speed accordingly
    public Velocity hit(Ball hiiter, Point collisionPoint, Velocity currentVelocity) {
        if (collisionPoint.distance(this.blockShape.getUpperLeft()) < (this.blockShape.getWidth()) / 5) {
            currentVelocity = Velocity.fromAngleAndSpeed(240, currentVelocity.getV());
        } else if (collisionPoint.distance(this.blockShape.getUpperLeft()) < 2 * (this.blockShape.getWidth()) / 5) {
            currentVelocity = Velocity.fromAngleAndSpeed(210, currentVelocity.getV());
        } else if (collisionPoint.distance(this.blockShape.getUpperLeft()) < 3 * (this.blockShape.getWidth()) / 5) {
            currentVelocity = Velocity.fromAngleAndSpeed(180, currentVelocity.getV());
        } else if (collisionPoint.distance(this.blockShape.getUpperLeft()) < 4 * (this.blockShape.getWidth()) / 5) {
            currentVelocity = Velocity.fromAngleAndSpeed(150, currentVelocity.getV());
        } else if (collisionPoint.distance(this.blockShape.getUpperLeft()) < (this.blockShape.getWidth())) {
            currentVelocity = Velocity.fromAngleAndSpeed(120, currentVelocity.getV());
        }
        return currentVelocity;
    }
    // Add this paddle to the game.
    /**
     * @param g adds paddle to g
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}