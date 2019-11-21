import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Leveltwo.
 */
public class Leveltwo implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 12;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballsVelocity = new ArrayList<Velocity>();
        int changeAngle = 0;
        for (int i = 0; i < this.numberOfBalls(); i++) {
            ballsVelocity.add(Velocity.fromAngleAndSpeed(-45 + changeAngle, 4));
            changeAngle += 10;
        }
        return ballsVelocity;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 500;
    }

    @Override
    public String levelName() {
        return "easy style";
    }

    @Override
    public Sprite getBackground() {
        Easebeackground b = new Easebeackground();
        return b;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocklists = new ArrayList<>();
        int bloksizes = 45;
        Color [] color = {Color.cyan, Color.cyan, Color.green, Color.green, Color.yellow, Color.yellow, Color.blue,
                Color.blue, Color.pink, Color.pink, Color.red, Color.red, Color.red, Color.green,
                Color.green};
        for (int i = 0; i < 15; i++) {
            Block newoneb = new Block(770 - bloksizes, 230, 45, 30, color[i], "1");
            blocklists.add(newoneb);
            bloksizes = bloksizes + 45;
        }
        return blocklists;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
