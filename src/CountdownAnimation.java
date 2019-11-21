import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;


/**
 * The type Countdown animation.
 */
// The CountdownAnimation will display the given gameScreen,
// for numOfSeconds seconds, and on top of them it will show
// a countdown from countFrom back to 1, where each number will
// appear on the screen for (numOfSeconds / countFrom) secods, before
// it is replaced with the next one.
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean flage;
    private int counter;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param countFrom    the count from
     * @param gameScreen   the game screen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        flage = false;
        counter = countFrom;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        String s;
        Sleeper sleeper = new Sleeper();
        gameScreen.drawAllOn(d);
        if (counter == 0) {
            s = "GO";
        } else {
            s = Integer.toString(counter);
        }
        if (counter == -1) {
            flage = true;
        } else {
            d.setColor(Color.red);
            d.drawText(d.getWidth() / 2 - 60, 400, s, 70);
            --counter;

        }

        sleeper.sleepFor((long) ((1000) * this.numOfSeconds) / (countFrom + 1));
    }

    @Override
    public boolean shouldStop() {
        return flage;
    }
}