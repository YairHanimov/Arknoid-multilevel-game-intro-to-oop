import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Levelfour.
 */
public class Levelfour implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballsVelocity = new ArrayList<Velocity>();
        int changeAngle = 2;
        for (int i = 0; i < this.numberOfBalls(); i++) {
            ballsVelocity.add(new Velocity(changeAngle, -3));
            changeAngle += 1;
        }
        return ballsVelocity;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "hard level";
    }

    @Override
    public Sprite getBackground() {
        Bluegrownd b = new Bluegrownd();
        return b;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocklists = new ArrayList<>();
        int bloksizes = 45;
        bloksizes = 45;
        for (int k = 0; k < 16; k++) {
            Block newoneb = new Block(790 - bloksizes, 60, 45, 30, Color.red, "1");

            blocklists.add(newoneb);
            bloksizes = bloksizes + 45;

        }
        bloksizes = 45;
        for (int k = 0; k < 16; k++) {
            Block newoneb = new Block(790 - bloksizes, 90, 45, 30, Color.yellow, "1");
            blocklists.add(newoneb);
            bloksizes = bloksizes + 45;
        }
        bloksizes = 45;
        for (int k = 0; k < 16; k++) {
            Block newoneb = new Block(790 - bloksizes, 120, 45, 30, Color.blue, "1");
            blocklists.add(newoneb);
            bloksizes = bloksizes + 45;

        }
        bloksizes = 45;
        for (int k = 0; k < 16; k++) {
            Block newoneb = new Block(790 - bloksizes, 150, 45, 30, Color.pink, "1");
            blocklists.add(newoneb);
            bloksizes = bloksizes + 45;
        }
        bloksizes = 45;
        for (int k = 0; k < 16; k++) {
            Block newoneb = new Block(790 - bloksizes, 180, 45, 30, Color.green, "1");
            blocklists.add(newoneb);
            bloksizes = bloksizes + 45;

        }

        return blocklists;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 80;
    }
}