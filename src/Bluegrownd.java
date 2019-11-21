import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Bluegrownd.
 */
public class Bluegrownd implements Sprite {
    private Sprite b;

    /**
     * Draw on.
     *
     * @param d the d
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.blue);
        d.fillRectangle(0, 0, 1000, 1000);
        d.drawRectangle(0, 0, 1000, 1000);
        d.setColor(Color.decode("#D0D0D0"));
        d.fillCircle(150, 400, 35);
        d.setColor(Color.decode("#D0D0D0"));
        d.fillCircle(190, 390, 40);
        d.setColor(Color.decode("#BEBEBF"));
        d.fillCircle(220, 400, 40);
        d.setColor(Color.decode("#B3B3B5"));
        d.fillCircle(240, 420, 35);
        d.setColor(Color.decode("#D0D0D0"));
        d.fillCircle(620, 490, 35);
        d.setColor(Color.decode("#D0D0D0"));
        d.fillCircle(660, 470, 40);
        d.setColor(Color.decode("#BEBEBF"));
        d.fillCircle(680, 480, 40);
        d.setColor(Color.decode("#B3B3B5"));
        d.fillCircle(700, 500, 35);
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

