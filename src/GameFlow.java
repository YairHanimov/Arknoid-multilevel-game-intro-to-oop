import biuoop.KeyboardSensor;

import java.util.List;

/**
 * The type Game flow.
 */
public class GameFlow {


    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private int score;
    private int live;
    private int blockss;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar the ar
     * @param ks the ks
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.score = 0;
        this.live = 7;


    }

    /**
     * Run levels.
     *
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {

        for (LevelInformation levelInfo : levels) {


            GameLevel level = new GameLevel(levelInfo, levelInfo.numberOfBalls(), this.score, this.live,
                    levelInfo.numberOfBlocksToRemove(), this.keyboardSensor, this.animationRunner);
            level.initialize();
            this.animationRunner.run(level);


            while (this.live > 0 && level.getcounter() > 0) {
                level.playOneTurn();
                this.score = level.getscore();
                this.live = level.givemelive();
            }

            if (this.live == 0) {
                break;
            }

        }
        if (this.live > 0) {
            this.animationRunner.run(new EndScreen(this.keyboardSensor,
                    "You Win! Your score is:  ", this.score));
            // otherwise the player lost run a lost end screen.
        } else {
            this.animationRunner.run(new EndScreen(this.keyboardSensor, "Game Over. Your score is:   "
                    , this.score));
        }
    }
}
