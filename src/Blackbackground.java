import biuoop.DrawSurface;

import java.awt.Color;


/**
 * The type Blackbackground.
 */
public class Blackbackground implements Sprite {
    private Sprite b;

    /**
     * Draw on.
     *
     * @param d the d
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(0, 0, 1000, 1000);
        d.drawRectangle(0, 0, 1000, 1000);
        d.setColor(Color.BLUE);
        d.drawLine(748 / 2, 40, 748 / 2, 320);
        d.drawLine(748 / 2 - 160, 180, 748 / 2 + 160, 180);
        d.drawCircle(380, 170, 40);
        d.drawCircle(380, 170, 80);
        d.drawCircle(380, 170, 120);
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
