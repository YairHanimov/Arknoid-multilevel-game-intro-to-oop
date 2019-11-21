import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type End screen.
 */
public class EndScreen implements Animation {

    private KeyboardSensor keyboard;
    private boolean stop;
    private int score;
    private String s;

    /**
     * Instantiates a new End screen.
     *
     * @param k     the k
     * @param s     the s
     * @param score the score
     */
    public EndScreen(KeyboardSensor k, String s, int score) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
        this.s = s;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, this.s + this.score, 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

}
