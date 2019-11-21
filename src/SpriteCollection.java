import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Sprite collection.
 */
public class SpriteCollection {

    private List<Sprite> spirits;

    /**
     * Instantiates a new Sprite collection.
     */
    public SpriteCollection() {
        this.spirits = new ArrayList<Sprite>();
    }

    /**
     * Add sprite.
     *
     * @param s the s
     */
    public void addSprite(Sprite s) {

        spirits.add(s);
    }

    /**
     * Remove sprite.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        spirits.remove(s);
    }

    /**
     * Notify all time passed.
     */
// call timePassed() on all sprites.
    public void notifyAllTimePassed() {
        List<Sprite> copyList = new ArrayList<Sprite>(spirits);

        for (int i = 0; i < copyList.size(); i++) {
            copyList.get(i).timePassed();
        }
    }

    /**
     * Draw all on.
     *
     * @param d the d
     */
// call drawOn(d) on all sprites.
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < spirits.size(); i++) {
            spirits.get(i).drawOn(d);
        }
    }
}
