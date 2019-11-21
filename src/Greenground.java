import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Greenground.
 */
public class Greenground implements Sprite {
    private Sprite b;

    /**
     * Draw on.
     *
     * @param d the d
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.decode("#445e45"));
        d.fillRectangle(0, 0, 1000, 1000);
        d.drawRectangle(0, 0, 1000, 1000);
        d.setColor(Color.decode("#3C3F3B"));
        d.fillRectangle(60, 400, 100, 400);
        d.setColor(Color.decode("#585A57"));
        d.fillRectangle(90, 350, 40, 50);
        d.setColor(Color.decode("#626461"));
        d.fillRectangle(102, 200, 15, 150);
        d.setColor(Color.decode("#FAC411"));
        d.fillCircle(109, 190, 15);
        d.setColor(Color.decode("#FF5762"));
        d.fillCircle(109, 190, 10);
        d.setColor(Color.decode("#FFFFFF"));
        d.fillCircle(109, 190, 5);
    }

    /**
     * Time passed.
     */
    @Override
    public void timePassed() {

    }

    /**
     * Add to game.
     *
     * @param g the g
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}

