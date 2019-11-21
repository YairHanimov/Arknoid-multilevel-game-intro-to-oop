import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Leveltre.
 */
public class Leveltre implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballsVelocity = new ArrayList<Velocity>();
        int changeAngle = 4;
        for (int i = 0; i < this.numberOfBalls(); i++) {
            ballsVelocity.add(new Velocity(changeAngle, -2));
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
        return "New York";
    }

    @Override
    public Sprite getBackground() {
        Greenground b = new Greenground();
        return b;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocklists = new ArrayList<>();
        int bloksizes = 45;
        bloksizes = 45;
        for (int k = 0; k < 11; k++) {
            Block newoneb = new Block(790 - bloksizes, 230, 45, 30, Color.red, "1");

            blocklists.add(newoneb);
            bloksizes = bloksizes + 45;

        }
        bloksizes = 45;
        for (int k = 0; k < 10; k++) {
            Block newoneb = new Block(790 - bloksizes, 260, 45, 30, Color.yellow, "1");
            blocklists.add(newoneb);
            bloksizes = bloksizes + 45;
        }
        bloksizes = 45;
        for (int k = 0; k < 9; k++) {
            Block newoneb = new Block(790 - bloksizes, 290, 45, 30, Color.blue, "1");
            blocklists.add(newoneb);
            bloksizes = bloksizes + 45;

        }
        bloksizes = 45;
        for (int k = 0; k < 8; k++) {
            Block newoneb = new Block(790 - bloksizes, 320, 45, 30, Color.pink, "1");
            blocklists.add(newoneb);
            bloksizes = bloksizes + 45;
        }
        bloksizes = 45;
        for (int k = 0; k < 7; k++) {
            Block newoneb = new Block(790 - bloksizes, 350, 45, 30, Color.green, "1");
            blocklists.add(newoneb);
            bloksizes = bloksizes + 45;

        }

        return blocklists;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 45;
    }
}

