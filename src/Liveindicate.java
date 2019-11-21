import biuoop.DrawSurface;

import java.awt.Color;


/**
 * The type Liveindicate.
 */
public class Liveindicate implements Sprite {
    private Rectangle rect;
    private java.awt.Color color;
    private Counter ch;

    /**
     * Instantiates a new Liveindicate.
     *
     * @param x     the x
     * @param y     the y
     * @param z     the z
     * @param u     the u
     * @param color the color
     * @param ch    the ch
     */
    public Liveindicate(double x, double y, double z, double u, java.awt.Color color, Counter ch) {
        Point uperl = new Point(x, y);
        this.rect = new Rectangle(uperl, z, u);
        this.color = color;
        this.ch = ch;
    }
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
  @Override
    public void timePassed() {


    }
    /**
     * Draw on.
     *
     * @param surface the surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.black);
        surface.drawText(200, 25, "live: " + ch.getValue(), 30);
    }

    /**
     * Remove from game.
     *
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}

