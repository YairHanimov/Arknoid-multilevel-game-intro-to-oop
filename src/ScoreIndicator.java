import biuoop.DrawSurface;

/**
 * The type Score indicator.
 */
public class ScoreIndicator implements Sprite {
    private Rectangle rect;
    private java.awt.Color color;
    private Counter ch;

    /**
     * Instantiates a new Score indicator.
     *
     * @param x     the x
     * @param y     the y
     * @param z     the z
     * @param u     the u
     * @param color the color
     * @param ch    the ch
     */
    public ScoreIndicator(double x, double y, double z, double u, java.awt.Color color, Counter ch) {
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

    @Override
    public void drawOn(DrawSurface surface) {
        surface.drawText(500, 25, "score:" + ch.getValue(), 30);
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



