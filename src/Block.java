import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Block.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rect;
    private java.awt.Color color;
    private GameLevel game;
    private GameEnvironment blockok;
    private String ch;
    private List<HitListener> hitListeners;
    /**
     * The Games.
     */


    /**
     * Instantiates a new Block.
     *
     * @param x     the x
     * @param y     the y
     * @param z     the z
     * @param u     the u
     * @param color the color
     * @param ch    the ch
     */
    public Block(double x, double y, double z, double u, java.awt.Color color, String ch) {
        Point uperl = new Point(x, y);
        this.rect = new Rectangle(uperl, z, u);
        this.color = color;
        this.ch = ch;
        hitListeners = new ArrayList<>();
    }

    /**
     * Gets collision rectangle.
     *
     * @return the collision rectangle
     */

    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

   @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        if ((collisionPoint.getX() > this.rect.getDown().start().getX())
                && (collisionPoint.getX() < this.rect.getDown().end().getX())) {
            Velocity newvel = new Velocity(dx, -dy);
            if (this.ch == "1" || this.ch == "X") {
                this.notifyHit(hitter);
                this.ch = "X";

            } else {
                this.notifyHit(hitter);
                this.ch = "1";

            }
            return newvel;
        }
        if ((collisionPoint.getY() > this.rect.getLeft().start().getY())
                && (collisionPoint.getY() < this.rect.getLeft().end().getY())) {
            Velocity newvel = new Velocity(-dx, dy);
            if (this.ch == "1" || this.ch == "X") {
                this.notifyHit(hitter);
                this.ch = "X";

            } else {
                this.notifyHit(hitter);
                this.ch = "1";

            }

            return newvel;

        }
        if ((collisionPoint.getY() > this.rect.getright().start().getY())
                && (collisionPoint.getY() < this.rect.getright().end().getY())) {
            Velocity newvel = new Velocity(-dx, dy);
            if (this.ch == "1" || this.ch == "X") {
                this.notifyHit(hitter);
                this.ch = "X";

            } else {
                this.notifyHit(hitter);
                this.ch = "1";

            }
            return newvel;
        }
        if ((collisionPoint.getX() > this.rect.getUp().start().getX())
                && (collisionPoint.getX() < this.rect.getUp().end().getX())) {
            Velocity newvel = new Velocity(dx, -dy);
            if (this.ch == "1" || this.ch == "X") {
                this.notifyHit(hitter);
                this.ch = "X";

            } else {
                this.notifyHit(hitter);
                this.ch = "1";

            }
            return newvel;

        }


       /* if ((collisionPoint.getX() == this.rect.getDown().start().getX()) ||
         (collisionPoint.getX() == this.rect.getDown().end().getX())) {
            Velocity newvel= new Velocity(-dx,-dy);
            return newvel;

        } */
        Velocity newvel = new Velocity(-dx, -dy);
        if (this.ch == "1" || this.ch == "x") {
            this.notifyHit(hitter);
            this.ch = "X";

        } else {
            this.notifyHit(hitter);
            this.ch = "1";

        }
        return newvel;
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
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
        surface.setColor(Color.WHITE);
        surface.drawText((int) this.rect.getUpperLeft().getX()
                        + ((((int) this.rect.getUp().end().getX()) - ((int) this.rect.getUpperLeft().getX())) / 2),
                (int) this.rect.getUpperLeft().getY() + ((((int) this.rect.getLeft().end().getY()) - ((int)
                        this.rect.getUpperLeft().getY())) / 2) + 8,
                String.valueOf(this.ch), 20);
    }

    /**
     * Time passed.
     */
    public void timePassed() {


    }

    /**
     * Add to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Remove from game.
     *
     * @param gamee the game
     */
    public void removeFromGame(GameLevel gamee) {
        game.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {

        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }

    /**
     * notifyHit.
     *
     * @param hitterr the ball
     */
    private void notifyHit(Ball hitterr) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitterr);
        }
    }

    /**
     * Gets .
     *
     * @return the
     */
    public String getch() {
        return this.ch;
    }

}
