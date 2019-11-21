import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;


/**
 * The type Paddle.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rect;
    private java.awt.Color color;
    private GameLevel game;
    private GameEnvironment blockok;
    /**
     * The Games.
     */


    /**
     * Instantiates a new Paddle.
     *
     * @param x        the x
     * @param y        the y
     * @param z        the z
     * @param u        the u
     * @param color    the color
     * @param keyboard the keyboard
     */
    public Paddle(double x, double y, double z, double u,
                  java.awt.Color color, biuoop.KeyboardSensor keyboard) {
        Point uperl = new Point(x, y);
        this.rect = new Rectangle(uperl, z, u);
        this.color = color;
        this.keyboard = keyboard;
    }

    /**
     * Move left.
     */
    public void moveLeft() {
        Point uper2 = new Point(this.rect.getUpperLeft().getX() - 10, this.rect.getUpperLeft().getY());
        this.rect = new Rectangle(uper2, this.rect.getWidth(), this.rect.getHeight());
    }


    /**
     * Move right.
     */
    public void moveRight() {
        Point uper3 = new Point(this.rect.getUpperLeft().getX() + 10, this.rect.getUpperLeft().getY());
        this.rect = new Rectangle(uper3, this.rect.getWidth(), this.rect.getHeight());

    }

    /**
     * Extramemove.
     */
    public void extramemove() {
        Point uper3 = new Point(this.rect.getUpperLeft().getX() + 90000, this.rect.getUpperLeft().getY());
        this.rect = new Rectangle(uper3, this.rect.getWidth(), this.rect.getHeight());
    }
    // Sprite

    /**
     * Time passed.
     */
    public void timePassed() {
        if ((keyboard.isPressed(KeyboardSensor.LEFT_KEY)) && (this.rect.getUpperLeft().getX() > 0)) {
            moveLeft();
        }
        if (((keyboard.isPressed(KeyboardSensor.RIGHT_KEY)))
                && (this.rect.getUpperLeft().getX() + this.rect.getWidth() < 800)) {
            moveRight();
        }
    }

    @Override
    /**
     * Add to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {

        g.addSprite(this);


    }

    /**
     * Draw on.
     *
     * @param surface the surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }

    /**
     * Gets collision rectangle.
     *
     * @return the collision rectangle
     */
    // Collidable
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * Hit velocity.
     *
     * @param x               the ball
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @return the velocity
     */
    public Velocity hit(Ball x, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        double mylinedin = this.rect.getUp().start().distance(this.rect.getUp().end());
        double starter = this.rect.getUp().start().getX();

  /*      if ((collisionPoint.getY() > this.rect.getLeft().start().getY()) &&
                (collisionPoint.getY() < this.rect.getLeft().end().getY())) {
            Velocity newvel = new Velocity(-dx, dy);
            return newvel;
        }
        if ((collisionPoint.getY() > this.rect.getright().start().getY()) &&
                (collisionPoint.getY() < this.rect.getright().end().getY())) {
            Velocity newvel = new Velocity(-dx, dy);
            return newvel;
        }
        */
        if (((collisionPoint.getX() > (this.rect.getUp().start().getX())
                &&
                (collisionPoint.getX() < (starter + (0.2 * mylinedin))) && (dy > 0)))) {
            double speed = Velocity.tospeed(dx, dy);
            Velocity newvel = Velocity.fromAngleAndSpeed(300, speed);
            //   Velocity newvel = new Velocity(dx, -dy);
            return newvel;
        }
        if (((collisionPoint.getX() > (this.rect.getUp().start().getX())
                && (collisionPoint.getX() < (starter + (0.4 * mylinedin))) && (dy > 0)))) {
            double speed = Velocity.tospeed(dx, dy);
            Velocity newvel = Velocity.fromAngleAndSpeed(330, speed);
            //   Velocity newvel = new Velocity(dx, -dy);
            return newvel;
        }
        if (((collisionPoint.getX() > (this.rect.getUp().start().getX() + (0.4 * mylinedin))
                && (collisionPoint.getX() < (starter + (0.6 * mylinedin))) && (dy > 0)))) {
            double speed = Velocity.tospeed(dx, dy);

            Velocity newvel = new Velocity(dx, -dy);
            return newvel;
        }
        if (((collisionPoint.getX() > (this.rect.getUp().start().getX() + (0.6 * mylinedin))
                && (collisionPoint.getX() < (starter + (0.8 * mylinedin))) && (dy > 0)))) {
            double speed = Velocity.tospeed(dx, dy);
            Velocity newvel = Velocity.fromAngleAndSpeed(30, speed);
            //   Velocity newvel = new Velocity(dx, -dy);
            return newvel;
        }
        if (((collisionPoint.getX() > (this.rect.getUp().start().getX() + (0.8 * mylinedin))
                && (collisionPoint.getX() < (starter + (1 * mylinedin))) && (dy > 0)))) {
            double speed = Velocity.tospeed(dx, dy);
            Velocity newvel = Velocity.fromAngleAndSpeed(60, speed);
            //   Velocity newvel = new Velocity(dx, -dy);
            return newvel;
        }


        Velocity newvel = new Velocity(dx, dy);
        return newvel;
    }

}
