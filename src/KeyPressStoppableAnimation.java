import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Key press stoppable animation.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor    the sensor
     * @param key       the key
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.key = key;
        this.sensor = sensor;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    /**
     * @param d DrawSurface.
     */
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (this.sensor.isPressed(key)) {
            if (!this.isAlreadyPressed) {
                this.stop = true;
            }
        } else if (!this.sensor.isPressed(key)) {
            this.isAlreadyPressed = false;
        }
    }

    /**
     * Sets stop.
     */
    public void setStop() {
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    /**
     * Sets animation.
     *
     * @param anim the animation
     */
    public void setAnimation(Animation anim) {
        this.animation = anim;
    }

    /**
     * @return boolean true for stop the animation.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
