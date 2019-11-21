import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Easebeackground.
 */
public class Easebeackground implements Sprite {

    private Sprite b;

    /**
     * Draw on.
     *
     * @param d the d
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, 1000, 1000);
        d.drawRectangle(0, 0, 1000, 1000);
        d.setColor(Color.BLUE);
        d.setColor(Color.decode("#FCFF81"));
        d.fillCircle(120, 120, 60);
        d.setColor(Color.decode("#F5FC37"));
        d.fillCircle(120, 120, 50);
        d.setColor(Color.decode("#F6FC43"));
        d.fillCircle(120, 120, 40);
        d.setColor(Color.orange);
        d.drawLine(120, 120, 1, 600 / 3 + 2 * 30);
        d.drawLine(120, 120, 1, 800 / 3 + 2 * 30);
        d.drawLine(120, 120, 1, 700 / 3 + 2 * 30);
        d.drawLine(120, 120, 1, 1200 / 3 + 2 * 30);
        d.drawLine(120, 120, 1, 900 / 3 + 2 * 30);
        d.drawLine(120, 120, 1, 1000 / 3 + 2 * 30);
        d.drawLine(120, 120, 8, 600 / 3 + 2 * 30);
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

